package com.bonc.domain;

import java.io.Serializable;

/**
 * Created by 王小浪 on 2018/8/1.
 */
public class Data implements Serializable{
    private  String name;
    private  Integer value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", value:" + value +
                '}';
    }
}
