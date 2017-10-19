package com.designpattern.adapterpattern;

/**
 * 
 * 什么是适配器模式
 * 顾名思义，适配器模式是用来适配的，当你想使用一个已有的类，但是这个类的接口跟你的
 * 有不一样，不能直接拿来用，这个时候你就需要一个适配器来帮你了
 *
 * @author zbw
 * @since 2017年10月19日
 */
public interface CnPluginInterface {

	void chargeWith2Pins();
}
