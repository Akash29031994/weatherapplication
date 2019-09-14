package com.concretio.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.concretio.dao.UserDao;
import com.concretio.dao.WeatherDAO;
import com.concretio.dto.WeatherRequest;
import com.concretio.dto.WeatherResponse;
import com.concretio.model.User;
import com.concretio.model.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {

	@Autowired
	UserDao userDao;

	@Autowired
	WeatherDAO weatherDAO;

	@Value("${application.constants.apiURL}")
	String apiURL;

	@Value("${application.constants.countriesURL}")
	String countriesURL;

	@SuppressWarnings("deprecation")
	public List<Weather> getWeatherDetails(String username, WeatherRequest weatherRequest) {
		User user = userDao.findByUsername(username);
		List<Weather> weatherAPIResponses = new ArrayList<Weather>();
		try {
			Date currentDate = new Date();
			if (currentDate.getYear() == weatherRequest.getToDate().getYear() && currentDate.getDay() == weatherRequest.getToDate().getDay()
					&& currentDate.getMonth() == weatherRequest.getToDate().getMonth()) {
				WeatherResponse weatherResponse = sendGet(weatherRequest.getCity() + "," + weatherRequest.getCountryCode(),
						user.getAccessAPIId());
				weatherAPIResponses.add(parseWeatherResponse(weatherResponse));
				weatherAPIResponses.addAll(weatherDAO.getWeatherByFilter(weatherRequest.getCity(),
						weatherRequest.getFromDate(), new Date(weatherRequest.getToDate().getTime() - 86400000)));
			} else {
				weatherAPIResponses.addAll(weatherDAO.getWeatherByFilter(weatherRequest.getCity(),
						weatherRequest.getFromDate(), weatherRequest.getToDate()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return weatherAPIResponses;
	}

	public Weather parseWeatherResponse(WeatherResponse weatherResponse) throws Exception {
		Weather weatherAPIResponse = new Weather();
		weatherAPIResponse.setMaxTempRature("" + (weatherResponse.getMain().getTempMax() - 273));
		weatherAPIResponse.setMinTemprature("" + (weatherResponse.getMain().getTempMin() - 273));
		weatherAPIResponse.setAirSpeed("" + weatherResponse.getWind().getSpeed());
		weatherAPIResponse.setPressure("" + weatherResponse.getMain().getPressure());
		weatherAPIResponse.setTemprature("" + (weatherResponse.getMain().getTemp() - 273));
		weatherAPIResponse.setHumidity("" + weatherResponse.getMain().getHumidity());
		weatherAPIResponse.setWeather("" + weatherResponse.getWeather().get(0).getMain());
		weatherAPIResponse.setTime(new Date(weatherResponse.getDt()));
		weatherAPIResponse.setCountryCode("" + weatherResponse.getSys().getCountry());
		weatherAPIResponse.setLocation("" + weatherResponse.getName());
		return weatherAPIResponse;
	}

	public Weather saveWeather(Weather weather) throws Exception {
		weather = weatherDAO.save(weather);
		return weather;
	}

	public WeatherResponse sendGet(String query, String apiId) throws Exception {
		String weatherApiURL = apiURL + "?q=" + query + "&appid=" + apiId;
		URL obj = new URL(weatherApiURL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		WeatherResponse weatherResponse = new ObjectMapper().readValue(response.toString(), WeatherResponse.class);
		return weatherResponse;
	}
}
