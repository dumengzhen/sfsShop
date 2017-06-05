package cn.du.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import cn.du.pageModel.Pgoods;
import cn.du.pageModel.Ptype;
import cn.du.service.TypeService;

@Controller
@Scope("prototype")
public class TypeAction extends BaseAction implements ModelDriven<Ptype> {
	@Resource
	private TypeService typeService;
	private Ptype ptype = new Ptype();

	@Override
	public Ptype getModel() {
		return ptype;
	}

	public void showType() {
		System.out.println(ptype.getTname());
		List<Ptype> list = typeService.showType(ptype.getTname());
		super.writeJson(list);
	}
}
