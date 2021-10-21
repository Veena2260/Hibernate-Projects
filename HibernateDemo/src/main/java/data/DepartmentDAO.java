package data;

import java.util.List;

import model.Department;

public interface DepartmentDAO {
	
	public boolean save();
	
	public boolean delete();

	public int add(Department dept);
	
	public List<Department> getAllDepartments();

//	public void assignEmployeeProjects();
}
