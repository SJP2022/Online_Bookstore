package org.fkit.springbootmybatistest.service;

import java.util.List;

import org.fkit.springbootmybatistest.bean.Admin;
import org.fkit.springbootmybatistest.bean.Bill;
import org.fkit.springbootmybatistest.bean.Book;
import org.fkit.springbootmybatistest.bean.Reader;
import org.fkit.springbootmybatistest.repository.AdminRepository;
import org.fkit.springbootmybatistest.repository.BillRepository;
import org.fkit.springbootmybatistest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BillRepository billRepository;
	
	public boolean validate(Admin admin) {
		Admin temp;
		
		temp=adminRepository.selectByName(admin.getName());
		
		if(temp==null)
			return false;
		
		if(temp.getPassword().equals(admin.getPassword()))
			return true;
		else
			return false;
	}
	
	public int insertBook(Book book) {
		return bookRepository.insertBook(book);
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public boolean changepassword(Admin admin, String password1, String password2) {
		//System.out.println(password1);
		//System.out.println(password2);
		//System.out.println(reader.getPassword());
		if(password1.equals(admin.getPassword())) {
			admin.setPassword(password2);
			adminRepository.changePassword(admin);
			return true;
		}
		else{
			return false;
		}
	}
	
	public List<Bill> findBill(){
		//System.out.println(billRepository.findMaxId());
		return billRepository.findAll();
	}
	
	public List<Bill> findBillById(int id){
		
		return billRepository.findBillById(id);
	}
	
	public List<Bill> findBillByBook(String name){
		
		return billRepository.findBillByBook(name);
	}
	
	public List<Bill> findBillByReader(String reader){
		
		return billRepository.findBillByReader(reader);
	}
	
	public Book findBookById(int id){
		
		return bookRepository.findBookById(id);
	}
	
	public void changeBook(Book book, String name, float price, int quantity) {
		book.setName(name);
		book.setPrice(price);
		book.setQuantity(quantity);
		bookRepository.change(book);
	}
}
