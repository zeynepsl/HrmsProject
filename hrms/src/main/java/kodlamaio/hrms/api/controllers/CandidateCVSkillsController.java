package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateSkillCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSkillCV;

@RestController
@RequestMapping("/api/skills")
public class CandidateCVSkillsController {
	CandidateSkillCVService skillCVService;
	
	@Autowired
	public CandidateCVSkillsController(CandidateSkillCVService skillCVService) {
		this.skillCVService = skillCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateSkillCV skillCV) {
		return skillCVService.add(skillCV);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateSkillCV>> getAll() {
		return skillCVService.getAll();
	} 
	
	@GetMapping("getAllByCandidateCV_Candidate_Id")
	public DataResult<List<CandidateSkillCV>> getAllByCandidateCV_Candidate_Id(int candidateId){
		return skillCVService.getAllByCandidateCV_Candidate_Id(candidateId);
	}
	
}
