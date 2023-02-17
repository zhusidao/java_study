package com.example.design_patterns.chain_of_responsibility;

import java.util.Arrays;

/**
 * 为请求创建一个接受者对象的链
 *
 * @author ZhuSiDao
 * @date 2020/11/27
 */
public class App {
    public static void main(String[] args) {
        CompositeFilter compositeFilter = new CompositeFilter();
        compositeFilter.setFilters(Arrays.asList(new CosFilter(), new HttpFilter()));
        compositeFilter.doFilter(new Request("request"), new Response("response"),
                new CompositeFilter.VirtualFilterChain(compositeFilter.getFilters()));
    }
}
