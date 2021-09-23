/**
 * 
 */
package com.example.dewadatta.patientbe.service;

import java.awt.print.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.example.dewadatta.patientbe.model.Patient;
 

/**
 * @author gdrana
 *
 */
@Service
public interface PatientService {

	Patient findPatientById(String requestData);

	Page<Patient> findAll(Pageable pageable);

	Patient updatePatientById(String idPatient, Patient requestDataPatient);

	Patient savePatient(Patient requestDataPatient);

	Patient findPatientByName(String requestData);

}
