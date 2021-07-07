package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateImageCV;

public interface CandidateImageCVDao extends JpaRepository<CandidateImageCV, Integer>{
	List<CandidateImageCV> getByCandidateCV_Id(int candidateCVId);
	
	List<CandidateImageCV> getAllByCandidateCV_Candidate_Id(int candidateId);
}
