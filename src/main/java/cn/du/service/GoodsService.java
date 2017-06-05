package cn.du.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.du.dao.GoodsDao;
import cn.du.entity.Goods;
import cn.du.entity.Type;
import cn.du.pageModel.Page;
import cn.du.pageModel.Pgoods;
import cn.du.pageModel.Ptype;
@Transactional
@Service
public class GoodsService {
	@Resource
	private GoodsDao goodsDao;
	public Page showGoods(Pgoods pGoods) {
		Page page = new Page();
		int total = goodsDao.count("from Goods ");
		List<Goods> list = goodsDao.find("from Goods ", pGoods.getPage(), pGoods.getRows());
		List<Pgoods> goods = new ArrayList<Pgoods>();
		for(Goods t:list){
			Pgoods pgoods = new Pgoods();
			BeanUtils.copyProperties(t, pgoods);
			goods.add(pgoods);
		}
		page.setList(goods);
		page.setTotal(total);
		return page;
	}
	public Page showByName(Pgoods goods2) {
		Page page = new Page();
		List<Pgoods> goods = new ArrayList<Pgoods>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("goodsName", "%%" + goods2.getName() + "%%");
		int total = goodsDao.count("from Goods where goodsName like:goodsName",params);
		List<Goods> list = goodsDao.find("from Goods where goodsName like:goodsName", params, goods2.getPage(), goods2.getRows());
		for(Goods t:list){
			Pgoods pgoods = new Pgoods();
			BeanUtils.copyProperties(t, pgoods);
			goods.add(pgoods);
		}
		page.setList(goods);
		page.setTotal(total);
		return page;
	}
	public Pgoods showById(int goodsid) {
		Pgoods pgoods = new Pgoods();
		Goods good = goodsDao.get(Goods.class, goodsid);
		BeanUtils.copyProperties(good, pgoods);
		return pgoods;
	}
	public void addGoods(Pgoods goods) {
		Goods good = new Goods();
		BeanUtils.copyProperties(goods, good);
		goodsDao.save(good);
	}
}
