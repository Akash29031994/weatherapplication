package com.concretio.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

/*
 * Create by Akash Chaturvedi   
 */

@Getter
@Setter
@Entity
@Table(name = "weather", uniqueConstraints =
@UniqueConstraint(columnNames={"time", "country_code", "location"}))
public class Weather {
	
	@Column(name="weather_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "temprature", nullable = true)
	private String temprature;
	@Column(name = "weather", nullable = true)
	private String weather;
	@Column(name = "min_temprature", nullable = true)
	private String minTemprature;
	@Column(name = "max_tempature", nullable = true)
	private String maxTempRature;
	@Column(name = "pressure", nullable = true)
	private String pressure;
	@Column(name = "air_speed", nullable = true)
	private String airSpeed;
	@Column(name = "humidity", nullable = true)
	private String humidity;
	@Column(name = "time", nullable = true)
	private Date time;
	@Column(name = "country_code", nullable = true)
	private String countryCode; 
	@Column(name = "location", nullable = true)
	private String location;
}
