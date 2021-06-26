package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateLanguageCV;

public interface CandidateLanguageCVDao extends JpaRepository<CandidateLanguageCV, Integer>{

}
