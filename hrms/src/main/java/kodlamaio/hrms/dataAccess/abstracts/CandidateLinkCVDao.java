package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateLinkCV;

public interface CandidateLinkCVDao extends JpaRepository<CandidateLinkCV, Integer>{

}
