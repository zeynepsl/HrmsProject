package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Candidate;

public interface CandidateService extends BaseService<Candidate>{
	public DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int id);
	
}
