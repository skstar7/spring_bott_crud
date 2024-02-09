package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.PatientDao;
import com.example.demo.dto.PatientDto;

@RestController
@RequestMapping("/patients")
public class PatientController {

	@Autowired
	PatientDao patientDao;
	
	@PostMapping
	public String insertPatient(@RequestBody PatientDto dto) {
		System.out.println(dto);
		return patientDao.insertPatient(dto);
	}
	
	@GetMapping("/fetchbyid")
	public PatientDto fetchPatientById(@RequestParam int id) {
		//int id=dto.getId();
		return patientDao.fetchPatientById(id);
	}
	
	@GetMapping
	public List<PatientDto> fetchAll(){
		return patientDao.fetchAll();
	}
	
	@DeleteMapping("/deletebyid")
	public String deletePatientById(@RequestParam int id) {
		return patientDao.deletePatientById(id);
	}
	
	@PutMapping
	public String updatePatient(@RequestBody PatientDto dto) {
	return patientDao.updatePatient(dto);
	}
	
	@DeleteMapping
	public String deleteAll() {
		return patientDao.deleteAll();
	}
}
