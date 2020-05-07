package fr.epita.quiz.tests.intrigration;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import fr.epita.quiz.datamodel.Answer;
import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.datamodel.User;
import fr.epita.quiz.services.business.ExamDataService;
import fr.epita.quiz.services.dao.AnswerDAO;
import fr.epita.quiz.services.dao.QuestionDAO;
import fr.epita.quiz.tests.unit.TestQuestionDAO;


public class TestExamDataService {
	private static final Logger LOGGER = LogManager.getLogger(TestQuestionDAO.class);

	

	@Inject
	ExamDataService dao;
	
	@Inject
	AnswerDAO adao;
	
	@Inject
	QuestionDAO questiondao;
	
	@Inject
	DataSource ds;
	public void testExamData() {
		Question question =new Question();
		question.setTitle("test");
	
		Answer answer =new Answer();
		answer.setContent("test content");
		questiondao.create(question);
		
		try {
			//dao.answerToQuestion(user, question, answer);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    Answer fetchAnswer= adao.getById(answer.getId());
	}
}
