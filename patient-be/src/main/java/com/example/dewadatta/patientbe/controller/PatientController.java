/**
 * 
 */
package com.example.dewadatta.patientbe.controller;

import java.awt.print.Pageable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dewadatta.patientbe.model.Patient;
import com.example.dewadatta.patientbe.service.PatientService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gdrana
 *
 */
@RestController
@Slf4j
@RequestMapping("/patients")
public class PatientController {
	@Autowired
	private PatientService patientService;

	@GetMapping("/{id}")
	public Patient findPatientById(@PathVariable("id") String requestData) {
		return patientService.findPatientById(requestData);
	}
	@GetMapping("/name/{name}")
	public Patient findPatientByName(@PathVariable("name") String requestData) {
		return patientService.findPatientByName(requestData);
	}
	@GetMapping("/")
	public Page<Patient> findAllPatient(Pageable pageable) {
		return patientService.findAll(pageable);
	}

	@PatchMapping("/{id}")
	public Patient updatePatientById(@PathVariable("id") String idPatient, @RequestBody Patient requestDataPatient) {
		return patientService.updatePatientById(idPatient, requestDataPatient);
	}

	@PostMapping("/")
	public Patient savePatient(@RequestBody Patient requestDataPatient) {
		return patientService.savePatient(requestDataPatient);
	}
}
