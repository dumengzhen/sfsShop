package cn.du.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 商品
 * 
 * @author 卡普
 * 
 */
public class Goods {
	// 主键id
	private int id;
	// 商品名称
	private String goodsName;
	// 商品相关图片
	private String goodsPhotos;
	// 商品详细信息
	private String goodsInfo;
	// 商品价格
	private float goodsPrice;
	// 商品库存
	private int goodsNum;
	// 销量
	private int sellNum;
	// 评价
	private String comment;
	// 商品存在于购物车的集合
	private List<ShopCar> shopCars = new ArrayList<ShopCar>();
	// 商品存在于收藏夹的集合
	private Set<Like> likes = new HashSet<Like>();
	// 商品所属订单集合
	private Set<Order> orders = new HashSet<Order>();
	private Set<Type> types = new HashSet<Type>();//商品所属类型集合
	
	public Set<Type> getTypes() {
		return types;
	}

	public void setTypes(Set<Type> types) {
		this.types = types;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsPhotos() {
		return goodsPhotos;
	}

	public void setGoodsPhotos(String goodsPhotos) {
		this.goodsPhotos = goodsPhotos;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public float getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public int getSellNum() {
		return sellNum;
	}

	public void setSellNum(int sellNum) {
		this.sellNum = sellNum;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<ShopCar> getShopCars() {
		return shopCars;
	}

	public void setShopCars(List<ShopCar> shopCars) {
		this.shopCars = shopCars;
	}

	public Set<Like> getLikes() {
		return likes;
	}

	public void setLikes(Set<Like> likes) {
		this.likes = likes;
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

//	public int getGoodsId() {
//		return goodsId;
//	}
//
//	public void setGoodsId(int goodsId) {
//		this.goodsId = goodsId;
//	}

}
