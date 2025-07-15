package ui;

import vo.MemberVO;
import service.MemberService;
import service.MemberServiceFactory;
import dao.MemberDAO;
import dao.MemberDAOFactory;

public class SignUpUI extends BaseUI {
    private MemberService memberService = new MemberService();

    @Override
    public void execute() throws Exception {
        System.out.println("===== 회원가입 ====");
        
        String id = null;
        while(true) {
            id = scanStr("아이디: ");
            if(memberService.isIdDuplicate(id)) {
                System.out.println("이미 사용 중인 아이디입니다.");
            } else {
                break;
            }
        }
        
        String nickname = null;
        while(true) {
            nickname = scanStr("닉네임: ");
            if(memberService.isNicknameDuplicate(nickname)) {
                System.out.println("이미 사용 중인 닉네임입니다.");
            } else {
                break;
            }
        }
        
        String password = scanStr("비밀번호: ");
        String name     = scanStr("이름: ");
        String email    = scanStr("이메일: ");
        
        MemberVO member = new MemberVO(id, password, name, nickname, email);
        memberService.register(member);
        System.out.println("회원가입이 완료되었습니다!");
        Thread.sleep(1000);
        new AccountUI().execute();
    }
}
