package com.example.design_patterns.chain_of_responsibility;

/**
 * @author ZhuSiDao
 * @date 2020/11/26
 */
public interface FilterChain {

    void doFilter(Request request, Response response);

}

