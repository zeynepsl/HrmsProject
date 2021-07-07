package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateLinkCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLinkCV;

@RestController
@RequestMapping("/api/links")
public class CandidateCVLinksController {
	CandidateLinkCVService linkCVService;

	@Autowired
	public CandidateCVLinksController(CandidateLinkCVService linkCVService) {
		super();
		this.linkCVService = linkCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateLinkCV linkCV) {
		return linkCVService.add(linkCV);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateLinkCV>> getAll() {
		return linkCVService.getAll();
	} 
	
	@GetMapping("/getAllByCandidateCV_Candidate_Id")
	public DataResult<List<CandidateLinkCV>> getAllByCandidateCV_Candidate_Id(int candidateId){
		return linkCVService.getAllByCandidateCV_Candidate_Id(candidateId);
	}

}
