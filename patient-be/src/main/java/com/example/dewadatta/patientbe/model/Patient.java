/**
 * 
 */
package com.example.dewadatta.patientbe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author gdrana
 *
 */

@Data
@Entity
@Table(name = "tbl_patients")
public class Patient {
	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", columnDefinition = "VARCHAR(255)")
	private String id;

	@Column(name = "name")
	@NotEmpty(message = "Name can't be empty!")
	private String name;

	@Column(name = "email")
	@NotEmpty(message = "Email can't be empty!")
	private String email;
}
