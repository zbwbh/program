package com.baseframe.entity.auxiliary;

import java.util.List;


public class Regions {

    private Integer regionId;

    private Integer pRegionId;

    private String regionPath;

    private Integer regionGrade;

    private String localName;

    private String zipcode;

    private String cod;

    private List<Regions> children;

    private String text;

    //mui联动使用
    public String getText() {
        return localName;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Regions> getChildren() {
        return children;
    }

    public void setChildren(List<Regions> children) {
        this.children = children;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public Integer getpRegionId() {
        return pRegionId;
    }

    public void setpRegionId(Integer pRegionId) {
        this.pRegionId = pRegionId;
    }

    public String getRegionPath() {
        return regionPath;
    }

    public void setRegionPath(String regionPath) {
        this.regionPath = regionPath == null ? null : regionPath.trim();
    }

    public Integer getRegionGrade() {
        return regionGrade;
    }

    public void setRegionGrade(Integer regionGrade) {
        this.regionGrade = regionGrade;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName == null ? null : localName.trim();
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode == null ? null : zipcode.trim();
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod == null ? null : cod.trim();
    }
}
