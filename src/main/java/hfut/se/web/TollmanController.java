package hfut.se.web;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hfut.se.bean.Patient;
import hfut.se.bean.Prescription;
import hfut.se.bean.User;
import hfut.se.service.CheckService;
import hfut.se.service.PatientService;
import hfut.se.service.UserService;

@Controller
public class TollmanController implements Serializable{
	
	//register
	@Autowired
	private UserService userService;
	
	@Autowired
	private PatientService patientService;
	
	@RequestMapping("/Tollman//Tollman.do")
	public String tollman() {
		return "/WEB-INF/addPatient.jsp";
	}
	
	@RequestMapping("/Tollman/charge.do")
	public String charge() {
		return "/WEB-INF/charge.jsp";
	}
	
	@RequestMapping("/Tollman/register.do")
	public String register(@RequestParam("username") String username, @RequestParam("pwd") String pwd,
		@RequestParam("patientName") String name, @RequestParam("gender") String sex, @RequestParam("tel") String tel,
		HttpServletRequest request, Model model){
		
		User user = new User(null, username, pwd, "Patient");
		Patient patient = new Patient();
		patient.setCardid(username);
		patient.setName(name);
		patient.setPassword(pwd);
		patient.setSex(sex);
		patient.setPhone(tel);
		
		patientService.register(user);
		patientService.add(patient);
		
		return "/WEB-INF/addPatient.jsp";
	}
	
	//check
	@Autowired
	private CheckService checkService;
	
	@RequestMapping("/Tollman/PreList.do")
	public String getAllPre(@RequestParam("cardId") String cardId,  HttpServletRequest request) {
			
			List<Prescription> prescriptions = checkService.findPreByCardId(cardId);
			request.setAttribute("prescriptions", prescriptions);
			request.setAttribute("id", cardId);
			return "/WEB-INF/charge.jsp";	
	}
	
	@RequestMapping("/Tollman/check.do")
	public String check(@RequestParam("id") String cardId, HttpSession session,
				HttpServletRequest request, Model model) {
		User user = (User)session.getAttribute("user");
		Double price = checkService.check(cardId, user.getUsername());
		System.out.println(price);
		request.setAttribute("prices", price);
		return "/WEB-INF/charge.jsp";
	}

}
