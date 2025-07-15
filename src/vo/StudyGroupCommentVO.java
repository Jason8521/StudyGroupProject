package vo;

public class StudyGroupCommentVO {
	
	private int studyGroupNo;
    private String userId;
    private String content;
    private String regDate;

    private int commentNo;
    public StudyGroupCommentVO(int commentNo, int studyGroupNo, String userId, String content, String regDate) {
    	super();
    	this.commentNo = commentNo;
    	this.studyGroupNo = studyGroupNo;
    	this.userId = userId;
    	this.content = content;
    	this.regDate = regDate;
    }
	public int getStudyGroupNo() {
		return studyGroupNo;
	}
	public void setStudyGroupNo(int studyGroupNo) {
		this.studyGroupNo = studyGroupNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	@Override
	public String toString() {
		return "StudyGroupCommentVO [studyGroupNo=" + studyGroupNo + ", userId=" + userId + ", content=" + content
				+ ", regDate=" + regDate + ", commentNo=" + commentNo + "]";
	}
    
}
