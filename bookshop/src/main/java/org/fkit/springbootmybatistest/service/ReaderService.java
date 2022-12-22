package org.fkit.springbootmybatistest.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.fkit.springbootmybatistest.bean.Bill;
import org.fkit.springbootmybatistest.bean.Book;
import org.fkit.springbootmybatistest.bean.Reader;
import org.fkit.springbootmybatistest.bean.ShoppingCart;
import org.fkit.springbootmybatistest.repository.BillRepository;
import org.fkit.springbootmybatistest.repository.BookRepository;
import org.fkit.springbootmybatistest.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReaderService {
	
	@Autowired
	private ReaderRepository readerRepository;
	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private BillRepository billRepository;
	
	
	public boolean validate(Reader reader) {
		Reader temp;
		
		temp=readerRepository.selectByName(reader.getName());
		if(temp==null)
			return false;
		if(temp.getPassword().equals(reader.getPassword())) {
			reader.setId(temp.getId());
			reader.setMoney(temp.getMoney());
			return true;
		}
		else
			return false;
	}
	
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}
	
	public boolean addShop(int id,ShoppingCart sc) {
		Book book=bookRepository.findBookById(id);
		if(sc.findById(id)!=null&&sc.findById(id).getQuantity()+1>book.getQuantity()) return false;
		book.setQuantity(1);
		sc.addCartItem(book);
		return true;
	}
	
	public boolean subShop(int id,ShoppingCart sc) {
		sc.subCartItem(id);
		return true;
	}
	
	@Transactional
	public float pay(Reader reader, ShoppingCart sc) {
		if (reader.getMoney()-sc.getTotal() < 0)
			return -1;
		
		List<Book> lb=sc.getCart();
		
		for(Book book:lb) {
			Book temp=bookRepository.findBookById(book.getId());
			if (temp.getQuantity()-book.getQuantity() < 0)
				return -1;
		}
		
		float money=(float) (reader.getMoney()-sc.getTotal());
		reader.setMoney(money);
		readerRepository.update(reader);
		
		for(Book book:lb) {
			Book temp=bookRepository.findBookById(book.getId());
			temp.setQuantity(temp.getQuantity()-book.getQuantity());
			bookRepository.update(temp);
		}
		return money;
	}
	
	@Transactional
	public void recharge(Reader reader, float amount) {
		reader.setMoney(amount + reader.getMoney());
		readerRepository.update(reader);
	}
	
	public boolean register(Reader reader) {
		Reader temp;
		
		temp=readerRepository.selectByName(reader.getName());
		if(temp==null) {
			readerRepository.insertReader(reader);
			reader.setMoney(1000);
			return true;
		}
		else
			return false;
	}
	
	public boolean changepassword(Reader reader, String password1, String password2) {
		//System.out.println(password1);
		//System.out.println(password2);
		//System.out.println(reader.getPassword());
		if(password1.equals(reader.getPassword())) {
			reader.setPassword(password2);
			readerRepository.changePassword(reader);
			return true;
		}
		else{
			return false;
		}
	}
	
	@Transactional
	public int save(Reader reader, ShoppingCart sc) {
		
		int count = billRepository.findMaxId()+1;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        //actionHistory.setTime(sdf.format(date));
		
		List<Book> lb=sc.getCart();
		
		for(Book book:lb) {
			Bill bill = new Bill();
			bill.setBill(count);
			bill.setName(book.getName());
			bill.setPrice(book.getPrice());
			bill.setQuantity(book.getQuantity());
			bill.setReader(reader.getName());
			bill.setTime(sdf.format(date));
			billRepository.insertBill(bill);
		}
		
		return count;

	}
	
	public List<Bill> findBill(Reader reader){
		//System.out.println(billRepository.findMaxId());
		return billRepository.findBillByReader(reader.getName());
	}
	
	public List<Bill> findBillById(int id){
		
		return billRepository.findBillById(id);
	}
	
	public List<Bill> findBillByBook(String name){
		
		return billRepository.findBillByBook(name);
	}
}
