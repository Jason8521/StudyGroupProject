package service;

public class StudyGroupServiceFactory {
	
	private static StudyGroupService studyGroupService;

	public StudyGroupService getInstance() {
		if(studyGroupService == null)
			studyGroupService = new StudyGroupService();
		return studyGroupService;
	}
	

}
