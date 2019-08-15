package hfut.se.web;



import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hfut.se.bean.EntryDelivery;
import hfut.se.bean.Medicine;
import hfut.se.bean.User;
import hfut.se.service.MedicineService;
import hfut.se.service.UserService;

@Controller
public class MedicineController {
	
	@Autowired
	private MedicineService  medicineService;
	@Autowired
	private UserService userService;
	
	@RequestMapping("/medmanager/entryDelivery.do")
	public String EntryDeliver() {
		return "/WEB-INF/ma_medicine.jsp";
	}
	
	@RequestMapping("/medmanager/MedicineList.do")
	public String  MedicineList(HttpServletRequest request){
		List<Medicine> medicines = 
				 medicineService.findAll();
		request.setAttribute("medicines", medicines);	
		return "/WEB-INF/medicine.jsp";
	}
	
	@RequestMapping("/medmanager/EntryList.do")
	public String  EntryList(HttpServletRequest request){

		List<EntryDelivery> ens = medicineService.findEntry();
		
		Medicine medicine = new Medicine();
		HashMap<EntryDelivery,Medicine> maps=new HashMap<EntryDelivery,Medicine>(); 
		for (EntryDelivery e : ens){	
			medicine =medicineService.findById(e.getMedicine_id());
			 maps.put(e,medicine);
		 }	
		request.setAttribute("maps", maps);		
		return "/WEB-INF/entry.jsp";		
	}
	
	@RequestMapping("/medmanager/DeliveryList.do")
	public String  DeliveryList(HttpServletRequest request){
		
		List<EntryDelivery> ens = medicineService.findDelivery();
		
		Medicine medicine = new Medicine();
		HashMap<EntryDelivery,Medicine> maps=new HashMap<EntryDelivery,Medicine>(); 
		for (EntryDelivery e : ens){	
			medicine =medicineService.findById(e.getMedicine_id());
			 maps.put(e,medicine);
		 }	
		request.setAttribute("maps", maps);		
		return "/WEB-INF/delivery.jsp";
	}
	
	@RequestMapping("/medmanager/sub.do")
	public String sub(HttpServletRequest request,
			    @RequestParam("select") 
	            String select,
				@RequestParam("id") 
				String id) {
		
		String jump = "#";
		 if(select.equals("entry") ){			
			if(medicineService.findById(id) == null) {
				jump ="/medmanager/addMedicine.do";
			}
			else 
				jump = "/medmanager/entry.do";
		}else if(select.equals("delivery"))
			jump =  "/medmanager/delivery.do";
	
		 return jump;
	}
	
	@RequestMapping("/medmanager/addMedicine.do")
	public String add(HttpServletRequest request,
			@RequestParam("id") 
				String id,
			@RequestParam("name")
				String name,
			@RequestParam("number")
				Integer number,
			@RequestParam("med_type")
				String med_type,
			@RequestParam("price")
				Double price){
		Medicine medicine = new Medicine();
		medicine.setId(id);
		medicine.setName(name);
		medicine.setNumber(number);
		medicine.setPrice(price);
		medicine.setMed_type(med_type);
		
		medicineService.addMedicine(medicine);
		medicineService.insertEntry(id, number);
		return "/medmanager/entryDelivery.do";
				
	}
	
	@RequestMapping("/medmanager/entry.do")
	public String entry(HttpServletRequest request,
			@RequestParam("id") 
				String id,
			@RequestParam("name")
				String name,
			@RequestParam("number")
				Integer number,
			@RequestParam("med_type")
				String med_type,
			@RequestParam("price")
				Double price){		
		
		medicineService.entry(id,name,number,med_type,price);
		return "/medmanager/entryDelivery.do";
		
	}
	@RequestMapping("/medmanager/delivery.do")
	public String  delivery(HttpServletRequest request,
			@RequestParam("id") 
				String id,
			@RequestParam("name")
				String name,
			@RequestParam("number")
				Integer number,
			@RequestParam("med_type")
				String med_type,
			@RequestParam("price")
				Double price){		
		medicineService.delivery(id,number);
		return "/medmanager/entryDelivery.do";
	}
	
	@RequestMapping("/medmanager/medmanager.do")
	public String  Medmanger(HttpSession session,
			HttpServletRequest request){
		
		User user =(User)session.getAttribute("user");
		String cardid = user.getUsername();
		User u = userService.findByUsername(cardid);
		request.setAttribute("u", u);
		
		return "/WEB-INF/medicine.jsp";
	}
	
	
}

