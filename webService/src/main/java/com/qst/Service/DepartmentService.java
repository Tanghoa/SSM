package com.qst.Service;

import com.qst.Dao.DepartmentMapper;
import com.qst.bean.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

	/**
	 * @Description
	 * @author Tanghoa
	 * @date 2020年9月11日
	 * @version 0.Max
	 */
	@Autowired
	DepartmentMapper departmentMapper;

	public List<Department> getdep() {

		return departmentMapper.selectByExample(null);
	}

	/**    
	* @Description
	* @author Tanghoa
	* @date 2020年9月11日  
	* @version 0.Max 
	*/  
	
	
}
