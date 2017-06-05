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
import cn.du.dao.TypeDao;
import cn.du.pageModel.Pgoods;
import cn.du.pageModel.Ptype;
import cn.du.entity.Goods;
import cn.du.entity.Type;

@Service
@Transactional
public class TypeService {
	@Resource
	private TypeDao typeDao;
	public List<Ptype> showType(String name) {
		List<Ptype> types = new ArrayList<Ptype>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "%%" + name.trim() + "%%");
		List<Type> list = typeDao.find("from Type where tname like :name", params);
		for(Type t:list){
			Ptype ptype = new Ptype();
			BeanUtils.copyProperties(t, ptype);
			types.add(ptype);
		}
		return types;
	}
}
