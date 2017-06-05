package cn.du.action;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import cn.du.entity.Goods;
import cn.du.entity.ShopCar;
import cn.du.entity.User;
import cn.du.pageModel.Pgoods;
import cn.du.pageModel.PshopCar;
import cn.du.service.GoodsService;
import cn.du.service.ShopCarService;
import cn.du.service.UserService;
import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class ShopCarAction extends BaseAction implements ModelDriven<PshopCar> {
	private PshopCar pshopCar;

	@Override
	public PshopCar getModel() {
		return pshopCar;
	}

	@Resource
	private ShopCarService shopCarService;
	@Resource
	private UserService userService;
	@Resource
	private GoodsService goodsService;

	public void showcar() {
		List<PshopCar> list = shopCarService.showcar(pshopCar.getUserid());
		super.writeJson(list);
	}

	public void addcar() {
		User user = userService.findByid(pshopCar.getUserid());
		ShopCar car = user.getShopCar();
		List<Goods> listgoods = car.getGoods();
		Pgoods pgoods = goodsService.showById(pshopCar.getGoodsid());
		Goods goods = new Goods();
		BeanUtils.copyProperties(pgoods, goods);
		for (int i = 0; i < pshopCar.getSum(); i++) {
			listgoods.add(goods);
		}
		car.setGoods(listgoods);
		shopCarService.updatecar(car);
	}
}
