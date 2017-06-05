package cn.du.entity;

import java.util.HashSet;
import java.util.Set;

/*
 * 商品类型
 */
public class Type {
	private int id;// 主键id
	private String tname;// 类型名称
	private Set<Goods> goods = new HashSet<Goods>();//属于该类型的商品的集合

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

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

}
