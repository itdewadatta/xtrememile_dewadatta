/**
 * 
 */
package com.example.dewadatta.patientbe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.dewadatta.patientbe.model.Patient;
 

/**
 * @author gdrana
 *
 */
@Repository
public interface PatientRepository extends PagingAndSortingRepository<Patient, String> {

	Optional<Patient> findByName(String name);

}
