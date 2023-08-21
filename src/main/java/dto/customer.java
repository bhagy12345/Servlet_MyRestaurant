package dto;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Entity
@Data
public class customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullname;
	private String email;
	private long number;
	private String password;
	private String gender;
	private String country;
	@Lob
	private byte[] picture;
	private int age;
	private LocalDate dob;

}
