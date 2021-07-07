package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateCVDao;
import kodlamaio.hrms.entities.concretes.CandidateCV;

@Service
public class CandidateCVManager implements CandidateCVService{

	CandidateCVDao candidateCVDao;
	
	@Autowired
	public CandidateCVManager(CandidateCVDao candidateCVDao) {
		this.candidateCVDao = candidateCVDao;
	}
	
	@Override
	public Result add(CandidateCV entity) {
		candidateCVDao.save(entity);
		return new SuccessResult("cv eklendi");
	}

	@Override
	public Result delete(CandidateCV entity) {
		candidateCVDao.delete(entity);
		return new SuccessResult("cv silindi");
	}

	@Override
	public Result update(CandidateCV entity) {
		candidateCVDao.save(entity);
		return new SuccessResult("cv guncellendi");
	}

	@Override
	public DataResult<List<CandidateCV>> getAll() {
		return new SuccessDataResult<List<CandidateCV>>(candidateCVDao.findAll(), "cv'ler listelendi");
	}


	@Override
	public DataResult<CandidateCV> getByCandidateId(int candidateId) {
		return new SuccessDataResult<CandidateCV>(candidateCVDao.getByCandidate_Id(candidateId), "verilen -aday id- sine gore cv getirldi");
	}

}