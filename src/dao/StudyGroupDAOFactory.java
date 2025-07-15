package dao;

public class StudyGroupDAOFactory {
	
private static StudyGroupDAO instance = null;
	
	public StudyGroupDAO getInstance() {
		if(instance == null)
			instance = new StudyGroupDAO();
		return instance;
	}

}
