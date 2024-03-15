package com.klef.jfsd.springboot;

public interface WeatherService {
    WeatherData fetchWeatherData(String city);
    void saveWeatherData(WeatherData weatherData);

}
