package model;

public class User {
	private String login;
	private String nom;
	private String password;

	/**
	 * @param login
	 * @param nom
	 * @param password
	 */
	public User(String login, String nom, String password) {
		this.login = login;
		this.nom = nom;
		this.password = password;
	}

	
	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
