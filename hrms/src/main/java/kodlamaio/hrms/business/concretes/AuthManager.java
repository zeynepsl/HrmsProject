package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.adapters.CheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.verifications.VerificationCodeService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class AuthManager implements AuthService{

	EmployerService employerService;
	CandidateService candidateService;
	UserService<User> userService;	
	VerificationService verificationService; //dogrulama kodunu kaydettigimiz sinif
	VerificationCodeService verificationCodeService;//code ve link gonderme islemlerini yaptigimiz sinif
	CheckService checkService; //mernis dogrulamasi yaptigimiz sinif
	
	@Autowired
	public AuthManager(EmployerService employerService, UserService<User> userService, 
			VerificationService verifiactionService, CandidateService candidateService, 
			VerificationCodeService verificationCodeService, CheckService checkService) {
		super();
		this.employerService = employerService;
		this.candidateService = candidateService;
		this.userService = userService;
		this.verificationService = verifiactionService;	
		this.verificationCodeService = verificationCodeService;
		this.checkService = checkService;
	}
	
	@Override
	public Result registerForEmployer(Employer employer) {
		
		if(!checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("bu is veren zaten mevcut");
		}
				
		if(!checkIfEmployerInformationIsFull(employer)) {
			return new ErrorResult("lutfen tum bilgilerinizi eksiksiz girin");
		}
			
		if(!checkIfEqualEmailAndDomain(employer.getEmail(), employer.getWebsiteAdress())) {
			return new ErrorResult("e-posta ile domain alani ayni degil");
		}
		
		employerService.add(employer);
		
		String code = verificationCodeService.sendCode(employer.getEmail()).getData();//aktivasyon kodunu donduruyor  
		verificationService.add(code, true, LocalDateTime.now());
			
		return new SuccessResult("basarili giris - isveren kaydedildi");
		
	}

	@Override
	public Result registerForCandidate(Candidate candidate) {
		if(!checkIfEmailExists(candidate.getEmail())) {
			return new ErrorResult("bu aday zaten mevcut");
		}
		
		if(!CheckIfCandidateInformationIsFull(candidate)) {
			return new ErrorResult("lutfen tum bilgilerinizi eksiksiz girin");
		}
		candidateService.add(candidate);
		String code = verificationCodeService.sendCode(candidate.getEmail()).getData();//aktivasyon kodunu donduruyor 
		verificationService.add(code, true, LocalDateTime.now());	
		return new SuccessResult("aday kaydedildi");
		
	}
	
	
	//Employer icin is kurallari - BASLANGIC
	
	private boolean checkIfEqualEmailAndDomain(String email, String website) {
		String[] emailToCheck = email.split("@"); //mail adresini @ ifadesine gore bolduk ve emailToCheck dizisine atadik
		                                          //ornek: zeynep@zeynep.com --> [ "zeynep", "zeynep.com"		
		if (website.contains(emailToCheck[1])) {
			return true;
		}
		return false;
	}
	
	
	
	private boolean checkIfEmployerInformationIsFull(Employer employer) {
		if(employer.getCompanyName() != null && employer.getPassword() != null && employer.getPhoneNumber() != null && 
				employer.getWebsiteAdress() != null && employer.getEmail() != null) {
			return true;
		}
		return false;
	}
	//Employer icin is kurallari - BİTİS
	
	
	//ortak is kurallari
	
	private boolean checkIfEmailExists(String email) {
		if(userService.getUserByEmail(email).isSuccess()) {
			return true;
		}
		return false;
	}
	
	
	//Candidate ici is kurallari - BASLANGIC
	
	private boolean CheckIfCandidateInformationIsFull(Candidate candidate) {
		if(candidate.getEmail() != null && candidate.getFirstName() != null && candidate.getLastName() != null
				&& candidate.getNationalityId() != null && candidate.getPassword() != null){
			return true;
		}
		return false;
	}
	
	//Candidate ici is kurallari - BİTİS
}
