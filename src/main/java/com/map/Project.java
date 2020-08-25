package com.map;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Project {
	
	@Id
	private int pid;
	
	@Column(name="project_name")
	private String ProjectName;
	
	@ManyToMany(mappedBy = "projects")
	private List<Emp> emps;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	public Project(int pid, String projectName, List<Emp> emps) {
		super();
		this.pid = pid;
		ProjectName = projectName;
		this.emps = emps;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
