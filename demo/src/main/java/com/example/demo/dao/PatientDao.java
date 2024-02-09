package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.PatientDto;
import com.example.demo.repository.PatientRepository;

@Component
public class PatientDao {

	@Autowired
	PatientRepository repository;

	public String insertPatient(PatientDto dto) {
		repository.save(dto);
		return "inserted successfully";
	}

	public PatientDto fetchPatientById(int id) {
		Optional<PatientDto> od = repository.findById(id);
		// return od.get();
		if (od.isPresent()) {
			PatientDto dto = od.get();
			return dto;
		} else
			return null;
	}

	public List<PatientDto> fetchAll() {
		List<PatientDto> lp = repository.findAll();
		if (lp.isEmpty()) {
			return null;
		} else
			return lp;
	}

	public String updatePatient(PatientDto dto) {
		repository.save(dto);
		return "updated successfully";
	}

	public String deletePatientById(int id) {
         repository.deleteById(id);
         return "data deleted successfully";
	}

	public String deleteAll() {
		repository.deleteAll();
		return "all data deleted";
	}
}
