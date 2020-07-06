package com.cxf.wordorder;

import java.util.HashMap;
import java.util.Map;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Builder construct() {
        builder.buildpar1();
        builder.buildpar2();
        return builder;
    }

    public static void main(String[] args) {
        //模拟req请求参数
//        Map<String,Object> request = new HashMap<>();
//        request.put("req1","req1");
//        request.put("req2","req2");

        //模拟req请求参数
        Map<String, Object> request = new HashMap<>();
        Map<String, Object> map = new HashMap<>();
        map.put("req1", "map1");
        map.put("req2", "map2");
        request.put("map", map);

        Builder builder;
        builder = new ReqBuilder(request, new Car());
        Director director = new Director(builder);
        System.out.println(director.construct().buildResult());
    }
}
