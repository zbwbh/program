package com.baseframe.entity;

public class Member {

    private Integer id;

    private String name;

    private String tel;

    private String password;

    private Integer provinceId;

    private Integer cityId;

    private Integer regionId;

    private String remark;

    private String createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Member [id=" + id
                + ", name="
                + name
                + ", tel="
                + tel
                + ", password="
                + password
                + ", provinceId="
                + provinceId
                + ", cityId="
                + cityId
                + ", regionId="
                + regionId
                + ", remark="
                + remark
                + ", createTime="
                + createTime
                + "]";
    }

    
}
