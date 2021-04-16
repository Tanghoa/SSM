package com.qst.Dao;

import com.qst.bean.Student;
import com.qst.bean.StudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
	long countByExample(StudentExample example);

	int deleteByExample(StudentExample example);

	int deleteByPrimaryKey(Integer id);

	int insert(Student record);

	int insertSelective(Student record);

	// ��ѯѧ����������Ϣ����department��Ϣ
	List<Student> selectByExamplewithDEP(StudentExample example);

	Student selectByPrimaryKeywithDEP(Integer id);

	List<Student> selectByExample(StudentExample example);

	Student selectByPrimaryKey(Integer id);

	int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

	int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);
}