package next.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import next.dao.AnswerDao;
import next.dao.QuestionDao;
import next.model.Answer;
import core.mvc.Controller;

public class AnswerController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		AnswerDao answerDao = new AnswerDao();
		QuestionDao questionDao = new QuestionDao();

		Answer answer = new Answer(request.getParameter("writer"),request.getParameter("contents"), Long.parseLong(request.getParameter("questionId")));
		answerDao.insert(answer);
		questionDao.updateCount(Long.parseLong(request.getParameter("questionId")));
		return "api/addanswer.next";
	}
}
