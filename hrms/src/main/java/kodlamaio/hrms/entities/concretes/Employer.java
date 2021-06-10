package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employers")
@Data
@PrimaryKeyJoinColumn(name = "user_id")
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
	
}