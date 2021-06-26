package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities.concretes.City;

@Service
public class CityManager implements CityService{

	CityDao cityDao;
	
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}
	@Override
	public Result add(City city) {
		cityDao.save(city);
		return new SuccessResult("sehir eklendi");
	}

	@Override
	public Result delete(City city) {
		cityDao.delete(city);
		return new SuccessResult("sehir silindi");
	}

	@Override
	public Result update(City city) {
		cityDao.save(city);
		return new SuccessResult("sehir guncellendi");
	}
	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(cityDao.findAll(), "sehirler listelendi");
	}

}
