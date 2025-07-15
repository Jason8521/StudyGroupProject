package dao;

public class StudyGroupCommentDAOFactory {
	
	private static StudyGroupCommentDAO instance = null;
	
	public StudyGroupCommentDAO getInstance() {
		if(instance == null)
			instance = new StudyGroupCommentDAO();
		return instance;
	}

}
