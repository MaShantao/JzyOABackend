package com.jzyoa.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzyoa.entity.PageResult;
import com.jzyoa.entity.Result;
import com.jzyoa.mapper.TbUserMapper;
import com.jzyoa.pojo.TbUser;
import com.jzyoa.pojo.TbUserExample;
import com.jzyoa.pojo.TbUserExample.Criteria;
import com.jzyoa.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	TbUserMapper userMapper;

	@Override
	public Result checkLogin(TbUser user) {
		TbUserExample userExample = new TbUserExample();
		Criteria createCriteria = userExample.createCriteria();
		if (user.getLoginName() != null)
			createCriteria.andLoginNameEqualTo(user.getLoginName());
		List<TbUser> selectByExample = userMapper.selectByExample(userExample);
		if (selectByExample == null || selectByExample.size() == 0)
			return new Result(false, "账号不存在");
		if (!selectByExample.get(0).getLoginPasswd().equals(user.getLoginPasswd()))
			return new Result(false, "用户名或者密码错误");
		return new Result(true, "登录成功");
	}

	@Override
	public PageResult list(TbUser user, Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbUserExample userExample = new TbUserExample();
		Criteria createCriteria = userExample.createCriteria();
		if (user != null) {
			if (user.getUserId() != null && !user.getUserId().equals(0)) {
				createCriteria.andUserIdEqualTo(user.getUserId());
			}
			if (user.getName() != null && !user.getName().equals("")) {
				createCriteria.andNameLike("%" + user.getName() + "%");
			}
			if (user.getLoginName() != null && !user.getLoginName().equals("")) {
				createCriteria.andLoginNameLike("%" + user.getLoginName() + "%");
			}
			if (user.getUserStatus() != null && !user.getUserStatus().equals(0)) {
				createCriteria.andUserStatusEqualTo(user.getUserStatus());
			}
		}

		Page<TbUser> pages = (Page<TbUser>) userMapper.selectByExample(userExample);
		return new PageResult(pages.getTotal(), pages.getResult());
	}

	@Override
	public TbUser getByLoginName(String loginName) {
		TbUserExample userExample = new TbUserExample();
		Criteria createCriteria = userExample.createCriteria();
		createCriteria.andLoginNameEqualTo(loginName);
		return userMapper.selectByExample(userExample).size() > 0 ? userMapper.selectByExample(userExample).get(0)
				: null;
	}

	@Override
	public Result save(TbUser addUser) {
		return userMapper.insert(addUser) > 0 ? new Result(true, "保存用户成功") : new Result(false, "保存用户失败");
	}

	@Override
	public boolean checkLoginNameExist(String loginName) {
		TbUserExample userExample = new TbUserExample();
		Criteria createCriteria = userExample.createCriteria();
		if (loginName != null)
			createCriteria.andLoginNameEqualTo(loginName);
		return userMapper.selectByExample(userExample).size() > 0;
	}

	@Override
	public Result update(TbUser addUser) {
		return userMapper.updateByPrimaryKey(addUser) > 0 ? new Result(true, "用户更新成功") : new Result(false, "用户更新失败");
	}

	@Override
	public TbUser getByUserId(Integer userId) {
		TbUserExample userExample = new TbUserExample();
		Criteria createCriteria = userExample.createCriteria();
		if (userId != null)
			createCriteria.andUserIdEqualTo(userId);
		List<TbUser> selectByExample = userMapper.selectByExample(userExample);
		return selectByExample.size() > 0 ? selectByExample.get(0) : null;
	}

	@Override
	public Result delete(Integer userId) {
		TbUser byUserId = getByUserId(userId);
		if (byUserId == null)
			return new Result(false, "该用户不存在");
		byUserId.setUserStatus(2);
		return userMapper.updateByPrimaryKey(byUserId) > 0 ? new Result(true, "用户删除成功") : new Result(false, "用户删除失败");
	}

	@Override
	public Result cancelDelete(Integer userId) {
		TbUser byUserId = getByUserId(userId);
		if (byUserId == null)
			return new Result(false, "该用户不存在");
		byUserId.setUserStatus(1);
		return userMapper.updateByPrimaryKey(byUserId) > 0 ? new Result(true, "用户取消删除成功")
				: new Result(false, "用户取消删除失败");
	}

}
