/**
 * 
 */
package com.example.dewadatta.patientbe.service.impl;

import java.awt.print.Pageable;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.dewadatta.patientbe.model.Patient;
import com.example.dewadatta.patientbe.repository.PatientRepository;
import com.example.dewadatta.patientbe.service.PatientService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author gdrana
 *
 */
@Service
@Slf4j
public class PatientServiceImpl implements PatientService {
	@Autowired
	private PatientRepository patientRepository;
	@Override
	public Patient findPatientById(String requestData) {
		// TODO Auto-generated method stub
		return patientRepository.findById(requestData).get();
	}

	@Override
	public Page<Patient> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return (Page<Patient>) patientRepository.findAll(Sort.by("name"));
	}
	@Transactional
	@Override
	public Patient updatePatientById(String idPatient, Patient requestDataPatient) {
		// TODO Auto-generated method stub
		Optional<Patient> dataExisting = patientRepository.findById(idPatient);
		Patient dataPatient = new Patient();
		try {
			log.info("Begin process to Updating Patient Data");
			if(dataExisting.isPresent()) {
				dataPatient = dataExisting.get();
				dataPatient.setEmail(requestDataPatient.getEmail());
				dataPatient.setName(requestDataPatient.getName());
				patientRepository.save(dataPatient);
			} 
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error while updating patient data");
		}
		log.info("End process to Updating Patient Data");
		return dataPatient;
	}

	@Transactional
	@Override
	public Patient savePatient(Patient requestDataPatient) {
		// TODO Auto-generated method stub
		
		Optional<Patient> dataExisting = patientRepository.findByName(requestDataPatient.getName());
		Patient dataPatient = new Patient();
		try {
			log.info("Begin process to Saving new  Patient Data");
			if(dataExisting.isEmpty()) {
				 
				dataPatient.setEmail(requestDataPatient.getEmail());
				dataPatient.setName(requestDataPatient.getName());
				patientRepository.save(dataPatient);
			} 
		}catch (Exception e) {
			// TODO: handle exception
			log.error("Error while  Saving new  patient data");
		}
		log.info("End process to  Saving new  Patient Data");
		return dataPatient;
	}

	@Override
	public Patient findPatientByName(String requestData) {
		// TODO Auto-generated method stub
		return patientRepository.findByName(requestData).get();
	}

}
