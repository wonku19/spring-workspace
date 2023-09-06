package com.kh.api.dao;

import java.util.List;

import com.kh.api.model.Phone;
import com.kh.api.model.Userinfo;

public interface PhoneDAO { // impl - > PhoneDAOImpl
	int insert(Phone phone);
	int delete(String num);
	int update(Phone phone);
	Phone select(String num);
	List<Phone> select();
	Userinfo select(Userinfo user);
}
