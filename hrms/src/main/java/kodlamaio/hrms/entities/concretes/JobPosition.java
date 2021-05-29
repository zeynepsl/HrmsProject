package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity //bu Class bir Entity nesnesidir
@Table(name = "job_positions") //veritabaninda bu Class ın karsiligi job_positions
public class JobPosition {
	
	@Id
	@GeneratedValue 
	@Column(name = "id") //bu ozellik, Veritabaninda hangi kolona karsilik geliyor
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "name")
	private String name;

	public JobPosition(int id, int userId, String name) {
		super();
		this.id = id;
		this.userId = userId;
		this.name = name;
	}
	
	
	
}