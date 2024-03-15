package com.klef.jfsd.springboot;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {
    @Autowired
    private WeatherService weatherService;
    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @GetMapping("/")
    public String index(Model model) {
        // Fetch and display weather data from the database
        List<WeatherData> weatherDataList = weatherDataRepository.findAll();
        model.addAttribute("weatherDataList", weatherDataList);
        return "index";
    }

    @PostMapping("/add")
    public String addWeatherData(WeatherData weatherData) {
        weatherService.saveWeatherData(weatherData);
        return "redirect:/";
    }
    @PostMapping("/search")
    public String searchWeather(@RequestParam("city") String city, Model model) {
        WeatherData weatherData = weatherService.fetchWeatherData(city);
        model.addAttribute("weatherData", weatherData);
        return "index";
    }
}

