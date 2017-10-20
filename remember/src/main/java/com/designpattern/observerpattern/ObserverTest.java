package com.designpattern.observerpattern;


public class ObserverTest {

    public static void main(String[] args) {
        VideoSite vs = new VideoSite();
        vs.registerObserver(new VideoFans("LiLei"));
        vs.addVedio("斗破苍穹");
    }
}
