package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateLanguageCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLanguageCVDao;
import kodlamaio.hrms.entities.concretes.CandidateLanguageCV;

@Service
public class CandidateLanguageCVManager implements CandidateLanguageCVService{

	CandidateLanguageCVDao candidateLanguageCVDao; 
	
	@Autowired
	public CandidateLanguageCVManager(CandidateLanguageCVDao candidateLanguageCVDao) {
		super();
		this.candidateLanguageCVDao = candidateLanguageCVDao;
	}
	
	@Override
	public Result add(CandidateLanguageCV entity) {
		candidateLanguageCVDao.save(entity);
		return new SuccessResult("dil eklendi!");
	}

	@Override
	public Result delete(CandidateLanguageCV entity) {
		candidateLanguageCVDao.delete(entity);
		return new SuccessResult("dil silindi!");
	}

	@Override
	public Result update(CandidateLanguageCV entity) {
		candidateLanguageCVDao.save(entity);
		return new SuccessResult("dil guncellendi!");
	}

	@Override
	public DataResult<List<CandidateLanguageCV>> getAll() {
		return new SuccessDataResult<List<CandidateLanguageCV>>(candidateLanguageCVDao.findAll(), "yabanci diller listelendi");
	}

	@Override
	public DataResult<List<CandidateLanguageCV>> getAllByCandidateCV_Id(int candidateCVId) {
		return new SuccessDataResult<List<CandidateLanguageCV>>(candidateLanguageCVDao.getByCandidateCV_Id(candidateCVId));
	}

	@Override
	public DataResult<List<CandidateLanguageCV>> getAllByCandidateCV_Candidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateLanguageCV>>(candidateLanguageCVDao.getAllByCandidateCV_Candidate_Id(candidateId));
	}

}
