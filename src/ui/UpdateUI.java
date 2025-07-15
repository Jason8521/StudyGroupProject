package ui;

public class UpdateUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		
		int no = scanInt("수정할 글번호: ");
		
		String title = scanStr("수정할 제목: ");
		String id = scanStr("수정할 글쓴이: ");
		String category = scanStr("수정할 카테고리: ");
		String region = scanStr("수정할 지역: ");
		String content = scanStr("수정할 내용: ");
		int max_Members = scanInt("수정할 모집인원: ");
		String endDate = scanStr("수정할 모집 마감일: ");
		
		Thread.sleep(1000);
		
		System.out.printf("[%d]번 게시글을 수정하였습니다\n", no);

	}

}
