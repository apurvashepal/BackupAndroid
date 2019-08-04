package Com.nt.Employee;

public class SalesExecutive extends Employee implements IEmployee{
	/**
	 * overridden method to add Developer
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
        int salary =super.getBasicSalary()+super.getHRA()+super.getIncentives();
    	return salary;
    }
}
