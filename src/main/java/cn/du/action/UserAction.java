package cn.du.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.du.entity.Goods;
import cn.du.entity.ShopCar;
import cn.du.entity.User;
import cn.du.pageModel.Json;
import cn.du.pageModel.Pgoods;
import cn.du.pageModel.Puser;
import cn.du.service.GoodsService;
import cn.du.service.UserService;
import cn.du.util.Encrypt;

import com.opensymphony.xwork2.ModelDriven;


@Controller
@Scope("prototype")
public class UserAction extends BaseAction implements ModelDriven<Puser> {
	@Resource
	private UserService userService;
	@Resource
	private GoodsService goodService;
	Json json = new Json();
	private Puser user = new Puser();

	public Puser getModel() {
		return user;
	}

	public void regist() {
		try {
			userService.save(user);
			json.setSuccess(true);
			json.setMsg("注册成功！");
		} catch (Exception e) {
			json.setMsg("注册失败！");
			e.printStackTrace();
		}
		super.writeJson(json);
	}

	public void add() {
		try {
			Puser user1 = userService.save(user);
			json.setSuccess(true);
			json.setMsg("添加成功！");
			json.setObj(user1);
		} catch (Exception e) {
			json.setMsg("添加失败！");
			e.printStackTrace();
		}
		super.writeJson(json);
	}

	public void login() {
		ServletActionContext.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		User user1 = userService.find(user);
		if (user1 != null) {
			json.setSuccess(true);
			json.setMsg("登录成功！");
			Cookie[] cookies = ServletActionContext.getRequest().getCookies();
			List<Goods> list = new ArrayList<Goods>();
			ShopCar shopCar = user1.getShopCar();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("shopcar")) {
					String str = cookie.getValue();
					String[] goods = str.split(",");
					for (String id : goods) {
						int goodsid = Integer.parseInt(id);
						Pgoods pgood = goodService.showById(goodsid);
						Goods good = new Goods();
						BeanUtils.copyProperties(pgood, good);
						list.add(good);
					}
				}
			}
			shopCar.setGoods(list);
			user1.setShopCar(shopCar);
		} else
			json.setMsg("登录失败！登录名或密码不正确");
		super.writeJson(json);
	}
	public void Mlogin(){
		if (user.getUserName().equals("admin")&&user.getUserPswd().equals("dudu")) {
			json.setSuccess(true);
			json.setMsg("登录成功！");
		} else
			json.setMsg("登录失败！登录名或密码不正确");
		super.writeJson(json);
	}
	public void datagrid() {
		super.writeJson(userService.datagride(user));
	}
	
	public void remove(){
		userService.remove(user.getIds());
		json.setMsg("删除成功！");
		json.setSuccess(true);
		super.writeJson(json);
	}
	public void edit(){
		Puser u = userService.edit(user);
		json.setMsg("修改成功!");
		json.setSuccess(true);
		json.setObj(u);
		super.writeJson(json);
	}
}
