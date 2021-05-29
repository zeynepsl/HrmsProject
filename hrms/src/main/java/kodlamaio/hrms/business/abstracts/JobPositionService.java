package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	public void add(JobPosition position);
	public void delete(JobPosition position);
	public void update(JobPosition position);
	List<JobPosition> getAll();

}
