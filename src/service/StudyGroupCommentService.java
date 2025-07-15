package service;

import java.util.List;
import dao.StudyGroupCommentDAO;
import vo.StudyGroupCommentVO;

public class StudyGroupCommentService {
	
	private StudyGroupCommentDAO studyGroupCommentDao;
	
	public StudyGroupCommentService() {
		studyGroupCommentDao = new StudyGroupCommentDAO();
	}
	
	public void addComment(StudyGroupCommentVO comment) {
		studyGroupCommentDao.insertComment(comment);
	}
	
	public boolean removeStudyGroupCommetByNo(int studyGroupCommentNo) {
		boolean result = studyGroupCommentDao.deleteComment(studyGroupCommentNo);
		return result;
	}

}
