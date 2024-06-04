package jp.co.aforce.bean;

public class Information {
	private String userId;
	private String username;
	private String fm;
	private int y_birth;
	private int d_birth;
	private String mail;
	private String zipCode;
	private String address;
	private String pass;
	private String question;
	private String answer;

	public Information() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Information(String userId, String username, String fm, int y_birth, int d_birth, String mail, String zipCode,
			String address, String pass, String question, String answer) {
		super();
		this.userId = userId;
		this.username = username;
		this.fm = fm;
		this.y_birth = y_birth;
		this.d_birth = d_birth;
		this.mail = mail;
		this.zipCode = zipCode;
		this.address = address;
		this.pass = pass;
		this.question = question;
		this.answer = answer;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFm() {
		return fm;
	}

	public void setFm(String fm) {
		this.fm = fm;
	}

	public int getY_birth() {
		return y_birth;
	}

	public void setY_birth(int y_birth) {
		this.y_birth = y_birth;
	}

	public int getD_birth() {
		return d_birth;
	}

	public void setD_birth(int d_birth) {
		this.d_birth = d_birth;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
