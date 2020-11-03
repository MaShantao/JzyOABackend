package com.marico.ncovreportsystem.service;

import java.util.List;

import com.marico.ncovreportsystem.pojo.TbRight;

public interface RightService {

	TbRight getById(Integer rightId);

	List<TbRight> listAll(TbRight right);

}
