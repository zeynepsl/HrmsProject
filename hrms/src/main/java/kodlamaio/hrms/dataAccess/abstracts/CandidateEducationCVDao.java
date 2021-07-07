package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateEducationCV;

public interface CandidateEducationCVDao extends JpaRepository<CandidateEducationCV, Integer>{
	List<CandidateEducationCV> getByCandidateCV_Id(int candidateCVId);
	
	List<CandidateEducationCV> getAllByCandidateCV_Candidate_Id(int candidateId);
}
