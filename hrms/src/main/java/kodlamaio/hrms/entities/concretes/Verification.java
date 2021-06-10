package kodlamaio.hrms.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "verifications")
@Data
@Inheritance(strategy = InheritanceType.JOINED)//extends ettigimiz sınıflar icin Verification'dan miras aldıgımızı belirtiyoruz
@AllArgsConstructor
@NoArgsConstructor

public class Verification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "verification_name")
	private String verificationName;
	
	@Column(name = "activation_code")
	private String activationCode;
	
	@Column(name = "is_confirmed")
	private boolean isConfirmed;
	
	@Column(name = "creation_date")
	private LocalDateTime creationDate;
}
