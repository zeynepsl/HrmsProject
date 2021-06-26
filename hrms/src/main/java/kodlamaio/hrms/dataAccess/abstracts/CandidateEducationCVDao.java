package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateEducationCV;

public interface CandidateEducationCVDao extends JpaRepository<CandidateEducationCV, Integer >{

}
