package fr.epita.quiz.datamodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MCQ_ANSWER")
public class MCQAnswer{
	@Id
	@Column(name="ID")
	private Long id;
	@Column(name="STUDENT_ID")
	private Long student_id;
	@Column(name="EXAM_TITLE")
	private String exam_title;
	@Column(name="MCQ_QUESTION")
	private Long mcq_choice;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public String getExam_title() {
		return exam_title;
	}
	public void setExam_title(String exam_title) {
		this.exam_title = exam_title;
	}
	public Long getMcq_choice() {
		return mcq_choice;
	}
	public void setMcq_choice(Long mcq_choice) {
		this.mcq_choice = mcq_choice;
	}
}
