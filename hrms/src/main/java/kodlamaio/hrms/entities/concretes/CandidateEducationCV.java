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
@Table(name = "candidate_education_cvs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "candidate_cvs"})
public class CandidateEducationCV {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "school_name")
	private String schoolName;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "starting_date")
	private LocalDateTime startingDate;
	
	@Column(name = "end_date")
	private LocalDateTime endDate;
	
	@JsonIgnore
	@ManyToOne()//tabloya gore dusun
	@JoinColumn(name = "candidate_cv_id")
	private CandidateCV candidateCV;//Tablodaki her bir satıra gore:
	//( CandidateEducationCV Class'ına gore - her bir CandidateEducationCV nesnesine gore) dusun
}
