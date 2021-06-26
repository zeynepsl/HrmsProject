package kodlamaio.hrms.entities.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateCVDto {
	/*private int id;
	private Candidate candidate;
	private List<CandidateEducationCV> educationCVs;
	private List<CandidateExperienceCV> experienceCVs;
	private List<CandidateLanguageCV> languageCVs;
	private List<CandidateSkillCV> skillCVs;
	private List<CandidateLinkCV> linkCVs;
	private List<candidateImageCV> imageCVs;*/

	private String schoolName;
	private String department;
	private LocalDateTime schoolStartingDate;
	private LocalDateTime schoolEndDate;
	
	private String workplaceName;
	private String position;
	private LocalDateTime workStartingDate;
	private LocalDateTime workEndDate;

	private String languageName;
	private int languageLevel; 
	
	private String linkName;
	private String sıocialMediaUrl;
	
	private String imageUrl;
	
	private String skillName;
	
	private String coverLetter;
	
}
