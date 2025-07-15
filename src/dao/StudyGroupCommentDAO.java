package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
import util.JDBCClose;
import vo.StudyGroupCommentVO;

public class StudyGroupCommentDAO  {
	
	// 댓글 등록
    public void insertComment(StudyGroupCommentVO comment) {

        Connection conn = null;
    	PreparedStatement pstmt = null;
        try {
        	conn = new ConnectionFactory().getConnection();
        	
        	StringBuilder sql = new StringBuilder();
        	sql.append("INSERT INTO STUDY_GROUP_COMMENT(COMMENT_NO, STUDY_GROUP_NO, USER_ID, CONTENT) ");
        	sql.append("VALUES (SEQ_COMMENT_NO.NEXTVAL, ?, ?, ? ");
            pstmt.setInt(1, comment.getStudyGroupNo());
            pstmt.setString(2, comment.getUserId());
            pstmt.setString(3, comment.getContent());
            pstmt.executeUpdate();
            
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	JDBCClose.close(conn, pstmt);
        }
    }
    
    public boolean deleteComment(int commentNo) {
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	 
        try {
        	conn = new ConnectionFactory().getConnection();
        	
        	StringBuilder sql = new StringBuilder();
        	sql.append("DELETE FROM STUDY_GROUP_COMMENT WHERE COMMENT_NO = ? ");
            
        	pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, commentNo);
            pstmt.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JDBCClose.close(conn, pstmt);
        }
        return false;
    }
}