package com.zeljko.instructors.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {

	// annotate the class as an entity and map to db table
	
	// define the fields
	
	// annotate the fields with db column names
	
	// ** set up mapping to InstructorDetail entity
	
	// create constructors
	
	// generate getter/setter methods
	
	// generate toString() method

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="instructor_ID")
	private int instructorID;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Column(name="first_name")
	private String firstName;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Column(name="last_name")
	private String lastName;

	@Column(name = "day_of_birth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dayOfBirth;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Column(name="address")
	private String address;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Column(name="phone")
	private String phone;

	@NotNull(message="is required")
	@Size(min=1, message="is required")
	@Column(name="email")
	private String email;

	@OneToMany(fetch=FetchType.LAZY,
			mappedBy="instructor",
			cascade= {CascadeType.REMOVE, CascadeType.MERGE,
					CascadeType.DETACH, CascadeType.REFRESH})
	private List<Course> courses;
	
	
	public Instructor() {
		
	}

	public Instructor(String firstName, String lastName, LocalDate dayOfBirth, String address, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dayOfBirth = dayOfBirth;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public int getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDayOfBirth() {
		return dayOfBirth;
	}

	public void setDayOfBirth(LocalDate dayOfBirth) {
		this.dayOfBirth = dayOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Instructor{" +
				"instructorID=" + instructorID +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", dayOfBirth=" + dayOfBirth +
				", adress='" + address + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}




