package com.csm.Controller;

import com.csm.Model.GamingZoneRegistration;
import com.csm.Repository.GamingZoneRepository;
import com.csm.Utils.AgeCalculator;
import com.csm.Utils.GetDateByMonthArithmetic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class GamingZoneController {

	@Autowired
	private GamingZoneRepository gamingZoneRepository;

	@GetMapping(value = "/gamingZoneRegistration")
	public String gamingZoneRegistration(Model model){
		try {
			List<GamingZoneRegistration> gamingZoneRegistrationList = gamingZoneRepository.findAll();
			model.addAttribute("gamingZoneRegistration", new GamingZoneRegistration());
			model.addAttribute("gamingZoneRegistrationList", gamingZoneRegistrationList);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "GamingZoneRegistration";
	}

	@PostMapping(value = "/saveGamingZoneRegistration")
	public String gamingZoneRegistration(@ModelAttribute("gamingZoneRegistration")GamingZoneRegistration gamingZoneRegistration, Model model){
		System.out.println("Gaming Zone Registration" + gamingZoneRegistration);
		LocalDate dob = Date.valueOf(gamingZoneRegistration.getDob().toString()).toLocalDate();
		System.out.println(dob + "=======Sam=====" +  LocalDate.now());
		int age = AgeCalculator.calculateAge(dob, LocalDate.now());
		System.out.println("Age : " + age);
		gamingZoneRegistration.setAge(age);

		gamingZoneRegistration.setValidFrom(new Date(System.currentTimeMillis()));
		gamingZoneRegistration.setExpiredOn(GetDateByMonthArithmetic.getDate(gamingZoneRegistration.getSubDuration()));

		System.out.println("Full Data : " + gamingZoneRegistration);
		gamingZoneRepository.save(gamingZoneRegistration);

		List<GamingZoneRegistration> gamingZoneRegistrationList = gamingZoneRepository.findAll();
		model.addAttribute("gamingZoneRegistrationList", gamingZoneRegistrationList);
		return "GamingZoneRegistration";
	}

	@GetMapping(value = "/upgradeGamingZoneRegistration/{regId}")
	public String upgradeGamingZoneRegistration(@PathVariable("regId")int regId, Model model){
		System.out.println("Regd Id" + regId);
		GamingZoneRegistration gamingZoneRegistration = gamingZoneRepository.findByRegId(regId);
		System.out.println("Data : " + gamingZoneRegistration);
		model.addAttribute("gamingZoneRegistration", gamingZoneRegistration);
		List<GamingZoneRegistration> gamingZoneRegistrationList = gamingZoneRepository.findAll();
		model.addAttribute("gamingZoneRegistrationList", gamingZoneRegistrationList);
		return "GamingZoneRegistration";
	}
}
