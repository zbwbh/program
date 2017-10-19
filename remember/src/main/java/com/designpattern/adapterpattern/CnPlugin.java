package com.designpattern.adapterpattern;

/**
 * 实现国标插座的充电方法
 * 
 *
 * @author zbw
 * @since 2017年10月19日
 */
public class CnPlugin implements CnPluginInterface {

	@Override
	public void chargeWith2Pins() {
		System.out.println("charge with CnPlugin");
	}

}
