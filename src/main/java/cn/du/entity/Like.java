package cn.du.entity;

import java.util.HashSet;
import java.util.Set;

/*
 * 收藏夹
 */
public class Like {
	// 主键id
	private int id;
	public Like(){
		
	}
	public Like(User user){
		user = this.user;
	}
	// 在收藏夹中的商品的集合
	private Set<Goods> goods = new HashSet<Goods>();

	// 用户
	private User user;
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

//	public int getLikeId() {
//		return likeId;
//	}
//
//	public void setLikeId(int likeId) {
//		this.likeId = likeId;
//	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
