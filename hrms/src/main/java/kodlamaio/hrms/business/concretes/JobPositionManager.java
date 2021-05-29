package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionDao;
import kodlamaio.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService{

	JobPositionDao positionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public void add(JobPosition position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(JobPosition position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(JobPosition position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<JobPosition> getAll() {
		 return positionDao.findAll();
	}

}