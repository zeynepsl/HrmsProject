package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCV;

public interface CandidateCVDao extends JpaRepository<CandidateCV, Integer>{
	
	CandidateCV getByCandidate_Id(int id);

}
