package manytomany_bi.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String name;
	private long phone;
	private String address;
	@ManyToMany
	@JoinTable(joinColumns = @JoinColumn(name = "userid"),inverseJoinColumns = @JoinColumn(name = "application_id"))
	private List<Application>applications;
	
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Application> getApplications() {
		return applications;
	}
	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
//	@Override
//	public String toString() {
//		return "User [userid=" + userid + ", name=" + name + ", phone=" + phone + ", address=" + address
//				+ ", applications=" + applications + "]";
//	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	
	

	
	
}
