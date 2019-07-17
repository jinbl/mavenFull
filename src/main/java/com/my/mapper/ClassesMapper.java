package com.my.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.my.entity.Classes;

/**
* @类名  StudnetMapper.java
* @作者  jinbanglong
* @版本  V1.0
* @日期  2019年7月13日-下午3:30:02
* @描述  
*
*/
public interface ClassesMapper {
	
	List<Classes> oneToMany();
	
	Classes find(int cid);
	
	int add();
}
