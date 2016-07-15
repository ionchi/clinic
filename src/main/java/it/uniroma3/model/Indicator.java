package it.uniroma3.model;

import javax.persistence.*;

@Entity
public class Indicator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	private String name;

	@ManyToOne
	private ExamType examType;

	// ***** Getters and setters *****
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExamType getExamType() {
		return examType;
	}

	public void setExamType(ExamType examType) {
		this.examType = examType;
	}

	@Override
	public String toString() {
		return "Indicator [name=" + name + "]";
	}
}
