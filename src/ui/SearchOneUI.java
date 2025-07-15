package ui;

import java.util.List;

import vo.StudyGroupCommentVO;
import vo.StudyGroupVO;

public class SearchOneUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		int no = scanInt("조회할 글번호를 입력하세요: ");
		
		StudyGroupVO studyGroup = studyGroupService.searchStudyGroupByNo(no);
		
		if(studyGroup == null) {
			System.out.println("글번호 [" + no + "]번에 게시글이 없습니다");
			return;
		}
		
		System.out.println("-------------------------------");
		System.out.println("\t글번호: " + studyGroup.getNo());
		System.out.println("\t글쓴이: " + studyGroup.getId());
		System.out.println("\t제목: " + studyGroup.getTitle());
		System.out.println("\t카테고리: " + studyGroup.getCategory());
		System.out.println("\t지역: " + studyGroup.getRegion());
		System.out.println("\t내용: " + studyGroup.getContent());
		System.out.println("\t모집인원: " + studyGroup.getMaxMembers());
		System.out.println("\t모집 마감일: " + studyGroup.getEndDate());
		System.out.println("\t등록일: " + studyGroup.getRegDate());
		System.out.println("-------------------------------");
		
	}

}
	
