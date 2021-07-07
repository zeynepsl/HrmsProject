package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateExperienceCV;

public interface CandidateExperienceCVService extends BaseService<CandidateExperienceCV>{
	DataResult<List<CandidateExperienceCV>> getByEndDateSorted();
	DataResult<List<CandidateExperienceCV>> getByCandidateCV_Id(int candidateCVId);
	
	DataResult<List<CandidateExperienceCV>> getAllByCandidateCV_Candidate_Id(int candidateId);
}
