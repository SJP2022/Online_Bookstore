package org.fkit.springbootmybatistest.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.fkit.springbootmybatistest.bean.Bill;
import org.fkit.springbootmybatistest.bean.Book;
import org.fkit.springbootmybatistest.bean.Reader;
import org.fkit.springbootmybatistest.bean.ShoppingCart;
import org.fkit.springbootmybatistest.service.ReaderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/reader")
public class ReaderController {

	// 注入ReaderService
		@Resource
		private ReaderService readerService;
		
		@RequestMapping("/login")
		public String login(){
			return "readerlogin";
		}
		
		@RequestMapping("/logon")
		public String logon(Reader reader,HttpSession session){
			
			boolean isLogon;
			isLogon=readerService.validate(reader);
			if(isLogon) {
				session.setAttribute("reader", reader);
				return "redirect:/reader/homepage";
			}
			else
				return "readerlogonerror";
			
		}
		
		@RequestMapping("/choose")
		public String choose(HttpSession session){
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			return "readerchoose";
		}
		
		@RequestMapping("/index")
		public String index(HttpSession session,Model model) {
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			List<Book> listbook=readerService.findAll();
			model.addAttribute("listbook", listbook);
			return "readerindex";
		}
		
		@RequestMapping("/addshopcart")
		public String addShopCart(HttpSession session,int id) {
			ShoppingCart sc=null;
			sc=(ShoppingCart)session.getAttribute("shopcart");
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			if(sc==null) {
				sc=new ShoppingCart();
				session.setAttribute("shopcart",sc);
			}
			readerService.addShop(id, sc);
			return "readershop";
		}
		
		@RequestMapping("/pay")
		public String pay(HttpSession session,Model model) {
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			ShoppingCart sc=null;
			sc=(ShoppingCart)session.getAttribute("shopcart");
			if(sc==null)
				return "error";
			if(sc.getCart().size()==0) return "readerpaynull";
			Reader reader=(Reader)session.getAttribute("reader");
			//System.out.print(reader.getMoney());
			float money=readerService.pay(reader,sc);
			if (money < 0)
				return "readerpayerror";
			
			int id = readerService.save(reader, sc);
			List<Bill> listbill = readerService.findBillById(id);
			session.setAttribute("listbill",listbill);
			model.addAttribute("money", money);
			model.addAttribute("total", sc.getTotal());
			model.addAttribute("id", id);
			session.removeAttribute("shopcart");
			return "readerend";
		}
		
		@RequestMapping("/recharge")
		public String recharge(HttpSession session) {
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			return "readerrecharge";
		}
		
		@RequestMapping("/rechargeon")
		public String rechargeon(HttpSession session, String money) {
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			float amount = Float.valueOf(money).floatValue();
			Reader reader = (Reader)session.getAttribute("reader");
			readerService.recharge(reader, amount);
			return "readerrechargesuccess";
		}
		
		@RequestMapping("/register")
		public String register(){
			return "register";
		}
		
		@RequestMapping("/confirm_register")
		public String confirm_register(Reader reader,HttpSession session){
			boolean ok;
			ok=readerService.register(reader);
			if(ok) {
				session.setAttribute("reader", reader);
				return "registerfinish";
			}
			else
				return "registererror";
			
		}
		
		@RequestMapping("/homepage")
		public String homepage(HttpSession session,Model model) {
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			//List<Book> listbook=readerService.findAll();
			//model.addAttribute("listbook", listbook);
			session.setAttribute("shopcart", null);
			return "readerhomepage";
		}
		
		@RequestMapping("/exit")
		public String exit(Reader reader,HttpSession session){
			
			session.setAttribute("reader", null);	
			return "main";
			
		}
		
		@RequestMapping("/changepassword")
		public String changepassword(Reader reader,HttpSession session){
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			return "readerchangepassword";
			
		}
		
		@RequestMapping("/checkpassword")
		public String checkpassword(String password1, String password2, HttpSession session){
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			//String password1 = (String) session.getAttribute("password1");
			//String password2 = (String) session.getAttribute("password2");
			Reader reader = (Reader) session.getAttribute("reader");
			boolean ok;
			ok=readerService.changepassword(reader, password1, password2);
			if(ok) {
				session.setAttribute("reader", reader);
				return "readerchangepasswordfinish";
			}
			else
				return "readerchangepassworderror";
			
		}
		
		@RequestMapping("/bill")
		public String bill(HttpSession session,Model model) {
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			List<Bill> listbill=readerService.findBill((Reader) session.getAttribute("reader"));
			model.addAttribute("listbill", listbill);
			session.setAttribute("listbill", listbill);
			model.addAttribute("id", "");
			model.addAttribute("name", "");
			return "readerbill";
		}
		
		@RequestMapping("/billbyid")
		public String billbyid(HttpSession session, String id, Model model) {
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			int ID = Integer.valueOf(id);
			List<Bill> listbill=readerService.findBillById(ID);
			//Reader reader = (Reader)session.getAttribute("reader");
			model.addAttribute("listbill", listbill);
			return "readerbill";
		}
		
		@RequestMapping("/billbybook")
		public String billbybook(HttpSession session, String name, Model model) {
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			
			List<Bill> listbill=readerService.findBillByBook(name);
			//Reader reader = (Reader)session.getAttribute("reader");
			model.addAttribute("listbill", listbill);
			//session.setAttribute("listbill", listbill);
			return "readerbill";
		}
		
		@RequestMapping("/billselect")
		public String billselect(HttpSession session, String id, String name, Model model) {
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			List<Bill> listbill = (List<Bill>) session.getAttribute("listbill");
			//System.out.print(listbill.size());
			List<Bill> listbill2 = new LinkedList<>();
			for (int i = 0; i < listbill.size(); i++) {
				Bill b = listbill.get(i);
				if ((name.equals("")||b.getName().equals(name))&&(id.equals("")||String.valueOf(b.getBill()).equals(id))) {
					listbill2.add(b);
					//System.out.print("OK");
				}
			}
			model.addAttribute("listbill", listbill2);
			model.addAttribute("id", id);
			model.addAttribute("name", name);
			return "readerbill";
		}
		
		@RequestMapping("/add")
		public String add(HttpServletRequest req,HttpSession session) {
			int id = Integer.parseInt(req.getParameter("id"));
			System.out.println(id);
			ShoppingCart sc=null;
			sc=(ShoppingCart)session.getAttribute("shopcart");
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			if(sc==null) {
				sc=new ShoppingCart();
				session.setAttribute("shopcart",sc);
			}
			if(readerService.addShop(id, sc)) return "readershop";
			else return "readershopbookerror";
		}
		
		@RequestMapping("/sub")
		public String sub(HttpServletRequest req,HttpSession session) {
			int id = Integer.parseInt(req.getParameter("id"));
			System.out.println(id);
			ShoppingCart sc=null;
			sc=(ShoppingCart)session.getAttribute("shopcart");
			if(session.getAttribute("reader")==null)
				return "readerlogin";
			if(sc==null) {
				sc=new ShoppingCart();
				session.setAttribute("shopcart",sc);
			}
			readerService.subShop(id, sc);
			return "readershop";
		}
}
