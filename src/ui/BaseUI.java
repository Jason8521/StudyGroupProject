package ui;

import java.util.Scanner;

import service.MemberService;
import service.MemberServiceFactory;
import service.StudyGroupService;
import service.StudyGroupServiceFactory;
import service.StudyGroupCommentService;
import service.StudyGroupCommentServiceFactory;

public abstract class BaseUI implements IStudyGroupUI {
	
	private Scanner sc;
	protected MemberService memberService;
	protected StudyGroupService studyGroupService;
	protected StudyGroupCommentService studyGroupCommentService;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		memberService = new MemberServiceFactory().getInstance();
		studyGroupService = new StudyGroupServiceFactory().getInstance();
		studyGroupCommentService = new StudyGroupCommentServiceFactory().getInstance();
	}
	
	protected String scanStr(String msg) {
		System.out.print(msg);
		return sc.nextLine();
	}
	
	protected int scanInt(String msg) {
		System.out.print(msg);
		int no = Integer.parseInt(sc.nextLine());
		return no;
	}
}
