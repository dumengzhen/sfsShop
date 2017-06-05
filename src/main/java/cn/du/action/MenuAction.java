package cn.du.action;

import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.du.pageModel.Tmenu;
import cn.du.service.MenuService;

import com.opensymphony.xwork2.ModelDriven;

@Controller
@Scope("prototype")
public class MenuAction extends BaseAction implements ModelDriven<Tmenu> {
	private Tmenu tmenu = new Tmenu();
	@Resource
	private MenuService menuService;

	@Override
	public Tmenu getModel() {
		return tmenu;
	}
	public void repairMenu(){
		menuService.repairMenu();
	}
	public void getTree() {
		super.writeJson(menuService.getTreeNode(tmenu.getId()));
	}

}
