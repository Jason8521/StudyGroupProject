package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
import util.JDBCClose;
import vo.StudyGroupVO;

public class StudyGroupDAO {
	
    // 스터디 그룹 등록
    public void insertStudyGroup(StudyGroupVO studyGroup) {
    	
    	Connection conn = null;
    	PreparedStatement pstmt = null;
        try {
        	conn = new ConnectionFactory().getConnection();
        	
        	StringBuilder sql = new StringBuilder();
        	sql.append("INSERT INTO STUDY_GROUP (NO, ID, TITLE, CATEGORY, REGION, CONTENT, MAX_MEMBERS, END_DATE) ");
        	sql.append(" VALUES(SEQ_STUDY_GROUP_NO.NEXTVAL, ?, ?, ?, ?, ?, ?, ?) ");
        	
        	pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, studyGroup.getId());
            pstmt.setString(2, studyGroup.getTitle());
            pstmt.setString(3, studyGroup.getCategory());
            pstmt.setString(4, studyGroup.getRegion());
            pstmt.setString(5, studyGroup.getContent());
            pstmt.setInt(6, studyGroup.getMaxMembers());
            pstmt.setString(7, studyGroup.getEndDate());

            pstmt.executeUpdate();

        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
        	JDBCClose.close(conn, pstmt);
        }
    }

    // 스터디 그룹 상세 조회 (no 기준)
    public StudyGroupVO selectByNo(int no) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StudyGroupVO studyGroup = null;

        try {
            conn = new ConnectionFactory().getConnection();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT * ");
            sql.append("  FROM STUDY_GROUP ");
            sql.append(" WHERE NO = ? ");
            
            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, no);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                studyGroup = new StudyGroupVO();
                studyGroup.setNo(rs.getInt("NO"));
                studyGroup.setTitle(rs.getString("TITLE"));
                studyGroup.setCategory(rs.getString("CATEGORY"));
                studyGroup.setRegion(rs.getString("REGION"));
                studyGroup.setContent(rs.getString("CONTENT"));
                studyGroup.setMaxMembers(rs.getInt("MAX_MEMBERS"));
                studyGroup.setEndDate(rs.getString("END_DATE"));
                studyGroup.setId(rs.getString("ID"));
                studyGroup.setRegDate(rs.getString("REG_DATE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCClose.close(conn, pstmt);
        }
        return studyGroup;
    }
            

    // 스터디 그룹 전체 목록 조회
    public List<StudyGroupVO> selectAllStudyGroup() {
    	
        List<StudyGroupVO> studyGroupList = new ArrayList<StudyGroupVO>();
        
        Connection conn = null;
		PreparedStatement pstmt = null;
		
        try {
        	conn = new ConnectionFactory().getConnection();
        	
        	StringBuilder sql = new StringBuilder();
			sql.append("SELECT NO, ID,  TITLE, CATEGORY, REGION");
			sql.append("       , TO_CHAR(REG_DATE, 'yyyy-mm-dd') as REG_DATE ");
			sql.append("  FROM STUDY_GROUP ");
			sql.append(" ORDER BY NO DESC ");
			
			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			
            while (rs.next()) {
                int    no          = rs.getInt("NO");
                String title       = rs.getString("TITLE");
                String category    = rs.getString("CATEGORY");
                String region      = rs.getString("REGION");
                String id          = rs.getString("ID");
                String regDate     = rs.getString("REG_DATE");
                
                StudyGroupVO studyGroup = new StudyGroupVO();
                studyGroup.setNo(no);
                studyGroup.setId(id);
                studyGroup.setTitle(title);
                studyGroup.setCategory(category);
                studyGroup.setRegion(region);
                studyGroup.setRegDate(regDate);
                
                studyGroupList.add(studyGroup);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JDBCClose.close(conn, pstmt);
        }
        
        return studyGroupList;
    }

    // 스터디 그룹 수정
    public boolean updateStudyGroup(StudyGroupVO studyGroup) {
    	
    	Connection conn = null;
 		PreparedStatement pstmt = null;
 		
        try {
        	conn = new ConnectionFactory().getConnection();
        	
        	StringBuilder sql = new StringBuilder();
        	sql.append("UPDATE STUDY_GROUP ");
        	sql.append("   SET TITLE = ?, ID = ?,  CATEGORY = ?, REGION = ?, CONTENT = ?, MAX_MEMBERS = ?, END_DATE = ? ");
        	sql.append(" WHERE NO = ? ");
        	
        	pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, studyGroup.getTitle());
            pstmt.setString(2, studyGroup.getId());
            pstmt.setString(3, studyGroup.getCategory());
            pstmt.setString(4, studyGroup.getRegion());
            pstmt.setString(5, studyGroup.getContent());
            pstmt.setInt(6, studyGroup.getMaxMembers());
            pstmt.setString(7, studyGroup.getEndDate());
            pstmt.setInt(8, studyGroup.getNo());

            int affectedRows = pstmt.executeUpdate();
            
            conn.commit();
            
            return affectedRows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JDBCClose.close(conn, pstmt);
        }
        return false;
    }

    // 스터디 그룹 삭제
    public boolean deleteByNo(int no) {
    	
    	Connection conn = null;
 		PreparedStatement pstmt = null;

        try {
        	conn = new ConnectionFactory().getConnection();
        	
        	StringBuilder sql = new StringBuilder();
        	sql.append("DELETE FROM STUDY_GROUP WHERE NO = ? ");

        	pstmt = conn.prepareStatement(sql.toString());
            pstmt.setInt(1, no);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        	JDBCClose.close(conn, pstmt);
        }
        return false;
    }

}
