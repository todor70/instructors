package com.zeljko.instructors.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_ID")
	private int courseID;
	
	@Column(name="title")
	private String title;

	@Column(name = "start")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate start;

	@Column(name = "end")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate end;

	@ManyToOne()
	@JoinColumn(name = "instructor_ID")
	private Instructor instructor;

	public Course() {
		
	}

	public Course(String title, LocalDate start, LocalDate end) {
		this.title = title;
		this.start = start;
		this.end = end;
	}

	public int getCourseID() {
		return courseID;
	}

	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getStart() {
		return start;
	}

	public void setStart(LocalDate start) {
		this.start = start;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	@Override
	public String toString() {
		return "Course{" +
				"courseID=" + courseID +
				", title='" + title + '\'' +
				", start=" + start +
				", end=" + end +
				'}';
	}
}

