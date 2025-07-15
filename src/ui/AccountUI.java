package ui;

import exception.ChoiceOutOfBoundException;

public class AccountUI extends BaseUI {
	
	private String menu() {
		System.out.println("-----------------------------------");
		System.out.println("\t<< 스터디 그룹 모집 프로그램 >>");
		System.out.println("-----------------------------------");
		System.out.println("\t1. 로그인");
		System.out.println("\t2. 회원가입");
		System.out.println("\t3. 종료");
		System.out.println("-----------------------------------");
		String type = scanStr("\t항목을 선택하세요 : ");
		
		return type;
	}
	
	@Override
	public void execute() throws Exception {
		
		while(true) {
			try {
				String choice = menu();
				IStudyGroupUI ui = null;
				switch (choice) {
				case "1":
					ui = new LogInUI();
					break;
				case "2":
					ui = new SignUpUI();
					break;
				case "3":
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