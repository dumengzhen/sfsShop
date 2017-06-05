package cn.du.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.du.dao.MenuDao;
import cn.du.entity.Menu;
import cn.du.pageModel.Tmenu;

@Transactional
@Service
public class MenuService {
	@Resource
	private MenuDao menuDao;
	public List<Tmenu> getTreeNode(String id) {
		List<Tmenu> nl = new ArrayList<Tmenu>();
		Map<String, Object> param = new HashMap<String, Object>();
		String hql = null;
		if (id == null || id.equals("")) {
			// 查询所有根节点
			hql = "from Menu t where t.tmenu is null";
		} else {
			// 异步加载当前id下的子节点
			hql = "from Menu t where t.tmenu.id = :id ";
			param.put("id", id);
			
		}
		List<Menu> l = menuDao.find(hql, param);
		if (l != null && l.size() > 0) {
			for (Menu t : l) {
				Tmenu m = new Tmenu();
				BeanUtils.copyProperties(t, m);
				Map<String, Object> attributes = new HashMap<String, Object>();
				attributes.put("url", t.getUrl());
				m.setAttributes(attributes);
				Set<Menu> set = t.getTmenus();
				if (set != null && !set.isEmpty()) {
					m.setState("closed");// 节点以文件夹的形式体现
				} else {
					m.setState("open");// 节点以文件的形式体现
				}
				nl.add(m);
			}
		}
		return nl;
	}
	public void repairMenu() {
		Menu root = new Menu();
		root.setId("0");
		root.setText("首页");
		root.setUrl("");
		menuDao.saveOrUpdate(root);
		
		Menu xtgl = new Menu();
		xtgl.setId("xtgl");
		xtgl.setTmenu(root);
		xtgl.setText("系统管理");
		xtgl.setUrl("");
		menuDao.saveOrUpdate(xtgl);

		Menu yhgl = new Menu();
		yhgl.setId("yhgl");
		yhgl.setTmenu(xtgl);
		yhgl.setText("用户管理");
		yhgl.setUrl("/admin/yhgl.jsp");
		menuDao.saveOrUpdate(yhgl);

		Menu spgl = new Menu();
		spgl.setId("spgl");
		spgl.setTmenu(xtgl);
		spgl.setText("商品管理");
		menuDao.saveOrUpdate(spgl);

		Menu lxgl = new Menu();
		lxgl.setId("lxgl");
		lxgl.setTmenu(xtgl);
		lxgl.setText("类型管理");
		menuDao.saveOrUpdate(lxgl);

		Menu ddgl = new Menu();
		ddgl.setId("ddgl");
		ddgl.setTmenu(xtgl);
		ddgl.setText("订单管理");
		menuDao.saveOrUpdate(ddgl);
	}

}
