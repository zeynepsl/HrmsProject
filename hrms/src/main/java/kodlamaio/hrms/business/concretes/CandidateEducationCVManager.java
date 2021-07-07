package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateEducationCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateEducationCVDao;
import kodlamaio.hrms.entities.concretes.CandidateEducationCV;

@Service
public class CandidateEducationCVManager implements CandidateEducationCVService{

	CandidateEducationCVDao candidateEducationCVDao; 
	
	@Autowired
	public CandidateEducationCVManager(CandidateEducationCVDao candidateEducationCVDao) {
		super();
		this.candidateEducationCVDao = candidateEducationCVDao;
	}

	@Override
	public Result add(CandidateEducationCV entity) {
		candidateEducationCVDao.save(entity);
		return new SuccessResult("egitim bilgileri eklendi");
	}

	@Override
	public Result delete(CandidateEducationCV entity) {
		candidateEducationCVDao.delete(entity);
		return new SuccessResult("egitim bilgileri eklendi");
	}

	@Override
	public Result update(CandidateEducationCV entity) {
		candidateEducationCVDao.save(entity);
		return new SuccessResult("egitim bilgileri eklendi");
	}

	@Override
	public DataResult<List<CandidateEducationCV>> getAll() {
		return new SuccessDataResult<List<CandidateEducationCV>>(candidateEducationCVDao.findAll(), "egitim bilgileri listelendi");
	}

	@Override
	public DataResult<List<CandidateEducationCV>> getAllEndDateSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC, "endDate");
		return new SuccessDataResult<List<CandidateEducationCV>>(candidateEducationCVDao.findAll(sort));
	}

	@Override
	public DataResult<List<CandidateEducationCV>> getByCandidateCV_Id(int candidateCVId) {
		return new SuccessDataResult<List<CandidateEducationCV>>(candidateEducationCVDao.getByCandidateCV_Id(candidateCVId), "data listelendi");
	}

	@Override
	public DataResult<List<CandidateEducationCV>> getAllByCandidateCV_Candidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateEducationCV>>(candidateEducationCVDao.getAllByCandidateCV_Candidate_Id(candidateId), "data litelendi");
	}



}
