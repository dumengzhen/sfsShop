package cn.du.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 * 
 * @author 卡普
 * 
 */
public class User {
	// 主键id
	private int id;
//	// userid
//	private String userId;
	// 用户昵称
	private String userName;
	// 用户登录密码
	private String userPswd;
	// 收货地址
	private String addr;
	// 手机号
	private String tel;
	// 收货姓名
	private String realName;
	// 购物车
	private ShopCar shopCar = new ShopCar();
	// 收藏夹
	private Like like = new Like();
	// 拥有的订单集合
	private Set<Order> orders = new HashSet<Order>();

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPswd() {
		return userPswd;
	}

	public void setUserPswd(String userPswd) {
		this.userPswd = userPswd;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public ShopCar getShopCar() {
		return shopCar;
	}

	public void setShopCar(ShopCar shopCar) {
		this.shopCar = shopCar;
	}

	public Like getLike() {
		return like;
	}

	public void setLike(Like like) {
		this.like = like;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public String getUserId() {
//		return userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

}
