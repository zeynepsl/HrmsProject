package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCoverLetterCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CVCoverLetterDao;
import kodlamaio.hrms.entities.concretes.CVCoverLetter;

@Service
public class CandidateCoverLetterCVManager implements CandidateCoverLetterCVService{

	CVCoverLetterDao coverLetterDao;
	
	@Autowired
	public CandidateCoverLetterCVManager(CVCoverLetterDao coverLetterDao) {
		super();
		this.coverLetterDao = coverLetterDao;
	}

	@Override
	public Result add(CVCoverLetter entity) {
		coverLetterDao.save(entity);
		return new SuccessResult("on yazi eklendi!");
	}

	@Override
	public Result delete(CVCoverLetter entity) {
		coverLetterDao.delete(entity);
		return new SuccessResult("on yazi eklendi!");
	}

	@Override
	public Result update(CVCoverLetter entity) {
		coverLetterDao.save(entity);
		return new SuccessResult("on yazi eklendi!");
	}

	@Override
	public DataResult<List<CVCoverLetter>> getAll() {
		return new SuccessDataResult<List<CVCoverLetter>>(coverLetterDao.findAll(), "on yazilar listelendi");
	}

	@Override
	public DataResult<List<CVCoverLetter>> getAllByCandidateCV_Id(int candidateId) {
		return new SuccessDataResult<List<CVCoverLetter>>(coverLetterDao.getByCandidateCV_Id(candidateId));
	}

	@Override
	public DataResult<List<CVCoverLetter>> getAllByCandidateCV_Candidate_Id(int candidateId) {
		return new SuccessDataResult<List<CVCoverLetter>>(coverLetterDao.getAllByCandidateCV_Candidate_Id(candidateId), "data listelendi");
	}


}
