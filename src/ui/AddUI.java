package ui;

import dao.StudyGroupDAO;
import dao.StudyGroupDAOFactory;
import vo.StudyGroupVO;

public class AddUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		String title = scanStr("제목: ");
		String id = scanStr("작성자: ");
		String category = scanStr("카테고리: ");
		String region = scanStr("지역: ");
		String content = scanStr("내용: ");
		int max_Members = scanInt("모집인원: ");
		String endDate = scanStr("모집 마감일(yyyy-MM-dd): ");

	    StudyGroupVO studyGroup = new StudyGroupVO();
	    studyGroup.setId(id);
	    studyGroup.setTitle(title);
	    studyGroup.setCategory(category);
	    studyGroup.setRegion(region);
	    studyGroup.setContent(content);
	    studyGroup.setMaxMembers(max_Members);
	    studyGroup.setEndDate(endDate);
        
        studyGroupService.addStudyGroup(studyGroup);
        
        Thread.sleep(1000);
        
        System.out.println("\n게시글 등록이 완료되었습니다");

	}

}
