package com.qst.bean;

public class Department {
    private Integer id;

    private String depName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

	@Override
	public String toString() {
		return "Department [id=" + id + ", depName=" + depName + "]";
	}
    
}