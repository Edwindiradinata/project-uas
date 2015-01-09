package object;

public class User {
	private String username, pass;
	private boolean isAdmin;

	public User(String username, String password, boolean isAdmin) {
		this.username = username;
		this.pass = password;
		this.isAdmin = isAdmin;
	}

	public User(User usr) {
		this.username = usr.getUsername();
		this.pass = usr.getPassword();
		this.isAdmin = usr.isAdmin();
	}

	public String getUsername() {
		return username;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public String getPassword() {
		return pass;
	}
}
