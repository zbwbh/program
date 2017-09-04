package com.baseframe.entity.auxiliary;

/**
 * car brand entity class
 * 
 *
 * @author koala
 * @since 2017年9月1日
 */
public class CarBrand {

    private Integer carBrandId;

    private String carBrandName;

    private String brandLogo;// this property will not be used.It has the url replace

    private Character carFirstLetter;

    private String canFindPartShow;
    // other properties will not be used.

    public String getCanFindPartShow() {
        return canFindPartShow;
    }

    public Character getCarFirstLetter() {
        return carFirstLetter;
    }

    public void setCarFirstLetter(Character carFirstLetter) {
        this.carFirstLetter = carFirstLetter;
    }

    public void setCanFindPartShow(String canFindPartShow) {
        this.canFindPartShow = canFindPartShow;
    }

    public Integer getCarBrandId() {
        return carBrandId;
    }

    public void setCarBrandId(Integer carBrandId) {
        this.carBrandId = carBrandId;
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public String getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(String brandLogo) {
        this.brandLogo = brandLogo;
    }

}
