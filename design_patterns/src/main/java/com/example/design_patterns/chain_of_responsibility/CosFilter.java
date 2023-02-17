package com.example.design_patterns.chain_of_responsibility;

/**
 * @author ZhuSiDao
 * @date 2020/11/26
 */
public class CosFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setHeader(request.getHeader() + " cos");
        response.setHeader(response.getHeader() + " cos");
        System.out.println("HttpFilter: " + request.getHeader());
        System.out.println("HttpFilter: " + response.getHeader());
        filterChain.doFilter(request, response);
    }
}
