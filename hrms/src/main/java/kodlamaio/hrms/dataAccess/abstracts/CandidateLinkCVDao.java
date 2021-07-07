package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateLinkCV;

public interface CandidateLinkCVDao extends JpaRepository<CandidateLinkCV, Integer>{
	List<CandidateLinkCV> getByCandidateCV_Id(int candidateCVId);
	
	List<CandidateLinkCV> getAllByCandidateCV_Candidate_Id(int candidateId);
}
