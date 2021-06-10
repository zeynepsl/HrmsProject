package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	JobPositionService positionService;

	@Autowired
	public JobPositionsController(JobPositionService positionService) {
		super();
		this.positionService = positionService;
	}
	
	@PostMapping("/add")
	public Result RegisterForEmployer(@RequestBody JobPosition position) {
		return this.positionService.add(position);
	}
	
	@GetMapping("/getall")
	public List<JobPosition> getAll(){
		return positionService.getAll().getData();
	}
	
}