package kodlamaio.hrms.business.abstracts;

import java.time.LocalDateTime;

import kodlamaio.hrms.core.utilities.results.Result;

public interface VerificationService {
	Result add(String code, boolean isConfirmed, LocalDateTime localDateTime);
	
}
