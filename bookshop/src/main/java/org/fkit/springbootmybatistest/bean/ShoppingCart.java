package org.fkit.springbootmybatistest.bean;

import java.util.ArrayList;
import java.util.Iterator;

public class ShoppingCart {
	/**
	 * 保存所有CartItem对象的容器对象。
	 */
	private ArrayList<Book> cart;

	public ShoppingCart() {
		cart = new ArrayList<Book>();
	}

	/**
	 * 返回包括所有已经购物的商品信息的容器对象。
	 * @return 当前的items容器对象
	 */
	public ArrayList<Book> getCart() {
		return cart;
	}

	/**
	 * 添加一种商品到购物车中，如果这种商品在购物车中已经存在，
	 * 那就修改已有的商品的数量，
	 * 反之，构造一个新的CartItem对象添加到items对象中。
	 * @param item 新增的代表这种商品的对象
	 */
	public void addCartItem(Book item) {
		Book oldItem = null;
		if (item != null) {
			for (int i = 0; i < cart.size(); i++) {
				oldItem = cart.get(i);
				if (oldItem.getId()==(item.getId())) {
					oldItem.setQuantity(oldItem.getQuantity() + item.getQuantity());
					return;
				}
			}
			cart.add(item);
		}
	}

	public boolean subCartItem(int id) {
		Book item = null;
		for (int i = 0; i < cart.size(); i++) {
			item = cart.get(i);
			if (item.getId()==id) {
				if(item.getQuantity()>1) {
					item.setQuantity(item.getQuantity()-1);
				}
				else {
					cart.remove(i);
				}
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 从购物车中，删除商品。
	 * @param id 所删除商品的商品编号
	 * @return 删除成功，返回true，反之返回false
	 */
	public boolean removeCartItem(int id) {
		Book item = null;
		for (int i = 0; i < cart.size(); i++) {
			item = cart.get(i);
			if (item.getId()==id) {
				cart.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * 计算所购所有商品的总价。
	 * @return 商品的总价
	 */
	public double getTotal() {
		Iterator<Book> it = cart.iterator();
		double sum = 0.0;
		Book item = null;
		while (it.hasNext()) {
			item = it.next();
			sum = sum + item.getSum();
		}
		return sum;
	}
	
	public Book findById(int id) {
		Book item = null;
		for (int i = 0; i < cart.size(); i++) {
			item = cart.get(i);
			if (item.getId()==id) {
				return item;
			}
		}
		return null;
	}
}
