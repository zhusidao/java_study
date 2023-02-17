package com.example.design_patterns.chain_of_responsibility;

import java.util.ArrayList;
import java.util.List;

public class CompositeFilter implements Filter {

    private List<? extends Filter> filters = new ArrayList<>();


    public void setFilters(List<? extends Filter> filters) {
        this.filters = new ArrayList<>(filters);
    }

    @Override
    public void init() {
        for (Filter filter : this.filters) {
            filter.init();
        }
    }

    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        for (int i = this.filters.size(); i-- > 0; ) {
            Filter filter = this.filters.get(i);
            filter.destroy();
        }
    }

    public List<? extends Filter> getFilters() {
        return filters;
    }

    public static class VirtualFilterChain implements FilterChain {

        private final List<? extends Filter> additionalFilters;

        private int currentPosition = 0;

        public VirtualFilterChain(List<? extends Filter> additionalFilters) {
            this.additionalFilters = additionalFilters;
        }

        @Override
        public void doFilter(final Request request, final Response response) {
            if (this.currentPosition == this.additionalFilters.size()) {
                return;
            }
            this.currentPosition++;
            Filter nextFilter = this.additionalFilters.get(this.currentPosition - 1);
            nextFilter.doFilter(request, response, this);
        }
    }

}