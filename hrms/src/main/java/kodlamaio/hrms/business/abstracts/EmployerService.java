package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerService extends BaseService<Employer>{
	public DataResult<Employer> getUserByEmail(String email);
	
}
