package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	JobPositionDao jobPositionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		super();
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public Result add(JobPosition entity) {
		if(jobPositionDao.findByJobName(entity.getJobName()) == null) {
			jobPositionDao.save(entity);
			return new SuccessResult("is pozisyonu kaydedildi");
		}	
		return new ErrorResult("bu is pozisyonu zaten mevcut");
		
	}

	@Override
	public Result delete(JobPosition entity) {
		jobPositionDao.delete(entity);
		return new SuccessResult("is pozisyonu silindi");
	}

	@Override
	public Result update(JobPosition entity) {
		jobPositionDao.save(entity);
		return new SuccessResult("is pozisyonu guncellendi");
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		 return new SuccessDataResult<List<JobPosition>>(jobPositionDao.findAll(), "is pozisyonlari listelendi");
	}
	
}