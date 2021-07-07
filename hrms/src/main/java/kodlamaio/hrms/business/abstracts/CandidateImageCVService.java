package kodlamaio.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateImageCV;

public interface CandidateImageCVService extends BaseService<CandidateImageCV>{
	public Result upload(CandidateImageCV imageCV , MultipartFile imageFile);
	public DataResult<List<CandidateImageCV>> getAllByCandidateCV_Id(int candidateCVId);
	public DataResult<List<CandidateImageCV>> getAllByCandidateCV_Candidate_Id(int candidateId);
}
