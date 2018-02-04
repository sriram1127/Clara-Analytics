package com.hib.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "details")
public class Details implements Serializable {

	public Details() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Details(String firstName, String secondName, Integer countryId, Integer stateId,
			Timestamp time) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
		this.countryId = countryId;
		this.stateId = stateId;
		this.time = time;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1071417453977102104L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "secondname")
	private String secondName;

	@Column(name = "countryId")
	private Integer countryId;

	@Column(name = "stateId")
	private Integer stateId;

	@Column(name = "time")
	private Timestamp time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Integer getStateId() {
		return stateId;
	}

	public void setStateId(Integer stateId) {
		this.stateId = stateId;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
