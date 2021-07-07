package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateCV;
import kodlamaio.hrms.entities.dtos.CandidateCVDto;

@RestController
@RequestMapping("/api/candidatecvs")
public class CandidateCVsController {
	CandidateCVService candidateCVService;

	@Autowired
	public CandidateCVsController(CandidateCVService candidateCVService) {
		super();
		this.candidateCVService = candidateCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateCV candidateCV) {
		return candidateCVService.add(candidateCV);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateCV>> getAll() {
		return candidateCVService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CandidateCV>> getAllByCandidateId(int candidateId){
		return candidateCVService.getAllByCandidateId(candidateId);
	}
	
	@GetMapping("getCandidateCVWithDetailsByCandidateId")
	public DataResult<CandidateCVDto> getCandidateCVWithDetailsByCandidateId(int candidateId){
		return candidateCVService.getCandidateCVWithDetailsByCandidateId(candidateId);
	}
	

}
