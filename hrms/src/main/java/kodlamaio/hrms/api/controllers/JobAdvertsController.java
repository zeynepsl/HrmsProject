package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@RestController
@RequestMapping("/api/jobadverts")
public class JobAdvertsController {
	JobAdvertService jobAdvertService;
	
	@Autowired
	public JobAdvertsController(JobAdvertService jobAdvertService) {
		this.jobAdvertService = jobAdvertService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvert jobAdvert) {
		return jobAdvertService.add(jobAdvert);
	}
	
	/*
	 * @PostMapping("/delete") public Result delete(JobAdvert jobAdvert) { return
	 * jobAdvertService.delete(jobAdvert); }
	 */
	
	@PostMapping("/update")
	public Result update(@RequestBody JobAdvert jobAdvert) {
		return jobAdvertService.update(jobAdvert);
	}
	
	@GetMapping("/getAllActiveJobAdvert")
	public DataResult<List<JobAdvert>> getAllActiveJobAdvert(){
		return jobAdvertService.getAllActiveJobAdvert();
	}
	
	@GetMapping("/getAllByCreationDateAsc")
	public DataResult<List<JobAdvert>> getAllByCreationDateAsc(){
		return jobAdvertService.getAllByCreationDateAsc();
	}
	
	@PostMapping("/getAllActiveJobAdvertByCompanyName")
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertByCompanyName(@RequestParam("companyName") String companyName){
		return jobAdvertService.getAllActiveJobAdvertByCompanyName(companyName);
	}
	
	@PostMapping("/closeJobAdvert")
	public Result closeJobAdvert(@RequestParam("id") int id) {
		return jobAdvertService.closeJobAdvert(id);
	}
	
	@PostMapping("/openJobAdvert")
	public Result openJobAdvert(@RequestParam("id") int id) {
		return jobAdvertService.openJobAdvert(id);
	}
	
	
}
