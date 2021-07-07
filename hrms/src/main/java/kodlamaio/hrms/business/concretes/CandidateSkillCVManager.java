package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateSkillCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSkillCVDao;
import kodlamaio.hrms.entities.concretes.CandidateSkillCV;

@Service
public class CandidateSkillCVManager implements CandidateSkillCVService{

	CandidateSkillCVDao candidateSkillCVDao;
	
	@Autowired
	public CandidateSkillCVManager(CandidateSkillCVDao candidateSkillCVDao) {
		super();
		this.candidateSkillCVDao = candidateSkillCVDao;
	}

	@Override
	public Result add(CandidateSkillCV entity) {
		candidateSkillCVDao.save(entity);
		return new SuccessResult("yetenekler eklendi");
	}

	@Override
	public Result delete(CandidateSkillCV entity) {
		candidateSkillCVDao.delete(entity);
		return new SuccessResult("yetenekler silindi");
	}

	@Override
	public Result update(CandidateSkillCV entity) {
		candidateSkillCVDao.save(entity);
		return new SuccessResult("yetenekler guncellendi");
	}

	@Override
	public DataResult<List<CandidateSkillCV>> getAll() {
		return new SuccessDataResult<List<CandidateSkillCV>>(candidateSkillCVDao.findAll(), "data listelendi");
	}

	@Override
	public DataResult<List<CandidateSkillCV>> getAllByCandidateCV_Candidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateSkillCV>>(candidateSkillCVDao.getAllByCandidateCV_Candidate_Id(candidateId), "data listelendi");
	}

}
