package com.mosambee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty(message = "name should not be Empty...")
	@Size(min = 4, max = 30, message = "Clientname must be min of 4 Char or max 30 char")
	@Pattern(regexp = "^[A-Z a-z]{4,30}", message = "length must be min 4 or max 30")
	private String clientName;

	@NotEmpty(message = "Salary should not be Empty...")
	@Size(min = 4, max = 7, message = "only digits and space not allowed, Client Project Price can be max of 7 Digit or min 4")
	@Pattern(regexp = "^[0-9.]{4,7}", message = "length must be min 4 or max 7")
	private String clientProjectPrice;

	@NotEmpty(message = "Contact should not be Empty...")
	@Size(max = 10, message = "only digits and must be 10 Digit")
	@Pattern(regexp = "[0-9]{1,10}", message = "length must be max 10 Digit, only digits and no space allowed")
	private String clientContact;

	@Email(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
	private String clientEmail;
	
	private boolean enabled;
	
	private String role;

}
