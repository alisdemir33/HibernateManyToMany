package com.luv2code.springboot.cruddemo.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "course_student_extra")
public class CourseStudent {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private long id;
	
	private StudentExtra student;
	private CourseExtra course;

	private boolean is_active;
	private Date enroll_date;

	 @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	 @JoinColumn(name = "student_id") 
	public StudentExtra getStudent() {
		return student;
	}

	public void setStudent(StudentExtra student) {
		this.student = student;
	}

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "course_id") 
	public CourseExtra getCourse() {
		return course;
	}

	public void setCourse(CourseExtra course) {
		this.course = course;
	}

	@Column(name="is_active")
	public boolean isIs_active() {
		return is_active;
	}

	public void setIs_active(boolean is_active) {
		this.is_active = is_active;
	}

	@Column(name = "enroll_date")
	@Temporal(TemporalType.DATE)
	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	@Override
	public String toString() {
		return "CourseStudent [id=" + id + ", student=" + student + ", course=" + course + ", is_active=" + is_active
				+ ", enroll_date=" + enroll_date + "]";
	}

}
