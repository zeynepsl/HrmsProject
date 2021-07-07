package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateExperienceCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateExperienceCVDao;
import kodlamaio.hrms.entities.concretes.CandidateExperienceCV;

@Service
public class CandidateExperienceCVManager implements CandidateExperienceCVService{

	CandidateExperienceCVDao candidateExperienceCVDao; 
	
	@Autowired
	public CandidateExperienceCVManager(CandidateExperienceCVDao candidateExperienceCVDao) {
		super();
		this.candidateExperienceCVDao = candidateExperienceCVDao;
	}

	@Override
	public Result add(CandidateExperienceCV entity) {
		candidateExperienceCVDao.save(entity);
		return new SuccessResult("deneyim eklendi");
	}

	@Override
	public Result delete(CandidateExperienceCV entity) {
		candidateExperienceCVDao.delete(entity);
		return new SuccessResult("deneyim silindi");
	}

	@Override
	public Result update(CandidateExperienceCV entity) {
		candidateExperienceCVDao.save(entity);
		return new SuccessResult("deneyim guncellendi");
	}

	@Override
	public DataResult<List<CandidateExperienceCV>> getAll() {
		return new SuccessDataResult<List<CandidateExperienceCV>>(candidateExperienceCVDao.findAll(), "deneyimler listelendi");
	}

	@Override
	public DataResult<List<CandidateExperienceCV>> getByEndDateSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
		return new SuccessDataResult<List<CandidateExperienceCV>>(candidateExperienceCVDao.findAll(sort), "data listelendi");
	}

	@Override
	public DataResult<List<CandidateExperienceCV>> getByCandidateCV_Id(int candidateCVId) {
		return new SuccessDataResult<List<CandidateExperienceCV>>(candidateExperienceCVDao.getByCandidateCV_Id(candidateCVId));
	}

	@Override
	public DataResult<List<CandidateExperienceCV>> getAllByCandidateCV_Candidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateExperienceCV>>(candidateExperienceCVDao.getAllByCandidateCV_Candidate_Id(candidateId), "data listelendi");
	}

}
