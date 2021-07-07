package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateSkillCV;

public interface CandidateSkillCVService extends BaseService<CandidateSkillCV>{
	DataResult<List<CandidateSkillCV>> getAllByCandidateCV_Candidate_Id(int candidateId);
}
