package com.qst.Controller;

import com.qst.Dao.DepartmentMapper;
import com.qst.Service.DepartmentService;
import com.qst.bean.Department;
import com.qst.bean.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DepartmentController {

	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	DepartmentMapper departmentMapper;
	//@ResponseBody(�÷�)��װ����
	@RequestMapping("/deps")
	@ResponseBody
	public Info getDeps() {
		System.out.println("success");
		List<Department> list = departmentService.getdep();
		
		return Info.success().add("depts", list);
	}
	//@ResponseBody��װjson����
		@RequestMapping("/test")
		@ResponseBody
		public Info test() {
			System.out.println(1);
			Department selectByPrimaryKey = departmentMapper.selectByPrimaryKey(1);
			System.out.println(selectByPrimaryKey);
			return Info.success();
		}
		@ResponseBody
		@RequestMapping("/webService_war_exploded/use")
		public void tes1t(){
			System.out.println("asf");
		}

	@RequestMapping("/main.html")
	public String tests(){
		return "main";
	}

	
}
