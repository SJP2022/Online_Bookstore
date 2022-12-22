package org.fkit.springbootmybatistest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.fkit.springbootmybatistest.bean.Admin;
import org.fkit.springbootmybatistest.bean.Bill;
import org.fkit.springbootmybatistest.bean.Book;
import org.fkit.springbootmybatistest.bean.Reader;
import org.fkit.springbootmybatistest.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

	// 注入AdminService
		@Resource
		private AdminService adminService;
		
		@RequestMapping("/login")
		public String login(){
			return "adminlogin";
		}
		
		@RequestMapping("/logon")
		public String logon(Admin admin,HttpSession session){
			boolean isLogon;
			isLogon=adminService.validate(admin);

			if(isLogon) {
				session.setAttribute("admin", admin);
				return "adminhomepage";
			}
			else
				return "adminlogonerror";
			
		}
		
		@RequestMapping("/book")
		public String book(HttpSession session, Model model){
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			List<Book> listbook=adminService.findAll();
			model.addAttribute("listbook", listbook);
			return "adminbook";
		}
		
		@RequestMapping("/add")
		public String add(HttpSession session) {
			if(session.getAttribute("admin")==null)
					return "adminlogin";
			else
					return "adminadd";
		}
		
		@RequestMapping("/adddb")
		public String addDB(Book book,HttpSession session) {
			if(session.getAttribute("admin")==null)
					return "adminlogin";
			if(adminService.insertBook(book)>0)
				return "adminaddfinish";
			else
				return "error";
		}
		
		@RequestMapping("/find")
		public String find(HttpSession session,Model model) {
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			List<Book> listbook=adminService.findAll();
			model.addAttribute("listbook", listbook);
			return "adminfind";
		}
		
		@RequestMapping("/changepassword")
		public String changepassword(Admin admin,HttpSession session){
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			return "adminchangepassword";
			
		}
		
		@RequestMapping("/checkpassword")
		public String checkpassword(String password1, String password2, HttpSession session){
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			//String password1 = (String) session.getAttribute("password1");
			//String password2 = (String) session.getAttribute("password2");
			Admin admin = (Admin) session.getAttribute("admin");
			boolean ok;
			ok=adminService.changepassword(admin, password1, password2);
			if(ok) {
				session.setAttribute("admin", admin);
				return "adminchangepasswordfinish";
			}
			else
				return "adminchangepassworderror";
			
		}
		
		@RequestMapping("/homepage")
		public String homepage(HttpSession session,Model model) {
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			return "adminhomepage";
		}
		
		@RequestMapping("/exit")
		public String exit(Admin admin,HttpSession session){
			
			session.setAttribute("admin", null);	
			return "main";
			
		}
		
		@RequestMapping("/bill")
		public String bill(HttpSession session,Model model) {
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			List<Bill> listbill=adminService.findBill();
			model.addAttribute("listbill", listbill);
			session.setAttribute("listbill", listbill);
			model.addAttribute("id", "");
			model.addAttribute("name", "");
			model.addAttribute("reader", "");
			return "adminbill";
		}
		
		@RequestMapping("/billbyid")
		public String billbyid(HttpSession session, String id, Model model) {
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			int ID = Integer.valueOf(id);
			List<Bill> listbill=adminService.findBillById(ID);
			
			model.addAttribute("listbill", listbill);
			return "adminbill";
		}
		
		@RequestMapping("/billbybook")
		public String billbybook(HttpSession session, String name, Model model) {
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			List<Bill> listbill=adminService.findBillByBook(name);
			
			model.addAttribute("listbill", listbill);
			return "adminbill";
		}
		
		@RequestMapping("/billbyreader")
		public String billbyreader(HttpSession session, String reader, Model model) {
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			List<Bill> listbill=adminService.findBillByReader(reader);
			
			model.addAttribute("listbill", listbill);
			return "adminbill";
		}
		
		@RequestMapping("/billselect")
		public String billselect(HttpSession session, String id, String name, String reader, Model model) {
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			List<Bill> listbill = (List<Bill>) session.getAttribute("listbill");
			//System.out.print(listbill.size());
			List<Bill> listbill2 = new LinkedList<>();
			for (int i = 0; i < listbill.size(); i++) {
				Bill b = listbill.get(i);
				if ((name.equals("")||b.getName().equals(name))&&(id.equals("")||String.valueOf(b.getBill()).equals(id))&&(reader.equals("")||b.getReader().equals(reader))) {
					listbill2.add(b);
					//System.out.print("OK");
				}
			}
			model.addAttribute("listbill", listbill2);
			model.addAttribute("id", id);
			model.addAttribute("name", name);
			model.addAttribute("reader", reader);
			return "adminbill";
		}
		
		@RequestMapping("/changebook")
		public String changebook(HttpSession session, String id, Model model) {
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			Book book = adminService.findBookById(Integer.parseInt(id));
			model.addAttribute("book", book);
			session.setAttribute("id", id);
			return "adminchangebook";
		}
		
		@RequestMapping("/change")
		public String change(Book book,HttpSession session, Model model) {
			if(session.getAttribute("admin")==null)
				return "adminlogin";
			String id = (String) session.getAttribute("id");
			//System.out.println(id);
			//System.out.println(book.getName());
			//System.out.println(book.getPrice());
			//System.out.println(book.getQuantity());
			Book nowbook = adminService.findBookById(Integer.parseInt(id));
			adminService.changeBook(nowbook, book.getName(), book.getPrice(), book.getQuantity());
			book = adminService.findBookById(Integer.parseInt(id));
			model.addAttribute("book", book);
			session.setAttribute("id", id);
			return "adminchangebookfinish";
		}
}
