package hfut.se.web;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hfut.se.bean.Doctor;
import hfut.se.bean.Patient;
import hfut.se.bean.Prescription;
import hfut.se.bean.Section;
import hfut.se.bean.User;
import hfut.se.mapper.PatientMapper;
import hfut.se.service.DoctorService;
import hfut.se.service.PrescriptionService;
import hfut.se.service.SectionService;

@Controller
public class DoctorController {
	@Autowired
	private DoctorService ds;
	@Autowired
	private PatientMapper dm;
	@Autowired
	private PrescriptionService ps;
	@Autowired
	private SectionService ss;
	
	@RequestMapping("/Doctor/listprescription.do")
	public String addPrescription() {
		return "/WEB-INF/prescription.jsp";
	}
	@RequestMapping("/Doctor/Doctor.do")
	public String findById(HttpSession session,HttpServletRequest request) {
		User user = (User)session.getAttribute("user");
		Doctor doctor = ds.findById(user.getUsername());
		request.setAttribute("doctor", doctor);
		return "/WEB-INF/doctorPSInfo.jsp";
	}
	@RequestMapping("/Doctor/patientInfo.do")
		public String findAllByDid(HttpSession session,HttpServletRequest request) {
		    User user = (User)session.getAttribute("user");
			List<Patient> patients=dm.findAllByDid(user.getUsername());
			request.setAttribute("patients", patients);
			return "/WEB-INF/patientInfo.jsp";
		}
	@RequestMapping("/Doctor/addPrescription.do")
	public String addPrescription(@RequestParam("cardid") String cardid,@RequestParam("med_id") String med_id,@RequestParam("number") Integer number, HttpSession session, 
			HttpServletRequest request, Model model)throws ServletException, IOException{
		
		System.out.println(cardid + " " + med_id);
		
		if(cardid!=null) {
		Date date=new Date();
		Integer ispaid=0;
		User user = (User)session.getAttribute("user");
		String did=user.getUsername();
		Prescription prescription = new Prescription(null, cardid, med_id,number,date, did,ispaid);
		System.out.println(prescription.getCardid());
        ps.add(prescription); 
        System.out.println(did);
        request.setAttribute("prescription", prescription);
        List<Prescription> prescriptions = ps.findNowPrescription(cardid, did, ispaid);
        request.setAttribute("prescriptions", prescriptions);  
        return "/WEB-INF/prescription.jsp";
		}else {
			return "/WEB-INF/prescription.jsp";
		}
     
  
	}
	@RequestMapping("Doctor/delPrescription.do")
	public String delPrescription(@RequestParam("id") Integer id, HttpServletRequest request, Model model) 
			throws ServletException, IOException {
		Prescription prescription=ps.findById(id);
		String cardid=prescription.getCardid();
		String did=prescription.getDid();
		Integer ispaid=0;
		ps.delete(id);
		List<Prescription> prescriptions = ps.findNowPrescription(cardid, did, ispaid);
	        request.setAttribute("prescriptions", prescriptions);  
	    return "/WEB-INF/prescription.jsp";

	}
	@RequestMapping("/Doctor/sectionInfo.do")
	public String  findAllDactor(Integer sid,HttpServletRequest request) {
		sid=1;
		List<Doctor> doctors=ds.findBySection(sid);
		request.setAttribute("doctors", doctors);
		
		Section section=ss.findById(sid);
		request.setAttribute("section", section);
		
		return "/WEB-INF/sectionInfo.jsp";
		
	}
	
	@RequestMapping("/Doctor/updateDoctorPS.do")
	public String update(HttpSession session,
			@RequestParam("phone") String phone,
			@RequestParam("email") String email,
			@RequestParam("info") String info,
            HttpServletRequest request) {
		User user = (User)session.getAttribute("user");
		String id=user.getUsername();
		Doctor doctor = ds.findById(id);
		doctor.setPhone(phone);
		doctor.setEmail(email);
		doctor.setInfo(info);
	    ds.update(doctor);
		return "Doctor.do";
	}
}


