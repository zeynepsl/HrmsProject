package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvert;

public interface JobAdvertService {
	public Result add(JobAdvert jobAdvert);
	
	public Result delete(JobAdvert jobAdvert);
	
	public Result update(JobAdvert jobAdvert);
	
	public DataResult<List<JobAdvert>> getAllActiveJobAdvert();
	
	public DataResult<List<JobAdvert>> getAllByCreationDateAsc();
	
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertByCompanyName(String companyName);
	
	public Result closeJobAdvert(int id);
	
	public Result openJobAdvert(int id);
	
}
