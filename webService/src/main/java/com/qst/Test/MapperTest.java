package com.qst.Test;

import com.qst.Service.StudentService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationcontext.xml" })
public class MapperTest {

	@Autowired
    StudentService studentService;

	@Autowired
	SqlSession sqlSession;

	@Test
	public void test() {
//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//		List<Student> dep = mapper.selectByExamplewithDEP(null);
//		for (Student student : dep) {
//			System.out.println(student);
//		}
//		
//		Student dep2 = mapper.selectByPrimaryKeywithDEP(1);
//		System.out.println(dep2);

//		List<Department> list = mapper.selectByExample(null);
//		for (Department department : list) {
//			
//			System.out.println(department);
//		}

//		StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//	Random random = new	Random();
//		for(int i = 100;i<300;i++){
//			int j = random.nextInt(5)+1;
//			String uid = UUID.randomUUID().toString().substring(0,5)+i;
////			mapper.insertSelective(new Student(i,uid,uid+"@163.com",j));
//		}
//		System.out.println("�������");
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(11);
		studentService.deletewithAll(list);

	}

}
