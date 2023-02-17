package com.hainet.spring.test.dbunit.sample.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class Person {

    private int id;

    private String name;
}
