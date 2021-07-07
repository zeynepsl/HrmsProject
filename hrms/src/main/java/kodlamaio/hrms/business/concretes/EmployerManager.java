package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;

@Service
public class EmployerManager implements EmployerService{

	EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		this.employerDao = employerDao;
	}
	
	@Override
	public Result add(Employer entity) {
		this.employerDao.save(entity);
		return new SuccessResult("is veren kaydedildi");
	}

	@Override
	public Result delete(Employer entity) {
		employerDao.delete(entity);
		return new SuccessResult("is veren silindi");
		
	}

	@Override
	public Result update(Employer entity) {
		employerDao.save(entity);
		return new SuccessResult("is veren guncellendi");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll(), "isverenler listelendi");
	}
	
	public DataResult<Employer> getUserByEmail(String email) {
		return new SuccessDataResult<Employer>(employerDao.findByEmail(email));
	}
	
}
