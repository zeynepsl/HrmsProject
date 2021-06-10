package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.VerificationDao;
import kodlamaio.hrms.entities.concretes.Verification;

@Service
public class VerificationManager implements VerificationService{

	VerificationDao verificationDao;
	
	@Autowired
	public VerificationManager(VerificationDao verificationDao) {
		this.verificationDao = verificationDao;
	}
	
	@Override
	public Result add(String code, boolean isConfirmed, LocalDateTime creationDate) {
		
		Verification verification = new Verification();
		verification.setVerificationName("dogrulama");
		verification.setActivationCode(code);
		verification.setConfirmed(true);
		verification.setCreationDate(creationDate);
		
		verificationDao.save(verification);
		return new SuccessResult();
	}

}
