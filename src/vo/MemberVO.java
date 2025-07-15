package vo;

public class MemberVO {
    private String id;
    private String password;
    private String name;
    private String nickname;
    private String email;
    
    public MemberVO() {}
    
    public MemberVO(String id, String password, String name, String nickname, String email) {
    	super();
    	this.id = id;
		this.password = password;
		this.name = name;
		this.nickname = nickname;
		this.email = email;
    }

	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
        
}