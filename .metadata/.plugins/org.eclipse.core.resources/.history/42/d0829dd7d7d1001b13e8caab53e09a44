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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "job_adverts")
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvert {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "job_position_id")
	private JobPosition jobPosition;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "min_salary")
	private int minSalary;
	
	@Column(name = "max_salary")
	private int maxSalary;
	
	//2007-12-03	
	@Column(name = "creation_date", columnDefinition = "Date default CURRENT_TIMESTAMP")
	private LocalDateTime creationDate = LocalDateTime.now();
	
	@Column(name = "application_deadline")
	private LocalDateTime applicationDeadline;
	
	@Column(name= "is_active")
	private boolean isActive = true;
	
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@Column(name = "number_of_open_positions")
	private int numberOfOpenPositions;
}
