package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	public Result add(JobPosition position);
	public Result delete(JobPosition position);
	public Result update(JobPosition position);
	public DataResult<List<JobPosition>> getAll();

}