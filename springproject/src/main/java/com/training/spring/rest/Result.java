package com.training.spring.rest;


public class Result {

    private String desc;
    private String name;

    public String getDesc() {
        return this.desc;
    }

    public Result setDesc(final String descParam) {
        this.desc = descParam;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Result setName(final String nameParam) {
        this.name = nameParam;
        return this;
    }

}
