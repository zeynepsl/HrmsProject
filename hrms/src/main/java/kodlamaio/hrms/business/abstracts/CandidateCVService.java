package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCV;

public interface CandidateCVService extends BaseService<CandidateCV>{
	DataResult<CandidateCV> getByCandidateId(int candidateId);

}
