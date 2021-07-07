package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVCoverLetter;

public interface CVCoverLetterDao extends JpaRepository<CVCoverLetter, Integer>{
	List<CVCoverLetter> getByCandidateCV_Id(int candidateCVId);
	
	List<CVCoverLetter> getAllByCandidateCV_Candidate_Id(int candidateId);
}
