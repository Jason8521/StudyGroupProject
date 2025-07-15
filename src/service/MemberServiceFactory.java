package service;

public class MemberServiceFactory {
	
	private static MemberService memberService;

	public MemberService getInstance() {
		if(memberService == null)
			memberService = new MemberService();
		return memberService;
	}

}
