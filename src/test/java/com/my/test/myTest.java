package com.my.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.my.entity.Classes;
import com.my.entity.Student;
import com.my.mapper.ClassesMapper;
import com.my.mapper.StudentMapper;

import junit.framework.TestCase;

public class myTest{
	static InputStream ras;
	static SqlSessionFactory build;
	static{
		 try {
			 	ras= Resources.getResourceAsStream("mybatis.xml");
			 	build = new SqlSessionFactoryBuilder().build(ras);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	@Test
	public void test() throws IOException {
		SqlSession sess = build.openSession(true);
		StudentMapper mapper = sess.getMapper(StudentMapper.class);
		List<Student> stuList = mapper.selectAll();
		System.out.println(stuList);
		sess.close();
	}
	@Test
	public void add() {
		SqlSession sess = build.openSession();
		StudentMapper mapper = sess.getMapper(StudentMapper.class);
		
		Date date = new Date();
		System.out.println(date);
		Student stu = new Student("夏利","男",date,1);
		int sid = mapper.add(stu);
		System.out.println("新插入的id为："+stu.getSid());
		sess.commit();
		
	}
	@Test  //
	public void find() {
		SqlSession sess = build.openSession();
		StudentMapper mapper = sess.getMapper(StudentMapper.class);
		
		Student stu = mapper.find(1005);
		System.out.println(stu);
		sess.close();
	}
	@Test   //模糊查询
	public void like() {
		SqlSession sess = build.openSession();
		StudentMapper mapper = sess.getMapper(StudentMapper.class);
		
		List<Student> list = mapper.like("大");
		System.out.println(list);
		sess.close();
	}
	@Test    //一对一查询
	public void selectAllRelation() {
		SqlSession sess = build.openSession();
		StudentMapper mapper = sess.getMapper(StudentMapper.class);
		
		List<Student> list = mapper.selectAllRelation();
		System.out.println(list);
		sess.close();
	}
	@Test    //一对一查询
	public void findOneRelation() {
		SqlSession sess = build.openSession();
		StudentMapper mapper = sess.getMapper(StudentMapper.class);
		
		Student stu = mapper.findOneRelation(1004);
		System.out.println(stu);
		sess.close();
	}
	
	/*************************************************************************/
	@Test    //一对多查询
	public void oneToMany() {
		SqlSession sess = build.openSession();
		ClassesMapper mapper = sess.getMapper(ClassesMapper.class);
		
		List<Classes> list = mapper.oneToMany();
		System.out.println(list);
		sess.close();
	}
	@Test    //一对多查询   一条数据
	public void findOne() {
		SqlSession sess = build.openSession();
		ClassesMapper mapper = sess.getMapper(ClassesMapper.class);
		
		Classes cla = mapper.find(1);
		System.out.println(cla);
		sess.close();
	}
	@Test    //利用SQL类构建SQL
	public void query() {
		
		String name="大";
		int sid = 0;
		int cid = 1;
		
		SQL sql = new SQL();
			sql.SELECT("*");
			sql.FROM("student s");
			sql.JOIN("classes c");
			sql.WHERE("c.cid = s.cid");
				
		if(name!=null) {
			sql.WHERE("s.sname like '%"+name+"%'");
		}
		if(sid>0) {
			sql.WHERE("s.sid="+sid);
		}
		if(cid>0) {
			sql.WHERE("s.cid="+cid);
		}
		String where = sql.toString();
		System.out.println(where);
		SqlSession sess = build.openSession();
		StudentMapper mapper = sess.getMapper(StudentMapper.class);
		List<Student> stulist = mapper.query(where);
		System.out.println(stulist.size());
	}
}
