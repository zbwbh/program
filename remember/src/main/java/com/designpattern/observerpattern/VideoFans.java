package com.designpattern.observerpattern;


public class VideoFans implements Observer{

    private String name;
    
    
    public VideoFans(String name) {
        this.name = name;
    }
    
    @Override
    public void update(Subject s) {
        System.out.println(this.name + ", 有新视频可以看了，新的" + s);
//        System.out.println(s);
    }

}
