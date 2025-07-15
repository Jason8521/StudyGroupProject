package ui;

public class DeleteUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		int no = scanInt("삭제할 글번호를 입력하세요: ");
		
		boolean result  = studyGroupService.removeStudyGroupByNo(no);
		if(result)
			System.out.println("[" + no + "]번 게시글을 삭제하였습니다.");
		else
			System.out.println("[" + no + "]번 해당 게시글이 존재하지 않습니다");
		Thread.sleep(1000);
	}

}
