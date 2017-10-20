package com.designpattern.observerpattern;

import java.util.ArrayList;

/**
 * 因为这个类是最重要的，所以我把概念写在这里吧
 * 一句话，观察者模式（Observer Pattern）就是一种“发布者-订阅者”的模式，
 * 有时也被称为“模型-试图”模式、“源-监听者”模式等，
 * 在这种模式中，由一个目标对象来管理所有依赖于它的观察者对象，并且当这个目标对象发生
 * 改变时，会主动向他的观察者发出通知
 * 
 * 
 * 注意看下面内容的结构，发现都是有连带关系的，而且最开始创建
 * 观察者和被观察者，他们都不能直接单独存在，因为都是互相依赖的（单独创建一个会因为缺少另一个接口而出现编译错误）
 * 特别要注意的是下面的notifyAllObserver方法和addVedio方法
 * addVedio是用来添加新产品的，而nodifyAllObserver是用来通知所有用户的，如果按照正常思维逻辑
 * 不算下面的getVedio方法，那么应该是倒序书写的，也就是：
 * 1、toString，新的vedio产生
 * 2、addVedio，添加新的vedio
 * 3、notifyAllObserver当中的update通过循环通知给所有用户
 *
 * @author zbw
 * @since 2017年10月20日
 */
public class VideoSite implements Subject {

    private ArrayList<Observer> userlist;
    
    private ArrayList<String> videos;
    
    
    public VideoSite() {
        userlist = new ArrayList<Observer>();
        videos = new ArrayList<String>();
    }
    @Override
    public void registerObserver(Observer o) {
        userlist.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        userlist.remove(o);
    }

    @Override
    public void notifyAllObserver() {//通知所有观察者，loop
        for (Observer o : userlist) {
            o.update(this);//this指代当前视频网站的video，也就是说每个用户都更新该video
        }
    }
    
    public void addVedio(String video) {
        //每次新增一个产品，则通知用户
        this.videos.add(video);
        notifyAllObserver();
    }
    
    public ArrayList<String> getVideos() {
        return videos;
    }
    
    public String toString() {
        return videos.toString();//toString的好处是在碰到“println”之类的输出方法时自动调用
        //不用显式打出来，所以在其他地方调用update方法会直接输出videos的值
    }

}
