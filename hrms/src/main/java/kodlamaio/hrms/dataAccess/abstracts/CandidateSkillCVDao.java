package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateSkillCV;

public interface CandidateSkillCVDao extends JpaRepository<CandidateSkillCV, Integer>{
	List<CandidateSkillCV> getAllByCandidateCV_Candidate_Id(int candidateId);

}
