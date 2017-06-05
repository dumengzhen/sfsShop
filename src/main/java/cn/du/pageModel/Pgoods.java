package cn.du.pageModel;

public class Pgoods {
	// 主键id
	private int id;
	// 商品名称
	private String goodsName;
	private String name;
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
	//分页使用 （每页多少个）
	private int rows;
	//分页使用（要请求哪一页）
	private int page;
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
