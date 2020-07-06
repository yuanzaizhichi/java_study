package com.cxf.wordorder;

import java.util.HashMap;
import java.util.Map;

public class ReqBuilder implements Builder {
    private Map<String, Object> map = new HashMap<>();
    private Car car = new Car();

    public ReqBuilder() {
    }

    public ReqBuilder(Map<String, Object> map, Car car) {
        if (map.get("map") != null) {
            this.map = (Map<String, Object>) map.get("map");
        } else {
            this.map = map;
        }
        this.car = car;
    }

    @Override
    public void buildpar1() {
        car.setPar1((String) map.get("req1"));
    }

    @Override
    public void buildpar2() {
        car.setPar2((String) map.get("req2"));
    }

    @Override
    public Car buildResult() {
        return car;
    }
}
