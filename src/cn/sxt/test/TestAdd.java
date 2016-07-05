package cn.sxt.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.sxt.bean.TeacherBean;
import cn.sxt.service.ClasssService;
import cn.sxt.service.PointsService;
import cn.sxt.service.ReasonService;
import cn.sxt.service.StudentService;
import cn.sxt.service.TeacherService;
import cn.sxt.service.impl.ClasssServiceImpl;
import cn.sxt.service.impl.PointsServiceImpl;
import cn.sxt.service.impl.ReasonServiceImpl;
import cn.sxt.service.impl.StudentServiceImpl;
import cn.sxt.service.impl.TeacherServiceImpl;
import cn.sxt.util.PageUtil;
import cn.sxt.vo.Classs;
import cn.sxt.vo.Points;
import cn.sxt.vo.Reason;
import cn.sxt.vo.Student;

/**
 * @author cc
 * 
 */
public class TestAdd {
	public static void main(String[] args) {
		
		TeacherService ts= new TeacherServiceImpl();
		PageUtil pu  = new PageUtil();
		TeacherBean tb = new TeacherBean();
		pu.setCurrentPage(1);
		
		System.out.println(ts.list(pu, tb).size());		
	
		
		
		
		
		
	}

}
