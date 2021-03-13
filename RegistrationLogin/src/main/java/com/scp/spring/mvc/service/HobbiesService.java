package com.scp.spring.mvc.service;

import java.util.List;

import com.scp.spring.mvc.beans.HobbiesBean;

public interface HobbiesService {

	public boolean addHobbies(HobbiesBean hobby);
	public HobbiesBean getHobbies(int hobby);
	public List<HobbiesBean> deleteHobbies(int hobby);
	public HobbiesBean updateHobbies(HobbiesBean hobby);
	public List<HobbiesBean> getAllHobbiess();


}
