package cn.du.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 订单
 * 
 * @author 卡普
 * 
 */
public class Order {
	private int id;// 主键id
	private int state;// 支付状态
	private User user = new User();// 订单所属用户
	private Set<Goods> goods = new HashSet<Goods>();// 订单包含商品集合

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<Goods> getGoods() {
		return goods;
	}

	public void setGoods(Set<Goods> goods) {
		this.goods = goods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// public int getOrderId() {
	// return orderId;
	// }
	//
	// public void setOrderId(int orderId) {
	// this.orderId = orderId;
	// }

}
