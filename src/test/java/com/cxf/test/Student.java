package com.cxf.test;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class Student {
    private Long id;
    private String name;

    public static void main(String[] args) {
        Student student = new StudentBuilder().name("cxf").id(1L).build();
        System.out.println(student);
    }
}
