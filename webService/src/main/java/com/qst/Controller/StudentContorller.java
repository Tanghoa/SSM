package com.qst.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qst.Dao.StudentMapper;
import com.qst.Service.StudentService;
import com.qst.bean.Info;
import com.qst.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Controller
public class StudentContorller {

	@Resource
	StudentService studentService;
	@Autowired
	StudentMapper studentMapper;
	
	//��ѯ����
	//@RequestMapping("/emps")
	public String ged() {
		return "list";
	}
	
	@RequestMapping(value = "edd")
	public String getEm() {
		
		System.out.println(1);
		Student byid = studentService.getByid();
		System.out.println(byid);
		return "a";
	}
	
	
	
	@RequestMapping("/emps")
	@ResponseBody
	public Info getEmps(@RequestParam(value = "pn", defaultValue = "1") Integer pn
			) {
		// �ⲻ��һ����ҳ��ѯ��
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Student> emps = studentService.getAll();
		
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
		return Info.success().add("pageInfo", page);
	}
	
	//@RequestMapping(value = "/emps" ,method = RequestMethod.GET)
	public String getEmps(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		// �ⲻ��һ����ҳ��ѯ��
		// ����PageHelper��ҳ���
		// �ڲ�ѯ֮ǰֻ��Ҫ���ã�����ҳ�룬�Լ�ÿҳ�Ĵ�С
		PageHelper.startPage(pn, 5);
		// startPage��������������ѯ����һ����ҳ��ѯ
		List<Student> emps = studentService.getAll();
		
		// ʹ��pageInfo��װ��ѯ��Ľ����ֻ��Ҫ��pageInfo����ҳ������ˡ�
		// ��װ����ϸ�ķ�ҳ��Ϣ,���������ǲ�ѯ���������ݣ�����������ʾ��ҳ��
		PageInfo page = new PageInfo(emps, 5);
		System.out.println(page.getTotal());
		model.addAttribute("pageInfo", page);

		return "list";
	}
	
	//����
	//@RequestMapping("/test")
	//@ResponseBody
	public Info tes() {
		Student byid = studentService.getByid();
		System.out.println(byid);
//		Student key = studentMapper.selectByPrimaryKey(1);
//		System.out.println(key);
		return Info.success();
	}

	
	//��������
	//@RequestMapping(value = "/emp" ,method = RequestMethod.GET)
	public String AddEMP() {
		return "input";
	}
	
	@RequestMapping(value = "/deps",method = RequestMethod.POST)
	@ResponseBody
	public Info saveDeps(Student student) {
		studentService.save(student);
		return Info.success();
	}
	
	
	//У���û����Ƿ��ظ�
	@RequestMapping(value = "/check",method = RequestMethod.POST)
	@ResponseBody
	public Info checkStu(@RequestParam("name")String name) {
		boolean b = studentService.checkStu(name);
		System.out.println(b);
		String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
		if(!name.matches(regx)){
			return Info.fail().add("info", "�û���������6-16λ���ֺ���ĸ����ϻ���2-5λ����");
		}
		if(b) {
			return Info.success();
		}
		else {
			System.out.println("false");
			
			return Info.fail().add("info", "�û���������");
		}
	}
	
	//���²���
	@ResponseBody
	@RequestMapping(value = "/stu/{id}",method = RequestMethod.PUT)
	public Info UpdateStu(Student student) {
		studentService.Updatestu(student);
		return Info.success();
	}
	//����id��ѯ
	@RequestMapping(value = "/stu/{id}",method = RequestMethod.GET)
	@ResponseBody
	public Info getStuById(@PathVariable("id")Integer id) {
	   Student id2 = studentService.getStuById(id);
	   return Info.success().add("stu", id2);
	}
	//ɾ������
	//����ɾ���͵�һɾ������һ
	@ResponseBody
	@RequestMapping(value = "/stu/{ids}",method = RequestMethod.DELETE)
	public Info Delete(@PathVariable("ids") String ids) {
		
		if(ids.contains("-")) {
			List<Integer> list =new ArrayList<>();
			String[] str = ids.split("-");
		for (String id : str) {
			list.add(Integer.parseInt(id));
		}
		studentService.deletewithAll(list);
		}else {
			Integer id = Integer.parseInt(ids);
			studentService.delete(id);
		}
		
		
		return Info.success();
	}

}
