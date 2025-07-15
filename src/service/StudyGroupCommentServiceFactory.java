package service;

public class StudyGroupCommentServiceFactory {
	
	private static StudyGroupCommentService studyGroupCommentService;

	public StudyGroupCommentService getInstance() {
		if(studyGroupCommentService == null)
			studyGroupCommentService = new StudyGroupCommentService();
		return studyGroupCommentService;
	}

}
