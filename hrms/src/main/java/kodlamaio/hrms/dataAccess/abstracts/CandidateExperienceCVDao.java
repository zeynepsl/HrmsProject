package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateExperienceCV;

public interface CandidateExperienceCVDao extends JpaRepository<CandidateExperienceCV, Integer>{
	List<CandidateExperienceCV> getByCandidateCV_Id(int candidateCVId);
	
	List<CandidateExperienceCV> getAllByCandidateCV_Candidate_Id(int candidateId);
}
