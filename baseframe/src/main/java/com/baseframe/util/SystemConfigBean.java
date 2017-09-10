package com.baseframe.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class SystemConfigBean {

    @Value("#{configProperties['title']}")
    private String title;

    @Value("#{configProperties['orderMaodelPath']}")
    private String orderModelPath;

    @Value("#{configProperties['domain']}")
    private String domain;

    @Value("#{configProperties['imgPath']}")
    private String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getOrderModelPath() {
        return orderModelPath;
    }

    public void setOrderModelPath(String orderModelPath) {
        this.orderModelPath = orderModelPath;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
