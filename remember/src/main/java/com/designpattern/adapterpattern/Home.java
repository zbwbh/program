package com.designpattern.adapterpattern;

/**
 * * 什么是适配器模式
 * 顾名思义，适配器模式是用来适配的，当你想使用一个已有的类，但是这个类的接口跟你的
 * 有不一样，不能直接拿来用，这个时候你就需要一个适配器来帮你了
 *
 * 
 *
 * @author zbw
 * @since 2017年10月19日
 */
//在国家中内充电
public class Home {

	private CnPluginInterface cnPlugin;
	
	public Home() {};
	
	//初始化时可用
	public Home(CnPluginInterface cnPlugin) {
		this.cnPlugin = cnPlugin;
	}
	
	//不在创建新的home对象时调用该方法添加接口
	public void setPlugin(CnPluginInterface cnPlugin) {
		this.cnPlugin = cnPlugin;
	}
	
	public void charge() {
		cnPlugin.chargeWith2Pins();
	}
}

