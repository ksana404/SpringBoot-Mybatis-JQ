package com.per.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.per.entity.User;
import com.per.entity.vo.JsonResult;
import com.per.service.UserService;

@Controller
@RequestMapping("/user/")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	

	
/**
 1.url地址:localhost:8090/ajax_findAll
2.要求跳转userList_ajax.jsp页面
3.之后浏览器解析js发起ajax请求localhost:8090/ajax
4.获取数据之后,在页面中展现表格数据.
 * 
 * */	
	
	/*ajax 练习
	 * Model 翻译:模型
	 * 
	 * 页面URL: findUser.html
	 * 
	 * 发送页面值: /ajax_user
	 * 
	 * 
	 * 
	 * 
	 * http://localhost:8084/user/find
	 * */

	//页面跳转
	@RequestMapping("findUser")
	public String dofindUser() {

		return "findUser";
	}
	
	//发送ajax  实现数据与url 的不一致
	@ResponseBody
	@RequestMapping("ajax_user")
	public Object doAjaxUser() {
		List<User> list	= userService.finds();
		
		
		
		return list;
	}
	

	
	// http://localhost:8084/user/doUI
	@RequestMapping("dofindUI")
	public String doUI() {
	
		return "user_list_jq";
		
	}
	
	
	
	/**	// USER: user/find	
	 * @return
	 */
	@ResponseBody
	@RequestMapping("find")
	public JsonResult doFind() {
	List<User> list	= userService.finds();
	
	
		return new JsonResult(list);
		
	}
	
	
	

}
