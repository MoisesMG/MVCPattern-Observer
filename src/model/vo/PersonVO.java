package model.vo;

public class PersonVO {
	/** artibitos **/
	private String name;
	private String lastname;
	private int age;
	private int gender;
	private String bornDate;
	private int bornDepartment;
	private int bornMunicipally;
	private String identification;
	/****************/
	
	/* getter and setter */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getBornDate() {
		return bornDate;
	}
	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
	}
	public int getBornDepartment() {
		return bornDepartment;
	}
	public void setBornDepartment(int bornDepartment) {
		this.bornDepartment = bornDepartment;
	}
	public int getBornMunicipally() {
		return bornMunicipally;
	}
	public void setBornMunicipally(int bornMunicipally) {
		this.bornMunicipally = bornMunicipally;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	/*********************/
}//fin de la clase
