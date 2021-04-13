package com.serialize.dto;

public class PersonVo {

    private String name;
    private String category;

    public PersonVo(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

}
