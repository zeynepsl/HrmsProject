package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateEducationCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateEducationCV;

@RestController
@RequestMapping("/api/educations")
public class CandidateCVEducationsController {
	
	CandidateEducationCVService educationCVService;
	
	@Autowired
	public CandidateCVEducationsController(CandidateEducationCVService educationCVService) {
		this.educationCVService = educationCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateEducationCV educationCV) {
		return educationCVService.add(educationCV);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateEducationCV>> getAll() {
		return educationCVService.getAll();
	}
	
	@GetMapping("getAllEndDateSorted")
	public DataResult<List<CandidateEducationCV>> getAllEndDateSorted(){
		return educationCVService.getAllEndDateSorted();
	}
	
	@GetMapping("getAllByCandidateCV_Candidate_Id")
	public DataResult<List<CandidateEducationCV>> getAllByCandidateCV_Candidate_Id(int candidateId){
		return educationCVService.getAllByCandidateCV_Candidate_Id(candidateId);
	}
}
