package com.qst.Service;

import com.qst.Dao.StudentMapper;
import com.qst.bean.Student;
import com.qst.bean.StudentExample;
import com.qst.bean.StudentExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

	/**    
	* @Description
	* @author Tanghoa
	* @date 2020��9��10��  
	* @version 0.Max 
	*/  
	@Autowired
	StudentMapper studentMapper;
	
	
	

	public StudentMapper getStudentMapper() {
		return studentMapper;
	}




	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}




	/**    
	* @Description
	* @author Tanghoa
	* @date 2020��9��10��  
	* @version 0.Max 
	*/  
	
	public void add(Student student) {
		studentMapper.insert(student);
		
	}




	/**    
	* @Description
	* @author Tanghoa
	* @date 2020��9��10��  
	* @version 0.Max 
	*/  
	
	public List<Student> getAll() {
		// TODO Auto-generated method stub
//		StudentExample example = new StudentExample();
//		example.setOrderByClause("id");
		return studentMapper.selectByExamplewithDEP(null);
	}
	
	public Student getByid() {
		return studentMapper.selectByPrimaryKey(1);
	}




	/**    
	* @Description
	* @author Tanghoa
	* @date 2020��9��11��  
	* @version 0.Max 
	*/  
	//���淽��
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentMapper.insertSelective(student);
	}




	/**    
	* @Description
	* @author Tanghoa
	* @date 2020��9��12��  
	* @version 0.Max 
	*/  
	
	public boolean checkStu(String name) {
		
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo(name);
		long l = studentMapper.countByExample(example );
		System.out.println("����ǣ�"+l);
	    return l == 0;
	}




	/**    
	* @Description
	* @author Tanghoa
	* @date 2020��9��12��  
	* @version 0.Max 
	*/  
	//����id��ѯ��Ϣ
	public Student getStuById(Integer id) {
		
		return studentMapper.selectByPrimaryKeywithDEP(id);
		
	}




	/**    
	* @Description
	* @author Tanghoa
	* @date 2020��9��12��  
	* @version 0.Max 
	*/  
	
	public void Updatestu(Student student) {
		// TODO Auto-generated method stub
		studentMapper.updateByPrimaryKeySelective(student);
	}




	/**    
	* @Description
	* @author Tanghoa
	* @date 2020��9��14��  
	* @version 0.Max 
	*/  
	
	public void delete(Integer id) {
		studentMapper.deleteByPrimaryKey(id);
	
		
	}




	/**    
	* @Description
	* @author Tanghoa
	* @date 2020��9��14��  
	* @version 0.Max 
	*/  
	//����ɾ��
	public void deletewithAll(List<Integer> list) {
		StudentExample example = new StudentExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdIn(list);
		studentMapper.deleteByExample(example);
		
	}

}
