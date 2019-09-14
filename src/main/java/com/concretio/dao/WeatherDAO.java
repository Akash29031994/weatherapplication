package com.concretio.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.concretio.model.Weather;

@Repository
public interface WeatherDAO extends CrudRepository<Weather, Integer>  {
	@Query("select w from Weather w where w.location = ?1 and w.time between ?2 and ?3 order by w.time desc")
	public List<Weather> getWeatherByFilter(String location, Date fromDate, Date toDate);
}
