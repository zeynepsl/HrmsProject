package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	AuthService authService;
	
	@Autowired
	public AuthController(AuthService authService) {
		this.authService = authService;
	}
	
	@PostMapping("/registerforemployer")
	public Result registerForEmployer(@RequestBody Employer employer) {
		return this.authService.registerForEmployer(employer);
	}
	
	@PostMapping("/registerforcandidate")
	public Result registerForCandidate(@RequestBody Candidate candidate) {
		return this.authService.registerForCandidate(candidate);
	}
	
}
