package dto;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	private String email;
	private long mobile;
	private String password;
	private String gender;
	private LocalDate dob;
	@Lob
	private byte[] picture;
	private int age;
	private String country;

	@OneToOne(cascade = CascadeType.ALL)
	Cart cart;

}