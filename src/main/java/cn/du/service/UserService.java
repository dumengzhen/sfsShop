package cn.du.service;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.du.dao.LikeDao;
import cn.du.dao.ShopCarDao;
import cn.du.dao.UserDao;
import cn.du.entity.Like;
import cn.du.entity.ShopCar;
import cn.du.entity.User;
import cn.du.pageModel.DataGrid;
import cn.du.pageModel.Puser;
import cn.du.util.Encrypt;

@Transactional
@Service
public class UserService {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(UserService.class);

	@Resource
	private UserDao userDao;
	@Resource
	private LikeDao likeDao;
	@Resource
	private ShopCarDao shopCarDao;

	// 把用户注册信息存入数据库

	public Puser save(Puser user) {
		User user1 = new User();
		BeanUtils.copyProperties(user, user1, new String[] { "userPswd" });// 把user的属性的值赋值到user1中,除去pwd，因为要加密
		user1.setUserPswd(Encrypt.e(user.getUserPswd()));
		ShopCar shopCar = new ShopCar();
		shopCar.setUser(user1);
		Like like = new Like();
		like.setUser(user1);
		userDao.save(user1);
		likeDao.save(like);
		shopCarDao.save(shopCar);
		BeanUtils.copyProperties(user1, user);
		return user;
	}

	public User find(Puser user) {
		Map<String, Object> params = new HashMap<String, Object>();
		System.out.println(user.getUserPswd());
		System.out.println(user.getTel());
		params.put("tel", user.getTel());
		params.put("userPswd", Encrypt.e(user.getUserPswd()));
		User u = userDao.getByHql("from User where tel=:tel and userPswd=:userPswd", params);
		return u;
	}

	public User findByid(int userid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userid", userid);
		return userDao.getByHql("from User where id =:userid", params);
	}
	public DataGrid datagride(Puser pUser) {
		DataGrid dataGrid = new DataGrid();
		Map<String, Object> params = new HashMap<String, Object>();
		String sql = "from User ";
		sql = addWhere(pUser, params, sql);
		int total = userDao.count(sql, params);
		sql = addSort(pUser, sql);
		List<User> user = userDao.find(sql, params, pUser.getPage(), pUser.getRows());
		List<Puser> list = new ArrayList<Puser>();
		changeModel(user, list);
		dataGrid.setTotal(total);
		dataGrid.setRows(list);
		return dataGrid;
	}

	private void changeModel(List<User> user, List<Puser> list) {
		if (user != null && user.size() > 0) {
			for (User u : user) {
				Puser puser = new Puser();
				BeanUtils.copyProperties(u, puser);
				list.add(puser);
			}
		}
	}

	private String addSort(Puser pUser, String sql) {
		if (pUser.getSort() != null && !pUser.getSort().equals("")) {
			sql = sql + " order by " + pUser.getSort() + " " + pUser.getOrder();
		}
		return sql;
	}

	private String addWhere(Puser pUser, Map<String, Object> params, String sql) {
		if (pUser.getUserName() != null && !pUser.getUserName().trim().equals("")) {
			sql = sql + " where name like :name";
			params.put("name", "%%" + pUser.getUserName().trim() + "%%");
		}
		return sql;
	}

	public void remove(String ids) {
		String[] nids = ids.split(",");
		String hql = "delete User u where u.id in (";
		for (int i = 0; i < nids.length; i++) {
			if(i>0){
				hql = hql + ",";
			}
			hql = hql+ "'"+nids[i]+"'";
		}
		hql = hql+")";
		userDao.executeHql(hql);
	}
	public Puser edit(Puser user){
		User u = userDao.get(User.class, user.getId());
		BeanUtils.copyProperties(user, u,new String[]{"id","pwd"});
		return user;
	}
}
