package cn.du.pageModel;

import java.util.ArrayList;
import java.util.List;

import cn.du.entity.Goods;

public class Page {
	private int total;
	private List<Pgoods> list = new ArrayList<Pgoods>();

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<Pgoods> getList() {
		return list;
	}

	public void setList(List<Pgoods> list) {
		this.list = list;
	}

}
