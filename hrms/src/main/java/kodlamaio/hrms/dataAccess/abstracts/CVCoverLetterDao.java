package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CVCoverLetter;

public interface CVCoverLetterDao extends JpaRepository<CVCoverLetter, Integer>{

}
