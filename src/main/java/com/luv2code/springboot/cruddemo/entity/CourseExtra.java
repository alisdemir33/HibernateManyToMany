package com.luv2code.springboot.cruddemo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class CourseExtra {
	//Extra demek join table da extra alanlar tutulan configürasyon ile çalışan 
	//ve join table için entity oluşturduğumuz yaklaşım demek. 
	//Extra kolon olmasa idi manytomany kullanırdık..student ve course buna göre farklı konfigüre edilirdi.

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
						 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="course_id")
	private List<Review> reviews;		

	@OneToMany(mappedBy="course", cascade=CascadeType.ALL)//Many olan tablonun entitisinde "one" olan entity yani bu entity yi refere eden property
	private List<CourseStudent> courseStudents;	
	
	public CourseExtra() {
		
	}

	public CourseExtra(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	// add a convenience method
	
	public void addReview(Review theReview) {
	
		if (reviews == null) {
			reviews = new ArrayList<Review>();
		}
		
		reviews.add(theReview);
	}
	
	public List<CourseStudent> getCourseStudents() {
		return courseStudents;
	}

	public void setStudents(ArrayList<CourseStudent> courseStudents) {
		this.courseStudents = courseStudents;
	}

	// add a convenience method
	
	public void addCourseStudent(CourseStudent courseStudent) {
		
		if (courseStudents == null) {
			courseStudents = new ArrayList<CourseStudent>();
		}
		
		courseStudents.add(courseStudent);
	}
	
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
	
	
}



