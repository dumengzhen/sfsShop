package cn.du.action;

import org.springframework.stereotype.Controller;

import cn.du.service.OrderService;

@Controller
public class OrderAction extends BaseAction{
	private OrderService orderService;
	public void repaly(){
		orderService.repaly();
	}
}
