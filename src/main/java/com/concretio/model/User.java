package com.concretio.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "user_name", unique = true)
	private String username;
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "middle_name", nullable = true)
	private String middleName;
	@Column(name = "last_name", nullable = false)
	private String lastName;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "access_api_id", nullable = false)
	private String accessAPIId;
}
