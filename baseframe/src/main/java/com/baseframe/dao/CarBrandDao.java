package com.baseframe.dao;

import java.util.List;

import com.baseframe.entity.auxiliary.CarBrand;

public interface CarBrandDao {

    List<CarBrand> listCarBrandsByFirstLetter(CarBrand cb);
}
