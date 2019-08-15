package hfut.se.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import hfut.se.service.DoctorService;
import hfut.se.service.SectionService;
import hfut.se.service.UserService;
import hfut.se.service.exception.NotNullException;
import hfut.se.bean.Doctor;
import hfut.se.bean.Section;
import hfut.se.bean.User;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private SectionService sectionService;
	@Autowired
	private DoctorService doctorService;
	
	@RequestMapping("/loginload.do")
	public String loginLoad(HttpSession session){
		
		session.removeAttribute("error_type");
		return "login.jsp";
	}
	
	@RequestMapping("/login.do")
	public String login(String username, String password, HttpSession session, HttpServletRequest request, Model model) throws ServletException, IOException {

		User user = userService.login(username, password);
		
		if (user != null) {
			
			session.setAttribute("user", user);
			String loginType = user.getUsertype();
			session.setAttribute("usertype", loginType);
			
			String path = "/" + loginType + "/" + loginType + ".do";
			
			return "redirect:" + path;
		} else {
			model.addAttribute("error_type", "Wrong username or password.");
			return loginLoad(session);
		}
	}
	
	@ExceptionHandler
	public String doException(Exception e) throws Exception {
		e.printStackTrace();
		
		if (e instanceof NumberFormatException) {
			return "error_number_format.jsp";
		} else if (e instanceof MethodArgumentTypeMismatchException) {
			return "error_type_mismatch.jsp";
		} else {
			throw e;
		}
	}

}
