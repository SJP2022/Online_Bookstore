package org.fkit.springbootmybatistest.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.fkit.springbootmybatistest.bean.Bill;

public interface BillRepository {
	
	@Insert("insert into bill(bill,name,price,quantity,reader,time)"
			+ "values (#{bill},#{name},#{price},#{quantity},#{reader},#{time})")
	public int insertBill(Bill bill);
	
	@Select("select * from bill")
	public List<Bill> findAll();
	
	@Select("select * from bill where reader=#{reader}")
	public List<Bill> findBillByReader(String reader);
	
	@Select("select * from bill where bill=#{bill}")
	public List<Bill> findBillById(int bill);
	
	@Select("select max(bill) from bill")
	public int findMaxId();
	
	@Select("select * from bill where name=#{name}")
	public List<Bill> findBillByBook(String name);
}
