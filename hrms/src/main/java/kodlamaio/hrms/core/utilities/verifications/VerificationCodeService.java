package kodlamaio.hrms.core.utilities.verifications;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface VerificationCodeService {
	public DataResult<String> sendCode(String email);
	public Result sendLink(String email);
}
