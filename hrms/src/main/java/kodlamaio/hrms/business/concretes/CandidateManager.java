package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;

@Service
public class CandidateManager implements CandidateService{

	CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		this.candidateDao = candidateDao;
	}
	
	@Override
	public Result add(Candidate entity) {
		candidateDao.save(entity);
		return new SuccessResult("aday kaydedildi");		
	}

	@Override
	public Result delete(Candidate entity) {
		candidateDao.deleteById(entity.getId());
		return new SuccessResult("aday silindi");
	}

	@Override
	public Result update(Candidate entity) {
		candidateDao.save(entity);
		return new SuccessResult("aday guncellendi");
	}

	@Override
	public DataResult<List<Candidate>>  getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll(), "adaylar listelendi");
	}

	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(candidateDao.getById(id));
	}
	
}
