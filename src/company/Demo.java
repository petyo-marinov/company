package company;

public class Demo {

    public static void main(String[] args) {

        Company lidl = new Company("Lidl");

        Employee ivan = new Employee("Ivan", 27, 1750);
        Employee pesho = new Employee("Petar", 28, 1755);
        Employee mitko = new Employee("Dimitar", 28, 1700);
        Employee misho = new Employee("Miroslav", 27, 1755);

        lidl.hire(ivan, Company.DEP_CLEANING);
        lidl.hire(pesho, Company.DEP_ACCOUNTING);
        lidl.hire(mitko, Company.DEP_CLEANING);
        lidl.hire(misho, Company.DEP_IT);

        lidl.hire(new Employee("Asen", 26, 2100), Company.DEP_IT);
        lidl.hire(new Employee("Kalina", 31, 3000), Company.DEP_ACCOUNTING);
        lidl.hire(new Employee("Silvia", 24, 1850), Company.DEP_ACCOUNTING);
        lidl.hire(new Employee("Violeta", 49, 1800), Company.DEP_CLEANING);

        lidl.printEmployees();

        lidl.printSorted(Company.SORT_BY_NAME);
        lidl.printSorted(Company.SORT_BY_AGE);
        lidl.printSorted(Company.SORT_BY_SALARY);


    }
}
