package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateLanguageCV;

public interface CandidateLanguageCVService extends BaseService<CandidateLanguageCV>{
	DataResult<List<CandidateLanguageCV>> getAllByCandidateCV_Id(int candidateCVId);
	
	DataResult<List<CandidateLanguageCV>> getAllByCandidateCV_Candidate_Id(int candidateId);
}
