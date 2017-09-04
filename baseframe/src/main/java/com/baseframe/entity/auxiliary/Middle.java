package com.baseframe.entity.auxiliary;

import java.util.List;

public class Middle {

    private String dateTime;

    private String typeByClass;

    private String typeByLabel;

    private String id;

    private List<String> list;

    private String dateNumber;

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getTypeByClass() {
        return typeByClass;
    }

    public void setTypeByClass(String typeByClass) {
        this.typeByClass = typeByClass;
    }

    public String getTypeByLabel() {
        return typeByLabel;
    }

    public void setTypeByLabel(String typeByLabel) {
        this.typeByLabel = typeByLabel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public String getDateNumber() {
        return dateNumber;
    }

    public void setDateNumber(String dateNumber) {
        this.dateNumber = dateNumber;
    }

    @Override
    public String toString() {
        return "Middle [dateTime=" + dateTime
                + ", typeByClass="
                + typeByClass
                + ", typeByLabel="
                + typeByLabel
                + ", id="
                + id
                + ", list="
                + list
                + ", dateNumber="
                + dateNumber
                + "]";
    }

}
