package com.designpattern.adapterpattern;

public class EnPlugin implements EnPluginInterface {

	@Override
	public void chargeWith3pins() {
		System.out.println("charge with EnPlugin");
	}

}
