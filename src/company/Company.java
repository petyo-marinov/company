package company;

import java.util.*;

public class Company {

    static final String DEP_IT = "IT";
    static final String DEP_CLEANING = "Cleaning";
    static final String DEP_ACCOUNTING = "Accounting";
    static final String SORT_BY_SALARY = "By salary";
    static final String SORT_BY_NAME = "By name";
    static final String SORT_BY_AGE = "By age";

    private String name;
    private HashMap<String, HashSet<Employee>> employees;

    public Company(String name) {
        this.name = name;
        this.employees = new HashMap<>();
    }

    public void hire(Employee employee, String department) {
        if(!this.employees.containsKey(department)){
            employees.put(department, new HashSet<>());
        }
        this.employees.get(department).add(employee);
    }

    public void printEmployees(){
        for (String dep : employees.keySet()){
            System.out.println("==========" + dep + "==========");
            HashSet<Employee> emps = employees.get(dep);
            for (Employee e : emps){
                System.out.println(e);
            }
        }
        /*като обходим по ентрита - по-малка сложност:
        (тук спестяваме HashSet<Employee> emps = employees.get(dep); get по ключ което е с логаритмична сложност)
        for (Map.Entry<String, HashSet<Employee>> e : employees.entrySet()){
            System.out.println("==========" + e.getKey() + "==========");
            for (Employee emp : e.getValue()){
                System.out.println(emp);
            }
        }
         */
    }

    public void printSorted(String sortBy) {
        Comparator<Employee> comparator;
        switch (sortBy){
            case SORT_BY_AGE -> comparator = Comparator.comparingInt(Employee::getAge);
            case SORT_BY_NAME -> comparator = Comparator.comparing(Employee::getName);
            default -> comparator = Comparator.comparingDouble(Employee::getSalary);
        }

        ArrayList<Employee> sorted = new ArrayList<>();
        for (HashSet<Employee> emps : employees.values()) {
            sorted.addAll(emps);
        }

        sorted.sort(comparator);

        System.out.println(sortBy);
        for (Employee e : sorted) {
            System.out.println(e);
        }
    }

    public ArrayList<Employee> convertAll(HashMap<String, HashSet<Employee>> all) {
        ArrayList<Employee> list = new ArrayList<>();
        Comparator<Employee> comparator = Comparator.comparing(Employee::getName);

        for (Map.Entry<String, HashSet<Employee>> e : all.entrySet()){
            list.addAll(e.getValue());
        }

        list.sort(comparator);

        return list;
    }
}
