package vo;

import java.io.Serializable;

public class StudyGroupVO implements Serializable {
	
	private int no;
	private String id;
	private String title;
	private String category;  // 어학/면접/자격증
	private String region;    // 서울/경기/...
	private String content;
	private int maxMembers;
	private String endDate;
	private String regDate;
	
	public StudyGroupVO() {
		super();
	}
	 
	 public StudyGroupVO(String id, String title, String category, String region, String content, int maxMembers, String endDate) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.region = region;
		this.content = content;
		this.maxMembers = maxMembers;
		this.endDate = endDate;
	}

	public StudyGroupVO(int no, String id, String title, String category, String region, String content, int maxMembers, String endDate, String regDate) {
		super();
		this.no = no;
		this.id = id;
		this.title = title;
		this.category = category;
		this.region = region;
		this.content = content;
		this.maxMembers = maxMembers;
		this.endDate = endDate;
		this.regDate = regDate;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	public int getMaxMembers() {
		return maxMembers;
	}

	public void setMaxMembers(int maxMembers) {
		this.maxMembers = maxMembers;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }
	
	@Override
	public String toString() {
		return "StudyGroupVO [no=" + no + ", id=" + id +", title=" + title + ", category=" + category + ", region=" + region + ", content=" + content + ", maxMebers="
				+ maxMembers + ", endDate=" + endDate + ", regDate=" + regDate +"]";
	}
		
}
