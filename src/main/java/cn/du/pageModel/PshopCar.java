package cn.du.pageModel;

public class PshopCar {
	// 主键id
	private int id;
	// 购物车里的商品集合
	private int userid;// 所属用户id
	private int sum;//加入购物车的总数
	private int goodsid;//要加入购物车的商品id
	
	
	public int getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(int goodsid) {
		this.goodsid = goodsid;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

}
