package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Student")
public class Student {
	@Id
	@GeneratedValue
	private UUID id;
	
	@Column(name = "fullName")
	private String fullName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phoneNumber")
	private String phoneNumber;
	
	@Column(name = "status")
	private Integer status;
}
