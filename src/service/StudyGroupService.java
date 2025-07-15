package service;

import java.util.List;
import dao.StudyGroupDAO;
import vo.StudyGroupVO;

public class StudyGroupService {
	
	private StudyGroupDAO studyGroupDao;
	
	public StudyGroupService() {
		studyGroupDao = new StudyGroupDAO();
	}
	
	public void addStudyGroup(StudyGroupVO studyGroup) {
		studyGroupDao.insertStudyGroup(studyGroup);
	}
	
	public List<StudyGroupVO> searchStudyGroupAll() {
		return studyGroupDao.selectAllStudyGroup();
	}

	public StudyGroupVO searchStudyGroupByNo(int studyGroupNo) {
		StudyGroupVO studyGroup = studyGroupDao.selectByNo(studyGroupNo);
		return studyGroup;
	}
	
	public boolean removeStudyGroupByNo(int studyGroupNo) {
		boolean result = studyGroupDao.deleteByNo(studyGroupNo);
		return result;
	}
	
	public boolean updateStudyGroup(StudyGroupVO studyGroup) {
        return studyGroupDao.updateStudyGroup(studyGroup);
    }

}
