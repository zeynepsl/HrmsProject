package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateLinkCVService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLinkCVDao;
import kodlamaio.hrms.entities.concretes.CandidateLinkCV;

@Service
public class CandidateLinkCVManager implements CandidateLinkCVService{

	CandidateLinkCVDao candidateLinkCVDao; 
	
	@Autowired
	public CandidateLinkCVManager(CandidateLinkCVDao candidateLinkCVDao) {
		super();
		this.candidateLinkCVDao = candidateLinkCVDao;
	}
	
	@Override
	public Result add(CandidateLinkCV entity) {
		candidateLinkCVDao.save(entity);
		return new SuccessResult("link eklendi");
	}

	@Override
	public Result delete(CandidateLinkCV entity) {
		candidateLinkCVDao.save(entity);
		return new SuccessResult("link silindi");
	}

	@Override
	public Result update(CandidateLinkCV entity) {
		//veriyi guncellemek istediğimizde aslında talodaki mecvut bir veriyi yeniden veritabanina eklemis oluyoruz--> save(entity);
		//veritabaninda bu verinin tekrar etmemesi icin once veritabaninda siliyoruz:
		delete(entity);
		//sonra guncellenmis veriyi ekliyoruz:
		candidateLinkCVDao.save(entity);
		return new SuccessResult("link guncellendi");
	}

	@Override
	public DataResult<List<CandidateLinkCV>> getAll() {
		return new SuccessDataResult<List<CandidateLinkCV>>(candidateLinkCVDao.findAll(), "linkler listelendi");
	}

	@Override
	public DataResult<List<CandidateLinkCV>> getAllByCandidateCV_Id(int candidateCVId) {
		return new SuccessDataResult<List<CandidateLinkCV>>(candidateLinkCVDao.getByCandidateCV_Id(candidateCVId));
	}

	@Override
	public DataResult<List<CandidateLinkCV>> getAllByCandidateCV_Candidate_Id(int candidateId) {
		return new SuccessDataResult<List<CandidateLinkCV>>(candidateLinkCVDao.getAllByCandidateCV_Candidate_Id(candidateId));
	}

}
