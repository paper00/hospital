package test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hfut.se.bean.CheckInfo;
import hfut.se.bean.Patient;
import hfut.se.bean.Prescription;
import hfut.se.bean.User;
import hfut.se.mapper.CheckMapper;
import hfut.se.mapper.PatientMapper;
import hfut.se.mapper.UserMapper;
import hfut.se.service.CheckService;
import hfut.se.service.PatientService;

public class TestCase {

	@Test
	public void test1() {
		String conf = "applicationContext.xml";
		ApplicationContext ctx = new ClassPathXmlApplicationContext(conf);
		System.out.println("----------------------");
		
		CheckService cs = ctx.getBean(CheckService.class);
		cs.check("patient6", "Siri");
	}
}
