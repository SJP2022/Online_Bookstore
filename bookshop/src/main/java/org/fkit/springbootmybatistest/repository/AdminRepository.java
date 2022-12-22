package org.fkit.springbootmybatistest.repository;


import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.springbootmybatistest.bean.Admin;
import org.fkit.springbootmybatistest.bean.Reader;


public interface AdminRepository {

	@Select("select * from manager where name=#{name}")
	public Admin selectByName(String name);
	
	@Update("update manager set password=#{password} where name=#{name}")
	public void changePassword(Admin admin);
}
