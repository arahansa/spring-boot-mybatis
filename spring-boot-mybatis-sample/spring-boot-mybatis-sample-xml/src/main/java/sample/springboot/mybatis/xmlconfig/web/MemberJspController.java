package sample.springboot.mybatis.xmlconfig.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sample.springboot.mybatis.xmlconfig.service.Member;
import sample.springboot.mybatis.xmlconfig.service.MemberMapper;

@Controller
public class MemberJspController {
	@Autowired
	MemberMapper memberMapper;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/dummy")
	public String dummy(){
		memberMapper.deleteMember();
	    for (Long i=0L; i<1000;i++){
	      Member member = new Member();
	      member.setId(Long.valueOf(i));
	      member.setName("member"+i);
	      member.setPhone("member"+i);
	      memberMapper.saveMember(member);
	    }
	    return "index";
	}
	
	@RequestMapping("/memberObj")
	public String memberObj(Model model){
		List<Member> findAll = memberMapper.findAll();
		model.addAttribute("list", findAll);
		return "memberObj";
	}
	
	@RequestMapping("/memberMap")
	public String memberMap(Model model){
		List<Map<String,Object>> findAllMap = memberMapper.findAllMap();
		model.addAttribute("list", findAllMap);
		return "memberMap";
	}
	
	@RequestMapping("/memberStr")
	public String memberStr(Model model){
		List<Map<String,String>> findAllString = memberMapper.findAllString();
		model.addAttribute("list", findAllString);
		return "memberStr";
	}
}
