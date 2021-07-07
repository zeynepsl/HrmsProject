package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateLanguageCV;

public interface CandidateLanguageCVDao extends JpaRepository<CandidateLanguageCV, Integer>{
	List<CandidateLanguageCV> getByCandidateCV_Id(int candidateCVId);
	
	List<CandidateLanguageCV> getAllByCandidateCV_Candidate_Id(int candidateId);
}
