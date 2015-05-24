package cn.ac.iie.controller;

import cn.ac.iie.model.User;
import cn.ac.iie.service.impl.UserServiceImpl;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource(name = "userService")
	private UserServiceImpl userService;

	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Map<String, Object> login(User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean loginResult = userService.isExist(user);
		map.put("loginResult", loginResult);
		return map;
	}

}
