package ui;

import exception.ChoiceOutOfBoundException;

public class StudyGroupUI extends BaseUI {
	
	private String menu() {
		System.out.println("-----------------------------------");
		System.out.println("\t<< 스터디 그룹 모집 프로그램 >>");
		System.out.println("-----------------------------------");
		System.out.println("\t1. 게시글 작성");
		System.out.println("\t2. 게시글 수정");
		System.out.println("\t3. 게시글 삭제");
		System.out.println("\t4. 게시글 보기");
		System.out.println("\t5. 게시글 상세 보기");
		System.out.println("\t0. 종료");
		System.out.println("-----------------------------------");
		String type = scanStr("\t항목을 선택하세요 : ");
		
		return type;
	}
	
	@Override
	public void execute() throws Exception {
		
		while (true) {
			try {
				String choice = menu();
				IStudyGroupUI ui = null;
				switch (choice) {
				case "1":
					ui = new AddUI();
					break;
				case "2":
					ui = new UpdateUI();
					break;
				case "3":
					ui = new DeleteUI();
					break;
				case "4":
					ui = new SearchAllUI();
					break;
				case "5":
					ui = new SearchOneUI();
					break;
				case "0":
					ui = new ExitUI();
					break;
				}
				if (ui != null)
					ui.execute();
				else {
					System.out.println("\n\t메뉴번호를 잘못 선택하셨습니다.");
				}
			} catch (ChoiceOutOfBoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
