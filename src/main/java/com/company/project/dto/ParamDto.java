package com.company.project.dto;

import java.io.Serializable;
import java.util.List;

public class ParamDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private String str;
    private ParamSonDto psd;
    private List<ParamSonDto> lpd;

    public ParamDto() {
        super();
    }

//    public ParamDto(int id, String name, String str, ParamSonDto psd, List<ParamSonDto> lpd) {
//        super();
//        this.id = id;
//        this.name = name;
//        this.str = str;
//        this.psd = psd;
//        this.lpd = lpd;
//
//    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStr() {
        return str;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public ParamSonDto getPsd() {
        return psd;
    }

    public void setPsd(ParamSonDto psd) {
        this.psd = psd;
    }

    public List<ParamSonDto> getLpd() {
        return lpd;
    }

    public void setLpd(List<ParamSonDto> lpd) {
        this.lpd = lpd;
    }
}
