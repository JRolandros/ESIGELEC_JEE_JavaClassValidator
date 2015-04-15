package model;

public class Student extends User{
	private int note;
	public Student(String login, String nom, String password) {
		super(login,nom,password);
		this.note=0;
		
	}
	
	/**
	 * @return the note
	 */
	public int getNote() {
		return this.note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(int note) {
		this.note = note;
	}

}
