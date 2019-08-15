package hfut.se.web;


import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hfut.se.bean.Doctor;
import hfut.se.bean.Medicine;
import hfut.se.bean.Patient;
import hfut.se.bean.Prescription;
import hfut.se.bean.User;
import hfut.se.service.DoctorService;
import hfut.se.service.MedicineService;
import hfut.se.service.PatientService;
import hfut.se.service.PrescriptionService;

@Controller
public class PatientController {

	
	@Autowired
	private PatientService  patientService;
	
	@Autowired
	private DoctorService   doctorService;
	@Autowired
	private PrescriptionService prescriptionService ;
	
	@Autowired
	private MedicineService   medicineService;

	
	@RequestMapping("/patient/patient.do")
	public String  InforPatient(HttpSession session,
			HttpServletRequest request){
		
		User user =(User)session.getAttribute("user");
		String cardid = user.getUsername();
		Patient patient = patientService.findByCardid(cardid);
		request.setAttribute("patient", patient);
	
		return "/WEB-INF/patient.jsp";
	}
	
	@RequestMapping("/patient/update_phone.do")
	public String update_phone(HttpSession session,HttpServletRequest request,
			  @RequestParam("phone") String phone) {
		
		User user =(User)session.getAttribute("user");
		String cardid = user.getUsername();
		patientService.update_phone(cardid, phone);
		return "/patient/patient.do";
	}
	@RequestMapping("/patient/findDoc.do")
	public String findDoc(HttpServletRequest request) {
		
		List<Doctor> doctors = doctorService.findAll();
		request.setAttribute("doctors",doctors);	
		
		return "/WEB-INF/pat_doc.jsp";
	}
	@RequestMapping("/patient/findHistory.do")
	public String  findHistory(HttpServletRequest request,HttpSession session) {
		
		User user =(User)session.getAttribute("user");
		String id = user.getUsername();
		List<Prescription> precriptions = prescriptionService.findByCardId(id);
		Medicine medicine = new Medicine();
		HashMap<Prescription, Medicine> maps = new HashMap<Prescription,Medicine>();
		
		for (Prescription prescription : precriptions) {

			medicine =medicineService.findById(prescription.getMed_id());	
			maps.put(prescription,medicine);

		}	
		request.setAttribute("maps", maps);
		return "/WEB-INF/p_history.jsp";
		
	}
}
