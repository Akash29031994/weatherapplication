package com.concretio.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.concretio.config.JwtTokenUtil;
import com.concretio.dto.APIResponse;
import com.concretio.dto.WeatherRequest;
import com.concretio.model.Weather;
import com.concretio.service.WeatherService;

@RestController
public class WeatherController {
	
	/*
	 * Create by Akash Chaturvedi
	 * Controller class to handle application related requests   
	 */

	@Autowired
	JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	WeatherService weatherService;
	
	@RequestMapping(value = "/getwheatherdetails", method = RequestMethod.POST)
	public ResponseEntity<APIResponse> showWheatherDetails(@RequestBody WeatherRequest weatherRequest, HttpServletRequest req) {
		APIResponse apiResponse = new APIResponse();
		try {
			String username = jwtTokenUtil.getUsernameFromToken(req.getHeader("Authorization").substring(7));
			apiResponse.setData(weatherService.getWeatherDetails(username, weatherRequest));
			apiResponse.setStatus("200");
			apiResponse.setMessage("Success");
		} catch(Exception e) {
			apiResponse.setStatus("500");
			apiResponse.setMessage(e.getMessage());
			return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/savewheatherdetails", method = RequestMethod.POST)
	public ResponseEntity<APIResponse> saveWheatherDetails(@RequestBody List<Weather> weathers) {
		APIResponse apiResponse = new APIResponse();
		try {
			weathers.forEach(weather -> {
				try {
					weatherService.saveWeather(weather);
				} catch (Exception e) {
					
				}
			});
			apiResponse.setStatus("200");
			apiResponse.setMessage("Success");
		} catch(Exception e) {
			apiResponse.setStatus("500");
			apiResponse.setMessage(e.getMessage());
			return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<APIResponse>(apiResponse, HttpStatus.OK);
	}
}
