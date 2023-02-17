package com.example.design_patterns.chain_of_responsibility;

/**
 * @author ZhuSiDao
 * @date 2020/11/26
 */
public class Request {

    public Request(String header) {
        this.header = header;
    }

    private String header;

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
