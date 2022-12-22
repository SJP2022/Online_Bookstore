package org.fkit.springbootmybatistest.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.springbootmybatistest.bean.Book;
import org.fkit.springbootmybatistest.bean.Reader;


public interface ReaderRepository {
	
	@Select("select * from reader where name=#{name}")
	public Reader selectByName(String name);
	
	@Update("update reader set money=#{money} where name=#{name}")
	public void update(Reader reader);
	
	@Update("update reader set password=#{password} where name=#{name}")
	public void changePassword(Reader reader);
	
	@Insert("insert into reader(name,password,money)"
			+ "values (#{name},#{password},1000)")
	public void insertReader(Reader reader);
}
