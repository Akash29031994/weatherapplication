package com.concretio.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherRequest {
	private String countryCode;
	private String city;
	private Date fromDate;
	private Date toDate;
}
