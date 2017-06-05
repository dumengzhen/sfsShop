package cn.du.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.du.dao.ShopCarDao;
import cn.du.dao.UserDao;
import cn.du.entity.ShopCar;
import cn.du.entity.Type;
import cn.du.entity.User;
import cn.du.pageModel.PshopCar;
import cn.du.pageModel.Ptype;

@Service
@Transactional
public class ShopCarService {
	@Resource
	private ShopCarDao shopCarDao;
	public List<PshopCar> showcar(int userid) {
		List<PshopCar> plist = new ArrayList<PshopCar>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", userid);
		List<ShopCar> list = shopCarDao.find("from Type where goods.id =:userid", params);
		for(ShopCar t:list){
			PshopCar pshopCar = new PshopCar();
			BeanUtils.copyProperties(t, pshopCar);
			plist.add(pshopCar);
		}
		return plist;
	}

	public void updatecar(ShopCar car) {
		shopCarDao.update(car);
	}
	
}
