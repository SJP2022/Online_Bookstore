package org.fkit.springbootmybatistest.repository;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.fkit.springbootmybatistest.bean.Book;


public interface BookRepository {
	
	@Insert("insert into book(name,price,quantity)"
			+ "values (#{name},#{price},#{quantity})")
	public int insertBook(Book book);
	
	@Select("select * from book")
	public List<Book> findAll();
	
	@Select("select * from book where id=#{id}")
	public Book findBookById(int id);
	
	@Update("update book set quantity=#{quantity} where id=#{id}")
	public void update(Book book);
	
	@Update("update book set name=#{name},price=#{price},quantity=#{quantity} where id=#{id}")
	public void change(Book book);
	
}