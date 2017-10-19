package com.designpattern.adapterpattern;

public class PluginAdapter implements CnPluginInterface{

	private EnPluginInterface enPlugin;
	//适配器
	public PluginAdapter(EnPluginInterface enPlugin) {
		this.enPlugin = enPlugin;
	}
	//这是重点，适配器实现了英标的插头，然后重载了国标的充电方法为英标的方法
	@Override
	public void chargeWith2Pins() {
		enPlugin.chargeWith3pins();
	}

}
