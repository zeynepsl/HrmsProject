package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateExperienceCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateExperienceCV;

@RestController
@RequestMapping("/api/experiences")
public class CandidateCVExperiencesController {
	CandidateExperienceCVService experienceCVService;

	@Autowired
	public CandidateCVExperiencesController(CandidateExperienceCVService experienceCVService) {
		super();
		this.experienceCVService = experienceCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateExperienceCV experienceCV) {
		return experienceCVService.add(experienceCV);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateExperienceCV>> getAll() {
		return experienceCVService.getAll();
	}
	
	@GetMapping("/getByEndDateSorted")
	public DataResult<List<CandidateExperienceCV>> getByEndDateSorted(){
		return experienceCVService.getByEndDateSorted();
	}
}
