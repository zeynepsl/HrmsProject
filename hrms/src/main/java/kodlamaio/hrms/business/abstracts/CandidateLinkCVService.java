package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateLinkCV;

public interface CandidateLinkCVService extends BaseService<CandidateLinkCV>{
	DataResult<List<CandidateLinkCV>> getAllByCandidateCV_Id(int candidateCVId);
	
	DataResult<List<CandidateLinkCV>> getAllByCandidateCV_Candidate_Id(int candidateId);
}
