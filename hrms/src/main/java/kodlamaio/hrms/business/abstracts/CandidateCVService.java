package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.CandidateCV;
import kodlamaio.hrms.entities.dtos.CandidateCVDto;

public interface CandidateCVService extends BaseService<CandidateCV>{
	DataResult<CandidateCV> getById(int candidateCVId);
		
	DataResult<List<CandidateCV>> getAllByCandidateId(int candidateId);
	
	DataResult<CandidateCVDto> getCandidateCVWithDetailsByCandidateId(int candidateId);

}
