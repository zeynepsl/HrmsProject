package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
//primarykeyjoincolumn extend ettiğiniz user entity sindeki tablonun primarykey i ile employer in id sinin aynı olacağını 
//ve 2 sininde primary key olduğunu belirtiyor.
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)

public class Employer extends User{
	
	@Column(name = "company_name")
	private String companyName;
	
	@Column(name = "websiteAdress")
	private String websiteAdress;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
}
