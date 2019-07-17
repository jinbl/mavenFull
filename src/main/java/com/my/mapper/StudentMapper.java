package com.my.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.my.entity.Student;

/**
* @类名  StudnetMapper.java
* @作者  jinbanglong
* @版本  V1.0
* @日期  2019年7月13日-下午3:30:02
* @描述  
*
*/
public interface StudentMapper {
	@Select("select * from student")
	List<Student> selectAll();
	
	List<Student> selectAllRelation();
	
	Student findOneRelation(int sid);
	
	/* 原生语句查询 */
	List<Student> query(String sql);
	
	
	@Select("select * from student where sid=#{sid}")
	Student find(int sid);
	
	@Select("select * from student where sname like '%${value}%'")
	List<Student> like(String sname);
	
	int add(Student stu);
}
