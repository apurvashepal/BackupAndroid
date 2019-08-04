package Com.nt.Employee;




public class Developer extends Employee implements IEmployee{
	/**
	 * overridden method to add Developer
	 * return type Employee*/
    @Override
    public Employee addEmployee(Employee employee1) {
        employeeList.add(employee1);
        return employee1;
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
        return super.getBasicSalary();
    }
}
