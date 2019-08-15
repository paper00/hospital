package hfut.se.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import hfut.se.bean.Doctor;
import hfut.se.bean.Medicine;
import hfut.se.bean.Patient;
import hfut.se.bean.Prescription;
import hfut.se.bean.Section;
import hfut.se.bean.User;
import hfut.se.service.DoctorService;
import hfut.se.service.MedicineService;
import hfut.se.service.PatientService;
import hfut.se.service.PrescriptionService;
import hfut.se.service.SectionService;
import hfut.se.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private DoctorService doctorService;
	@Autowired
	private SectionService sectionService;
	@Autowired
	private PatientService patientService;
	@Autowired
	private PrescriptionService prescriptionService;
	@Autowired
	private MedicineService medicineService;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@RequestMapping("/Admin/Admin.do")
	public String admin(HttpServletRequest request) {
		
		Integer section_num = sectionService.getCount();
		request.setAttribute("section_num", section_num);
		
		Integer doctor_num = doctorService.getCount();
		request.setAttribute("doctor_num", doctor_num);

		Integer medicine_num = medicineService.getCount();
		request.setAttribute("medicine_num", medicine_num);
		
		return "/WEB-INF/Admin.jsp";
	}
	
	@RequestMapping("/Admin/AdminDoctorList.do")
	public String adminDoctorList(HttpServletRequest request) {
		
		List<Doctor> doctors = doctorService.findAll();
		request.setAttribute("doctors", doctors);
		
		List<String> section_name = new ArrayList<String>();
		for (Doctor doctor : doctors) {
			Section section = sectionService.findById(doctor.getSid());
			String name = section.getName();
			section_name.add(name);
		}
		request.setAttribute("section_name", section_name);
		
		return "/WEB-INF/AdminDoctorList.jsp";
	}
	
	@RequestMapping("/Admin/AdminSectionList.do")
	public String adminSectionList(HttpServletRequest request) {
		
		List<Section> sections = sectionService.findAll();
		request.setAttribute("sections", sections);
		
		return "/WEB-INF/AdminSectionList.jsp";
	}
	
	@RequestMapping("/Admin/AdminSearchPatient.do")
	public String adminSearchPatient(HttpServletRequest request) {
		
		return "/WEB-INF/AdminSearchPatient.jsp";
	}
	
	@RequestMapping("/Admin/AdminSearchIncome.do")
	public String searchIncome(HttpServletRequest request) {
		
		List<Section> secs = sectionService.findAll();
		request.setAttribute("secs", secs);
		
		return "/WEB-INF/AdminSearchSectionIncome.jsp";
	}
	
	@RequestMapping("/Admin/modifyload.do")
	public String modifyload() {
		return "/WEB-INF/AdminModify.jsp";
	}
	
	@RequestMapping("/Admin/modifyprofile.do")
	public String modifyprofile(@RequestParam("username") String username, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		user.setUsername(username);
		userService.update(user);
		
		session.setAttribute("user", user);
		
		return "/WEB-INF/AdminModify.jsp";
	}
	
	@RequestMapping("/Admin/modifypwload.do")
	public String modifyPwLoad(HttpServletRequest request) {
		
		return "/WEB-INF/AdminModifyPw.jsp";
	}
	
	@RequestMapping("/Admin/modifypw.do")
	public String modifyPw(@RequestParam("ori_pw") String ori_pw, @RequestParam("new_pw") String new_pw,
			@RequestParam("new_pw_again") String new_pw_again, @RequestParam("username") String username, 
			HttpServletRequest request, HttpSession session) throws ServletException, IOException {
		
		if (!new_pw.equals(new_pw_again)) {
			request.setAttribute("wrong_0", "密码不一致");
		} else {
			String pw = DigestUtils.md5Hex(ori_pw);
			User user = userService.findByUsername(username);
			
			if (pw.equals(user.getPassword())) {
				
				user.setPassword(new_pw);
				userService.update(user);
				
				request.setAttribute("success", "密码修改成功");
			} else {
				request.setAttribute("wrong_1", "原来的密码输入错误");
			}
		}
		
		return modifyPwLoad(request);
	}
	
	@RequestMapping("/Admin/adddoctorload.do") 
	public String addDoctorLoad(HttpServletRequest request){
		
		List<Section> secs = sectionService.findAll();
		request.setAttribute("secs", secs);
		
		return "/WEB-INF/AdminAddDoctor.jsp";
	}
	
	@RequestMapping("/Admin/addsectionload.do") 
	public String addSectionLoad(){
		return "/WEB-INF/AdminAddSection.jsp";
	}
	
	@RequestMapping("/Admin/adddoctor.do")
	public String addDoctor(Doctor doctor, HttpServletRequest request, Model model) 
			throws ServletException, IOException {
		
		if (doctor != null) {
			
			User user = new User(null, doctor.getId(), null, "Doctor");
			
			doctorService.add(doctor);
			userService.add(user);
			
			return adminDoctorList(request);
		} else {
			model.addAttribute("operate_failed", "Error to operate.");
			return "/WEB-INF/AdminAddDoctor.jsp";
		}
	}
	
	@RequestMapping("/Admin/modifydoctorload.do")
	public String modifyDoctorLoad(@RequestParam("id") String id, HttpServletRequest request, Model model) 
			throws ServletException, IOException {
		
		Doctor doctor = doctorService.findById(id);
		
		if (doctor != null) {
			
			List<Section> secs = sectionService.findAll();
			request.setAttribute("secs", secs);
			request.setAttribute("selected", doctor);
			
			return "/WEB-INF/AdminModifyDoctor.jsp";
		} else {
			model.addAttribute("operate_failed", "Error to operate.");
			return "/WEB-INF/AdminDoctorList.jsp";
		}
	}
	
	@RequestMapping("/Admin/modifydoctor.do")
	public String modifyDoctor(Doctor doctor, HttpServletRequest request, Model model) 
					throws ServletException, IOException {
		
		if (doctor != null) {
			
			User user = new User(null, doctor.getId(), null, "Doctor");
			
			doctorService.update(doctor);
			userService.update(user);
			
			return adminDoctorList(request);
		} else {
			
			model.addAttribute("operate_failed", "Error to operate.");
			return "/WEB-INF/AdminModifyDoctor.jsp";
		}
	}
	
	@RequestMapping("/Admin/deldoctor.do")
	public String delDoctor(@RequestParam("id") String id, HttpServletRequest request, Model model) 
					throws ServletException, IOException {
		Doctor doctor = doctorService.findById(id);
		System.out.println(doctor);
		
		if (doctor != null) {
			
			User user = userService.findByUsername(doctor.getId());
			
			doctorService.delete(id);
			userService.delete(user.getId());
			
			return adminDoctorList(request);
		} else {
			
			model.addAttribute("operate_failed", "Error to operate.");
			return "/WEB-INF/AdminDoctorList.jsp";
		}
	}
	
	@RequestMapping("/Admin/addsection.do")
	public String addSection(Section section, HttpServletRequest request, Model model) 
			throws ServletException, IOException {
		
		if (section != null) {
			
			sectionService.add(section);
			
			return adminSectionList(request);
		} else {
			model.addAttribute("operate_failed", "Error to operate.");
			return "/WEB-INF/AdminAddSection.jsp";
		}
	}
	
	@RequestMapping("/Admin/modifysectionload.do")
	public String modifySectionLoad(@RequestParam("id")String id, HttpServletRequest request, Model model) 
			throws ServletException, IOException {
		
		Section section = sectionService.findById(Integer.parseInt(id));
		
		if (section != null) {
			request.setAttribute("selected", section);
			return "/WEB-INF/AdminModifySection.jsp";
		} else {
			model.addAttribute("operate_failed", "Error to operate.");
			return adminSectionList(request);
		}
	}
	
	@RequestMapping("/Admin/modifysection.do")
	public String modifySection(Section section, HttpServletRequest request, Model model)
			throws ServletException, IOException {
		
		if (section != null) {
			sectionService.update(section);
			
			return adminSectionList(request);
		} else {
			
			model.addAttribute("operate_failed", "Error to operate.");
			return "/WEB-INF/AdminModifySection.jsp";
		}
	}
	
	@RequestMapping("/Admin/delsection.do")
	public String DelSection(@RequestParam("id") String id, HttpServletRequest request, Model model)
			throws ServletException, IOException {
		
		Section section = sectionService.findById(Integer.parseInt(id));
		
		if (section != null) {
			sectionService.delete(Integer.parseInt(id));
			
			return adminSectionList(request);
		} else {
			
			model.addAttribute("operate_failed", "Error to operate.");
			return adminSectionList(request);
		}
	}
	
	@RequestMapping("/Admin/secdoclist.do")
	public String secDocList(@RequestParam("id") String id, HttpServletRequest request, Model model)
			throws ServletException, IOException {
		
		Section section = sectionService.findById(Integer.parseInt(id));
		
		if (section != null) {
			List<Doctor> doctors = doctorService.findBySection(section.getId());
			request.setAttribute("doctors", doctors);
			
			List<String> section_name = new ArrayList<String>();
			for (Doctor doctor : doctors) {
				Section temp = sectionService.findById(doctor.getSid());
				String name = temp.getName();
				section_name.add(name);
			}
			request.setAttribute("section_name", section_name);
			
			return "/WEB-INF/AdminDoctorList.jsp";
		} else {
			
			model.addAttribute("visit_error", "Error to visit 'Section's doctor Patient'");
			return adminSectionList(request);
		}
	}
	
	@RequestMapping("/Admin/searchpatient_0.do")
	public String searchPatientByDate(@RequestParam("begin") String begin, @RequestParam("end") String end, 
			HttpServletRequest request, Model model) throws ServletException, IOException, ParseException {
		
		if (begin != "" && end != "") {
			
			Date startTime = sdf.parse(begin);
			Date endTime = sdf.parse(end);
			
			List<Prescription> prescriptions = prescriptionService.findByDate(startTime, endTime);
			List<Patient> patients = new ArrayList<Patient>();
			
			for (Prescription prescription : prescriptions) {
				Patient patient = patientService.findByCardid(prescription.getCardid());
				if (patient != null) {
					patients.add(patient);
				}
			}
			
			request.setAttribute("patients", patients);
			return "/WEB-INF/AdminSearchPatient.jsp";
		} else {
			
			model.addAttribute("operate_error_0", "日期不能为空");
			return "/WEB-INF/AdminSearchPatient.jsp";
		}
	}
	
	@RequestMapping("/Admin/searchpatient_1.do")
	public String searchPatientByCardid(@RequestParam("cardid") String cardid, 
			HttpServletRequest request, Model model) throws ServletException, IOException, ParseException {
		
		if (cardid != "") {
			
			Patient patient = patientService.findByCardid(cardid);
			request.setAttribute("patient", patient);
			
			return "/WEB-INF/AdminSearchPatient.jsp";
		} else {
			
			model.addAttribute("operate_error_1", "Card ID 不能为空");
			return "/WEB-INF/AdminSearchPatient.jsp";
		}
	}
	
	@RequestMapping("/Admin/loadincome.do")
	public String loadIncome(@RequestParam("begin") String begin, @RequestParam("end") String end, 
			@RequestParam("sid") String sid, HttpServletRequest request, Model model) 
					throws ServletException, IOException, ParseException {
		
		if (begin != "" && end != "") {
			
			Date startTime = sdf.parse(begin);
			Date endTime = sdf.parse(end);
			
			List<Prescription> prescriptions = new ArrayList<Prescription>();
			
			if (sid.equals("all")) {
				
				List<Section> sections = sectionService.findAll();
				List<Double> totals = new ArrayList<Double>();	
				
				for (Section section : sections) {
					double total = 0;
					prescriptions = prescriptionService.findBySidAndDate(startTime, endTime, section.getId());
					for (Prescription prescription : prescriptions) {
						Medicine medicine = medicineService.findById(prescription.getMed_id());
						Double price = medicine.getPrice();
						total += (price * prescription.getNumber());
					}
					totals.add(total);
					
					request.setAttribute("sections", sections);
					request.setAttribute("totals", totals);
				}
				
			} else {
				
				double total = 0;
				prescriptions = prescriptionService.findBySidAndDate(startTime, endTime, Integer.parseInt(sid));
				for (Prescription prescription : prescriptions) {
					Medicine medicine = medicineService.findById(prescription.getMed_id());
					Double price = medicine.getPrice();
					total += (price * prescription.getNumber());
				}
				
				Section section = sectionService.findById(Integer.parseInt(sid));
				request.setAttribute("section", section);
				request.setAttribute("total", total);
			}
			
			return searchIncome(request);
		}else {
			
			model.addAttribute("operate_error", "日期不能为空");
			return searchIncome(request);
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
