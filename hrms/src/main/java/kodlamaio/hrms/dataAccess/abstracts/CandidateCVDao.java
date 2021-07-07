package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateCV;

public interface CandidateCVDao extends JpaRepository<CandidateCV, Integer>{
	 List<CandidateCV> getAllByCandidate_Id(int candidateId);

	 //Optional<CandidateCV> getByCandidate_Id(int candidateId);

}
