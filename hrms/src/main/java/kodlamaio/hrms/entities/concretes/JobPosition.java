package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity //bu Class bir Entity nesnesidir
@Table(name = "job_positions") //veritabaninda bu Class ın karsiligi job_positions
@AllArgsConstructor
@NoArgsConstructor

public class JobPosition {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id") //bu ozellik, Veritabaninda hangi kolona karsilik geliyor,
	private int id;
		
	@Column(name = "job_name")
	private String jobName;

	
}