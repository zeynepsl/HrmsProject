package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "candidate_experience_cvs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "candidate_cvs"})
public class CandidateExperienceCV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "workplace_name")
	private String workplaceName;
	
	@Column(name = "position")
	private String position;
	
	@Column(name = "starting_date")
	private LocalDateTime startingDate;
	
	@Column(name = "end_date")
	private LocalDateTime endDate;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "candidate_cv_id")
	private CandidateCV candidateCV;
}
