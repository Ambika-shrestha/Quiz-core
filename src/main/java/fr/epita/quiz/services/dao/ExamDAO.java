package fr.epita.quiz.services.dao;

import java.util.Map;

import fr.epita.quiz.datamodel.Exam;

public class ExamDAO extends GenericDAO<Exam, Long> {

	@Override
	public String getQuery() {
		// TODO Auto-generated method stub
		return "from Exam";
	}

	@Override
	public void setParameters(Map<String, Object> parameters, Exam criteria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<Exam> getEntityClass() {
		// TODO Auto-generated method stub
		return Exam.class;
	}


}
