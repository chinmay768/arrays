import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamAPI {

    class Employee {
        String name;
        String city;
        Integer age;
        Double salary;

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();


        list.stream().filter(emp -> emp.getAge() > 20).map(emp -> emp.getName()).toList();

        // Get Distict City
        list.stream().map(emp -> emp.getCity()).distinct().forEach(System.out::println);


        // Count employees whose salary is greater than 20K
        Long count = list.stream().filter(emp -> emp.getSalary() > 20000).count(); // Returns Long


        // Get first 3 entries
        List<Employee> empList = list.stream().limit(3).toList();


        // Skip First 3 Employees
        List<Employee> employeeList = list.stream().skip(3).toList();

        // Any one employee < 18 (atleast one match)
        Boolean isPresent = list.stream().anyMatch(emp -> emp.getAge() < 18);

        // Check if every employee > 18 or not
        Boolean isPresent2 = list.stream().allMatch(emp -> emp.getAge() > 18);

        // Check if every employee >=  18 // returns true if ever emp is false
        Boolean isPresent3 = list.stream().noneMatch(emp -> emp.getAge() < 18);

        // Get any one value from the stream
        Employee emp1 = list.stream().findAny().get(); // Return any random value

        // Get first elm
        Employee emp2 = list.stream().findFirst().get();

        // Sorted
        List<Integer> sortedEmpIds = list.stream().map(emp -> emp.getAge()).sorted().toList();

        // Sort based on Age
        List<Employee> sortedEmpList = list.stream().sorted((a, b) -> a.getAge() - b.getAge()).toList();

        // Sort Desc
        List<Employee> sortedEmpListdesc = list.stream().sorted((a, b) -> b.getAge() - a.getAge()).toList();

        // Sort Strings   "a".compareTo("b") = -1;     compareToIgnoreCase
        List<String> sortedStrings = list.stream().map(emp -> emp.getName()).sorted((n1, n2) -> n1.compareTo(n2)).toList();

        // Get the max age employee
        Employee maxSalaryEmp = list.stream().max(Comparator.comparingInt(emp -> emp.getAge())).get();

        // Get avg salary of employees
        Double avg = list.stream().mapToDouble(emp -> emp.getSalary()).average().getAsDouble(); // average returns OptionalDouble

        // Get avg age of employees
        Double avgAge = list.stream().mapToInt(emp -> emp.getAge()).average().getAsDouble(); // average returns OptionalDouble



    }
}
































