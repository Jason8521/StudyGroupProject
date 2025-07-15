package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.ConnectionFactory;
import util.JDBCClose;
import vo.MemberVO;

public class MemberDAO {
    
    // 회원 가입
    public void insertMember(MemberVO member) {
    	
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = new ConnectionFactory().getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("INSERT INTO MEMBER (ID, PASSWORD, NAME, NICKNAME, EMAIL, REG_DATE) ");
            sql.append("VALUES (?, ?, ?, ?, ?, SYSDATE)");
            
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, member.getid());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getNickname());
            pstmt.setString(5, member.getEmail());
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCClose.close(conn, pstmt);
        }
    }

    // 아이디 중복 체크
    public boolean isIdExists(String id) {
    	
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean exists = false;
        try {
            conn = new ConnectionFactory().getConnection();
            
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT COUNT(*) ");
            sql.append("  FROM MEMBER ");		
            sql.append(" WHERE ID = ? ");
            
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCClose.close(conn, pstmt);
        }
        return exists;
    }
    
    // 닉네임 중복 체크
    public boolean isNicknameExists(String nickname) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean exists = false;

        try {
            conn = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT COUNT(*) ");
            sql.append("  FROM MEMBER ");
            sql.append(" WHERE NICKNAME = ?");
            
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, nickname);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                exists = rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCClose.close(conn, pstmt);
        }
        return exists;
    }
    
    // 로그인
    public MemberVO login(String id, String password) {
    	Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
        	conn = new ConnectionFactory().getConnection();
        	StringBuilder sql = new StringBuilder();
            sql.append("SELECT * ");
            sql.append("  FROM MEMBER ");
            sql.append(" WHERE ID = ? AND PASSWORD = ?");
        	 
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new MemberVO(
                    rs.getString("ID"),
                    rs.getString("PASSWORD"),
                    rs.getString("NAME"),
                    rs.getString("NICKNAME"),
                    rs.getString("EMAIL")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	JDBCClose.close(conn, pstmt);
        }
        return null;
    }
}
