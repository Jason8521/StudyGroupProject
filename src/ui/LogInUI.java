package ui;

import vo.MemberVO;
import service.MemberService;
import service.MemberServiceFactory;
import dao.MemberDAO;
import dao.MemberDAOFactory;

public class LogInUI extends BaseUI {
    private MemberService memberService = new MemberService();

    @Override
    public void execute() throws Exception {
        System.out.println("==== 로그인 ====");

        String id = scanStr("아이디: ");
        String password = scanStr("비밀번호: ");

        MemberVO member = memberService.login(id, password);
        if (member != null) {
            System.out.println(member.getName() + "님, 로그인 성공!");
            Thread.sleep(1000);
            new StudyGroupUI().execute();
        } else {
            System.out.println("아이디 또는 비밀번호가 올바르지 않습니다.");
        }
    }
}
