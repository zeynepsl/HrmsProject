package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService{

	JobAdvertDao jobAdvertDao;
	
	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		this.jobAdvertDao = jobAdvertDao;
	}
	
	@Override
	public Result add(JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);
		return new SuccessResult("is ilani eklendi!");
	}

	@Override
	public Result delete(JobAdvert jobAdvert) {
		jobAdvertDao.delete(jobAdvert);
		return new SuccessResult("is ilani silindi!");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		jobAdvertDao.save(jobAdvert);
		return new SuccessResult("is ilani guuncellendi!");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.findAll(), "is ilanlari listelendi");
	}
	
	@Override
	public DataResult<List<JobAdvert>> getAllActiveJobAdvert() {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.getAllActiveJobAdverts());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllByCreationDateAsc() {
		return new SuccessDataResult<List<JobAdvert>>(jobAdvertDao.getAllByCreationDateAsc());
	}

	@Override
	public DataResult<List<JobAdvert>> getAllActiveJobAdvertByCompanyName(String companyName) {
		return new SuccessDataResult<List<JobAdvert>>
		(jobAdvertDao.getAllActiveJobAdvertByEmployer_CompanyName(companyName));
	}

	@Override
	public Result closeJobAdvert(int id) {
		JobAdvert jobAdvert = jobAdvertDao.getById(id);
		
		if(jobAdvert == null) {
			return new ErrorResult("boyle bir is ilani yok");
		}
		
		if(jobAdvert.isActive() == false) {
			return new ErrorResult("bu is ilani zaten pasif");
		}
		
		jobAdvert.setActive(false);
		update(jobAdvert);
		return new SuccessResult("is ilani pasif duruma cekildi");
	}

	@Override
	public Result openJobAdvert(int id) {
		JobAdvert jobAdvert = jobAdvertDao.getById(id);
		
		if(jobAdvert == null) {
			return new ErrorResult("boyle bir is ilani yok");
		}
		
		if(jobAdvert.isActive() == true) {
			return new ErrorResult("bu is ilani zaten aktif");
		}
		
		jobAdvert.setActive(true);
		update(jobAdvert);
		return new SuccessResult("is ilani aktif duruma cekildi");
	}




}
