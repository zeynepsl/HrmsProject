package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {
	CityService cityService;
	
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		return cityService.add(city);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody City city) {
		return cityService.delete(city);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody City city) {
		return cityService.update(city);
	}
}
