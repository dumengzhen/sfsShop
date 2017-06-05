package cn.du.action;

import org.apache.log4j.Logger;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.du.pageModel.Page;
import cn.du.pageModel.Pgoods;
import cn.du.service.GoodsService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class GoodsAction extends BaseAction implements ModelDriven<Pgoods> {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(GoodsAction.class);

	@Resource
	private GoodsService goodsService;
	private Pgoods goods = new Pgoods();

	public Pgoods getModel() {
		return goods;
	}

	// 查找所有的商品
	
	
	public void showGoods() {
		Page page = goodsService.showGoods(goods);
		super.writeJson(page);
	}

	// 根据输入条件模糊查询
	public void showByName() {
		logger.info(goods.getName());
		Page page = goodsService.showByName(goods);
		logger.info(goods.getPage());
		super.writeJson(page);
	}
	public void addGoods(){
		Pgoods pgoods = new Pgoods();
		pgoods.setGoodsName("王尼玛");
		pgoods.setGoodsPhotos("http://192.168.1.105:8080/sfsShop/photo/1.jpg");
		pgoods.setGoodsPrice(300);
		pgoods.setGoodsNum(20);
		pgoods.setSellNum(10);
		goodsService.addGoods(goods);
	}
	public void showById() {
		logger.info(goods.getId());
		Pgoods good = goodsService.showById(goods.getId());
		super.writeJson(good);
	}
}
