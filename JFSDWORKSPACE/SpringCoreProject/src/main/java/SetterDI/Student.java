package SetterDI;

import java.util.List;

public class Student 
{
	private int id; //preemitive datatype
	private String name; //non-preemitive datatype
	private String gender; //preemitive datatype
	private float age; //preemitive datatype
	private double cgpa; //preemitive datatype
	private String email; //non-preemitive datatype
	private boolean graduated; //preemitive datatype
	private List<String> skills; //collection non-npreemitive datatype
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public float getAge() {
		return age;
	}
	public void setAge(float age) {
		this.age = age;
	}
	public double getCgpa() {
		return cgpa;
	}
	public void setCgpa(double cgpa) {
		this.cgpa = cgpa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isGraduated() {
		return graduated;
	}
	public void setGraduated(boolean graduated) {
		this.graduated = graduated;
	}
	public List<String> getSkills() {
		return skills;
	}
	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", cgpa=" + cgpa
				+ ", email=" + email + ", graduated=" + graduated + ", skills=" + skills + "]";
	}
}
