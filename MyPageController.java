package jp.co.internous.mushrooms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.mushrooms.model.domain.MstUser;
import jp.co.internous.mushrooms.model.mapper.MstUserMapper;
import jp.co.internous.mushrooms.model.session.LoginSession;

@Controller
@RequestMapping("/mushrooms/mypage")
public class MyPageController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstUserMapper userMapper;
	
	@RequestMapping("/")
	public String index(Model m) {
		MstUser user = userMapper.findByUserNameAndPassword(loginSession.getUserName(),loginSession.getPassword());
		m.addAttribute("user",user);
		m.addAttribute("loginSession",loginSession);
		return "my_page";
	}
	
}
