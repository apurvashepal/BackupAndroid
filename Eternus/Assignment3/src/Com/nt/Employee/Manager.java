package Com.nt.Employee;

public class Manager extends Employee implements IEmployee {
	/**
	 * overridden method to add Manager
	 * return type Employee*/
	@Override
    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }
	/**
	    * Overriden method to delete Developer
	    * input Employee Object*/
    @Override
    public void deleteEmployee(Employee employee) {
    employeeList.remove(employee);
    }

    @Override
    public int calculateSalary() {
    	int salary=super.getBasicSalary()+super.getHRA();
        return salary;
    }
}
