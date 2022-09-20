package com.springboot.hospitaldetails;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.hospitaldetails.entity.Doctor;

@RestController
public class DoctorTestController {

	@RequestMapping(value = "/doctor", method = RequestMethod.GET)
	public Doctor firstPage() {

		Doctor doc = new Doctor();
		doc.setName("baburao");
		doc.setAge(25);
		doc.setGender("male");
		doc.setField("mmbs");

		return doc;
	}

}