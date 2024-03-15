package com.klef.jfsd.springboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
}

