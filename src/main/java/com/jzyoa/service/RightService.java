package com.jzyoa.service;

import java.util.List;

import com.jzyoa.pojo.TbRight;

public interface RightService {

	TbRight getById(Integer rightId);

	List<TbRight> listAll(TbRight right);

}
