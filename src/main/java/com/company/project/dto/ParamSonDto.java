package com.company.project.dto;

import java.io.Serializable;

public class ParamSonDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;

    public ParamSonDto() {
        super();
    }

    public ParamSonDto(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}
