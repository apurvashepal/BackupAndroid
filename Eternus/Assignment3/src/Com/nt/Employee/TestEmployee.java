package Com.nt.Employee;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestEmployee {
 public static void main(String Args[]) {
     Employee employee = null;
     Map<Employee,Integer> map= new HashMap<>();
     System.out.println("Enter choice 1.Add 2.Remove 3.Calculate Salary 4.Show Details");
     Scanner sc = new Scanner(System.in);
        /**
        * Basic operations On ArrayList
        * input :choice (int)
         */
     char ch = 'n';
     do {
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter employee designmation num 1:Dev 2:Manager 3:SalseExoecutive");
                int desi = sc.nextInt();
                switch (desi) {
                    case 1:
                    	System.out.println("Enter Developer data");
                    	employee=new Developer();
                    	employee.setId(sc.nextInt());
                        employee.setName(sc.next());
                        employee.setAge(sc.nextInt());
                        employee.setDesignation(new Scanner(System.in).next());
                        employee.setBasicSalary(new Scanner(System.in).nextInt());
                        employee.setHRA(0);
                        employee.setIncentives(0);
                        employee.addEmployee(employee);
                        map.put(employee,1001);
                        break;
                    case 2:
                    	System.out.println("Enter Manager data");
                    	employee= new Manager();
                    	employee.setId(sc.nextInt());
                        employee.setName(sc.next());
                        employee.setAge(sc.nextInt());
                        employee.setDesignation(new Scanner(System.in).next());
                        employee.setBasicSalary(new Scanner(System.in).nextInt());
                        employee.setHRA(new Scanner(System.in).nextInt());
                        employee.addEmployee(employee);
                        map.put(employee,1002);
                        break;
                    case 3:
                    	System.out.println("Enter SalesExecutive data");
                    	employee= new SalesExecutive();
                    	employee.setId(sc.nextInt());
                        employee.setName(sc.next());
                        employee.setAge(sc.nextInt());
                        employee.setDesignation(new Scanner(System.in).next());
                        employee.setBasicSalary(new Scanner(System.in).nextInt());
                        employee.setHRA(new Scanner(System.in).nextInt());
                        employee.setIncentives(0);
                        employee.addEmployee(employee);
                        map.put(employee,1003);

                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + desi);
                }

                break;
            case 2:
                System.out.println("Enter employee id to delete Employee");
                int deleteid = sc.nextInt();
                System.out.println("Enter employee designation num 1:Dev 2:Manager 3:SalesExecutive");
                int desi1 = sc.nextInt();
                switch (desi1) {
                    case 1:
                            Employee found = null;
                            employee = new Developer();
                            for (Employee emp : employee.employeeList) {
                                if (emp.getId() == deleteid) {
                                    found = emp;
                                    break;
                                }
                                }
                            employee.deleteEmployee(found);
                            break;
                    case 2:
                    	 found=null;
                         employee = new Manager();
                         for (Employee emp : employee.employeeList) {
                             if (emp.getId() == deleteid) {
                                 found = emp;
                                 break;
                             }
                             }
                         employee.deleteEmployee(found);
                         break;
                    case 3:
                    	 found=null;
                         employee = new SalesExecutive();
                         for (Employee emp : employee.employeeList) {
                             if (emp.getId() == deleteid) {
                                 found = emp;
                                 break;
                             }
                             }
                         employee.deleteEmployee(found);
                     }
                     break;
            case 3:
            	/**
            	 * Function to calculate Total salary of employees*/
                System.out.println("Calculate Salary");
                int salary=0,sal=0;
                for (Employee emp : employee.employeeList){
                	sal=emp.calculateSalary();
                	salary=salary+sal;
                }
                System.out.println(salary);
                break;
            case 4:
                /**
                 * HashMap to find value by key
                 * key: employee
                 * value: integer*/
               int mapval = sc.nextInt();
                for(Map.Entry<Employee,Integer> entry:map.entrySet()){
                    Employee key=entry.getKey();
                    int val=entry.getValue();
                    if(val==mapval)
                        System.out.println(val +" "+ key.getName() +" "+key.getDesignation());

                }
        }
        System.out.print("Do you want to continue? Y/N");
        ch = sc.next().charAt(0);
    } while (ch == 'y' || ch == 'Y');
}


}


