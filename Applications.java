package manytomany_bi.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int application_id;
	private String name;
	private String Company;
	@ManyToMany(mappedBy = "applications")
	private List<User>users;
	
	public int getApplication_id() {
		return application_id;
	}
	public void setApplication_id(int application_id) {
		this.application_id = application_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompany() {
		return Company;
	}
	public void setCompany(String company) {
		Company = company;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
//	@Override
//	public String toString() {
//		return "Application [application_id=" + application_id + ", name=" + name + ", Company=" + Company + "]";
//	}
	@Override
	public String toString() {
		return "Application [application_id=" + application_id + ", name=" + name + ", Company=" + Company + ", users="
				+ users + "]";
	}
	
	
	

}
