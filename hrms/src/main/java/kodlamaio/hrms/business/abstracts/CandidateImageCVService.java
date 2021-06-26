package kodlamaio.hrms.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.business.BaseService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateImageCV;

public interface CandidateImageCVService extends BaseService<CandidateImageCV>{
	public Result upload(CandidateImageCV imageCV , MultipartFile imageFile);
}
