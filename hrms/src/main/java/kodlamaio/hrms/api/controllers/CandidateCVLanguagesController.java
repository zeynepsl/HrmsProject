package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateLanguageCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLanguageCV;

@RestController
@RequestMapping("/api/languages")
public class CandidateCVLanguagesController {
	CandidateLanguageCVService languageCVService;

	@Autowired
	public CandidateCVLanguagesController(CandidateLanguageCVService languageCVService) {
		super();
		this.languageCVService = languageCVService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CandidateLanguageCV languageCV) {
		return languageCVService.add(languageCV);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CandidateLanguageCV>> getAll() {
		return languageCVService.getAll();
	} 
}
