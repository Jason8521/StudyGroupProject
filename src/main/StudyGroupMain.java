package main;

import ui.AccountUI;
import ui.StudyGroupUI;

public class StudyGroupMain {
	
	public static void main(String[] args) {
		
		AccountUI accountUI = new AccountUI();
		try {
			accountUI.execute();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		StudyGroupUI ui = new StudyGroupUI();
		try {
			ui.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
