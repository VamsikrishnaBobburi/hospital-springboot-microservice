package com.springboot.hospitaldetails;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospitaldetails.entity.Doctor;
import com.springboot.hospitaldetails.entity.Patient;

@RestController
public class PatientTestController {

	@RequestMapping(value = "/patient", method = RequestMethod.GET)
	public Patient firstPage() {

		Patient pt = new Patient();
		pt.setName("kumar");
		pt.setAge(25);
		pt.setGender("male");
		pt.setDoctor_name("baburao");
		pt.setDate_of_visit("12-08-2022");
		pt.setPrescription("fever");
		return pt;
	}

}