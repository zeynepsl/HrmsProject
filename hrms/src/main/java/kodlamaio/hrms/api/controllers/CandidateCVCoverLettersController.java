package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateCoverLetterCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CVCoverLetter;

@RestController
@RequestMapping("/api/coverletters ")
public class CandidateCVCoverLettersController {
	CandidateCoverLetterCVService coverLetterCVService;

	@Autowired
	public CandidateCVCoverLettersController(CandidateCoverLetterCVService coverLetterCVService) {
		super();
		this.coverLetterCVService = coverLetterCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CVCoverLetter coverLetterCV) {
		return this.coverLetterCVService.add(coverLetterCV);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CVCoverLetter>> getAll(){
		return coverLetterCVService.getAll();
	}
	
	@GetMapping("/getAllByCandidateCV_Candidate_Id")
	public DataResult<List<CVCoverLetter>> getAllByCandidateCV_Candidate_Id(int candidateId){
		return coverLetterCVService.getAllByCandidateCV_Candidate_Id(candidateId);
	}
	
}
