package b06704043;


public class Librarian {
	
	private String name;
	private String systemAccount;
	private String systemPassword;
	private boolean onLine;
	
	

	public Librarian(String name, String systemAccount, String systemPassword) {
		this.name = name;
		this.systemAccount = systemAccount;
		this.systemPassword = systemPassword;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSystemAccount() {
		return systemAccount;
	}
	public void setSystemAccount(String systemAccount) {
		this.systemAccount = systemAccount;
	}
	public String getSystemPassword() {
		return systemPassword;
	}
	public void setSystemPassword(String systemPassword) {
		this.systemPassword = systemPassword;
	}
	public boolean isOnLine() {
		return onLine;
	}
	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}
}
