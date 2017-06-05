package cn.du.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 购物车
 * 
 * @author 卡普
 * 
 */
public class ShopCar {
	// 主键id
	private int id;
	private List<Goods> goods = new ArrayList<Goods>();
	// 用户
	private User user;

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
