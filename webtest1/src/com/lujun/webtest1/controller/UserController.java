package com.lujun.webtest1.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lujun.frame.common.Constants;
import com.lujun.frame.common.SqlConstants;
import com.lujun.frame.generic.GenericService;
import com.lujun.frame.query.Query;
import com.lujun.frame.query.SimpleCriteria;
import com.lujun.webtest1.model.User;

@Controller
@RequestMapping("/user")
public class UserController {

	private static Logger logger = Logger.getLogger(UserController.class);

	@Resource
	private Query query;

	@Resource
	private GenericService<User> userService;
	
	@RequestMapping("/list")
	public String List() {
		return "/user/user-list";
	}

	/**
	 * 查询所有用户信息
	 * 
	 * @param criteria
	 * @param sort
	 *            分页参数
	 * @param order
	 *            排序方式
	 * @return
	 */
	@RequestMapping("/querys")
	@ResponseBody
	public Map<String, Object> querys(SimpleCriteria criteria, String sort,
			String order) {
		if (sort != "" && order != "") {
			criteria.setStrVal8(sort + " " + order + ",");
		}
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("rows",query.queryForPage(SqlConstants.LOAD_PAGR_USER, criteria));
		return data;
	}

	@RequestMapping("/view")
	public ModelAndView view(Long id) {
		ModelAndView modelAndView = new ModelAndView("/user/user-view");
		modelAndView.addObject("user", userService.find(id));
		return modelAndView;
	}

	@RequestMapping("/edit")
	public ModelAndView edit(Long id) {
		ModelAndView modelAndView = new ModelAndView("/user/user-edit");
		modelAndView.addObject("user", userService.find(id));
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView add() {
		ModelAndView modelAndView = new ModelAndView("/user/user-edit");
		modelAndView.addObject("user", new User());
		return modelAndView;
	}

	@RequestMapping("/remove")
	@ResponseBody
	public String remove(Long id) {
		try {
			userService.remove(id);
		} catch (Exception e) {
			return Constants.FAIL;
		}
		return Constants.SUCCESS;
	}

	@RequestMapping("/save")
	@ResponseBody
	public String save(@ModelAttribute("user") User user) {
		SimpleCriteria criteria = new SimpleCriteria();
		try {
			criteria.setStrVal1(user.getUserName());
			criteria.setLonVal1(user.getUserId());
			if (query.isExists(SqlConstants.EXISTS_USER_NAME, criteria)) {
				return Constants.FAIL;
			}
			if (user.getUserId() == null) {
				for(int i=0;i<1000000;i++){
					User user2 = new User();
					user2.setUserAddress(user.getUserAddress()+i);
					user2.setUserAge(user.getUserAge()+i);
					user2.setUserEmail(user.getUserEmail()+i);
					user2.setUserPass(user.getUserPass()+i);
					user2.setUserIdCard(user.getUserIdCard()+i);
					user2.setUserName(user.getUserName()+i);
					user2.setUserQq(user.getUserQq()+i);
					user2.setUserSex(user.getUserSex()+i);
					user2.setUserTel(user.getUserTel()+i);
					userService.save(user2);
				}
				
			} else {
				userService.update(user);
			}
			return Constants.SUCCESS;
		} catch (Exception e) {
			logger.error("save user error !", e);
			return Constants.FAIL;
		}
	}
}
