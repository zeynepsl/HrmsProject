package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.CVCoverLetter;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateEducationCV;
import kodlamaio.hrms.entities.concretes.CandidateExperienceCV;
import kodlamaio.hrms.entities.concretes.CandidateImageCV;
import kodlamaio.hrms.entities.concretes.CandidateLanguageCV;
import kodlamaio.hrms.entities.concretes.CandidateLinkCV;
import kodlamaio.hrms.entities.concretes.CandidateSkillCV;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCVDto {
	//map islemi business katmaninda yapildi
	
	private Candidate candidate;
	private List<CandidateEducationCV> educationCVs;
	private List<CandidateExperienceCV> experienceCVs;
	private List<CandidateLanguageCV> languageCVs;
	private List<CandidateSkillCV> skillCVs;
	private List<CandidateLinkCV> linkCVs;
	private List<CandidateImageCV> imageCVs;
	private List<CVCoverLetter> coverLetterCVs;
}
