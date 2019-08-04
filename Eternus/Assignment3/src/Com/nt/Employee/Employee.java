package Com.nt.Employee;
import java.util.ArrayList;
import java.util.List;

    public abstract class Employee implements  IEmployee{


        private int id;
        private String name;
        private int age;
        private String designation;
        private int basicSalary;
        private int HRA;
        private int incentives;
        protected List<Employee> employeeList = new ArrayList<Employee>();

/**
 * getter and setter methods for abstract class Employee
 */

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

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}

		public int getBasicSalary() {
			return basicSalary;
		}

		public void setBasicSalary(int basicSalary) {
			this.basicSalary = basicSalary;
		}

		public int getHRA() {
			return HRA;
		}

		public void setHRA(int hRA) {
			HRA = hRA;
		}

		public int getIncentives() {
			return incentives;
		}

		public void setIncentives(int incentives) {
			this.incentives = incentives;
		}

		public List<Employee> getEmployeeList() {
			return employeeList;
		}

		public void setEmployeeList(List<Employee> employeeList) {
			this.employeeList = employeeList;
		}
/**
 * get Employee Method to search for employee from list
 * return type : employee
 * argument int*/
	

    public int getId(Employee emp){
        return emp.id;
    }

   
    

}