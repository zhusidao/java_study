package com.example.design_patterns.chain_of_responsibility;

/**
 * @author ZhuSiDao
 * @date 2020/11/26
 */
public class HttpFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain filterChain) {
        request.setHeader(request.getHeader() + " http");
        response.setHeader(response.getHeader() + " http");
        System.out.println("HttpFilter: " + request.getHeader());
        System.out.println("HttpFilter: " + response.getHeader());
        filterChain.doFilter(request, response);
    }
}
