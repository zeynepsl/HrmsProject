package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CVCoverLetter;

public interface CandidateCoverLetterCVService extends BaseService<CVCoverLetter>{
	DataResult<List<CVCoverLetter>> getAllByCandidateCV_Id(int candidateCVId);
	
	DataResult<List<CVCoverLetter>> getAllByCandidateCV_Candidate_Id(int candidateId);
}
