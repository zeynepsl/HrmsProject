package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity //bu Class bir Entity nesnesidir
@Table(name = "job_positions") //veritabaninda bu Class ın karsiligi job_positions
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts"})
public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") //bu ozellik, Veritabaninda hangi kolona karsilik geliyor,
	private int id;
		
	@Column(name = "job_name")
	private String jobName;

	@JsonIgnore
	@OneToMany(mappedBy = "jobPosition")
	private List<JobAdvert> jobAdverts;
	
	public JobPosition(String jobName, List<JobAdvert> jobAdverts) {
		super();
		this.jobName = jobName ;
		this.jobAdverts = jobAdverts;
	} 
}