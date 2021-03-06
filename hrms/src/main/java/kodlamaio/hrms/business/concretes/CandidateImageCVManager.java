package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateImageCVService;
import kodlamaio.hrms.core.utilities.imageUpload.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateImageCVDao;
import kodlamaio.hrms.entities.concretes.CandidateImageCV;

@Service
public class CandidateImageCVManager implements CandidateImageCVService{

	CandidateImageCVDao candidateImageCVDao; 
	ImageService imageService;
	
	@Autowired
	public CandidateImageCVManager(CandidateImageCVDao candidateImageCVDao, ImageService imageService) {
		super();
		this.candidateImageCVDao = candidateImageCVDao;
		this.imageService = imageService;
	}

	@Override
	public Result upload(CandidateImageCV imageCV , MultipartFile imageFile) {
		
		
		@SuppressWarnings("unchecked")
		Map<String,String> uploadImage = (Map<String, String>) this.imageService.upload(imageFile).getData();
		imageCV.setUrl(uploadImage.get("url"));
		//this.candidateImageCVDao.save(imageCV);
		//return new SuccessResult("resim eklendi");
		return add(imageCV);
	}
	
	@Override
	public Result add(CandidateImageCV entity) {
		candidateImageCVDao.save(entity);
		return new SuccessResult("resim eklendi");
	}

	@Override
	public Result delete(CandidateImageCV entity) {
		candidateImageCVDao.save(entity);
		return new SuccessResult("cv resmi silindi!");
	}

	@Override
	public Result update(CandidateImageCV entity) {
		candidateImageCVDao.save(entity);
		return new SuccessResult("cv resmi guncellendi!");
	}

	@Override
	public DataResult<List<CandidateImageCV>> getAll() {
		return new SuccessDataResult<List<CandidateImageCV>>(candidateImageCVDao.findAll(), "cv resimleri listelendi!");
	}

	@Override
	public DataResult<List<CandidateImageCV>> getAllByCandidateCV_Id(int candidateCVId) {
		return new SuccessDataResult<List<CandidateImageCV>>(candidateImageCVDao.getByCandidateCV_Id(candidateCVId));
	}

	@Override
	public DataResult<List<CandidateImageCV>> getAllByCandidateCV_Candidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateImageCV>>(candidateImageCVDao.getAllByCandidateCV_Candidate_Id(candidateId), "data listelendi");
	}



}
