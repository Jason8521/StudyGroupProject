package service;

import dao.MemberDAO;
import vo.MemberVO;

public class MemberService {
	
    private MemberDAO memberDAO;

    public MemberService() {
        this.memberDAO = new MemberDAO();
    }

    // 아이디 중복 체크
    public boolean isIdDuplicate(String id) {
        return memberDAO.isIdExists(id);
    }

    // 닉네임 중복 체크
    public boolean isNicknameDuplicate(String nickname) {
        return memberDAO.isNicknameExists(nickname);
    }
    
    // 회원가입
    public void register(MemberVO member) {
        memberDAO.insertMember(member);
    }
    
    // 로그인
    public MemberVO login(String id, String password) {
        return memberDAO.login(id, password);
    }
}
