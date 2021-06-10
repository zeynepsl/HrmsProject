package kodlamaio.hrms.core.utilities.verifications;

import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class VerificationCodeManager implements VerificationCodeService{

	public VerificationCodeManager() {
	}
	
	@Override
	public DataResult<String> sendCode(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationCode = uuid.toString();
		System.out.println("kod: " + verificationCode);
		return new SuccessDataResult<String>(verificationCode, "aktivasyon kodunuz: " + verificationCode);
	}

	@Override
	public Result sendLink(String email) {
		UUID uuid = UUID.randomUUID();
		String verificationLink = "https://hrmsverificationmail/" + uuid.toString();
		System.out.println("dogrulama linki gonderildi: " + email );
		System.out.println("lutfen hesabinizi dogrulamak icin tiklayin:  " + verificationLink );
		return new SuccessResult();
	}

}
