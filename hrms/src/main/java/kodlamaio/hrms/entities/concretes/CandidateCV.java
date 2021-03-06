package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidate_cvs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "candidates"})
public class CandidateCV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "candidate_id")
	private Candidate candidate;

	@JsonIgnore
	@OneToMany(mappedBy = "candidateCV")
	private List<CandidateEducationCV> educationCVs;

	@JsonIgnore
	@OneToMany(mappedBy = "candidateCV")
	private List<CandidateExperienceCV> experienceCVs;

	@JsonIgnore
	@OneToMany(mappedBy = "candidateCV")
	private List<CandidateLanguageCV> languageCVs;

	@JsonIgnore
	@OneToMany(mappedBy = "candidateCV")
	private List<CandidateLinkCV> linkCVs;

	@JsonIgnore
	@OneToMany(mappedBy = "candidateCV")
	private List<CandidateImageCV> imageCVs;

	@JsonIgnore
	@OneToMany(mappedBy = "candidateCV")
	private List<CandidateSkillCV> skillCVs;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidateCV")
	private List<CVCoverLetter> coverLetters;
}
