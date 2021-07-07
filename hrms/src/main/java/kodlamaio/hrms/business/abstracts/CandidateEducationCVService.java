package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateEducationCV;

public interface CandidateEducationCVService extends BaseService<CandidateEducationCV>{
	public DataResult<List<CandidateEducationCV>> getAllEndDateSorted();
	public DataResult<List<CandidateEducationCV>> getByCandidateCV_Id(int candidateCVId);
	
	public DataResult<List<CandidateEducationCV>> getAllByCandidateCV_Candidate_Id(int candidateId);
}
