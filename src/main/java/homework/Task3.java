package homework;

import java.util.ArrayList;

/**
 * Необходимо обработать список с использованием Stream API.
 * <p>
 * Задание состоит из нескольких этапов. <p>
 * 1. Необходимо реализовать java-класс сотрудник (код “Employee”).
 * Приватные поля класса: ФИО (“fullName” тип “String”), Возраст (“age”
 * тип “Integer”), Отдел (“department” тип “String”), З/П (“salary” тип
 * “Double”). Класс должен содержать геттеры и сеттеры для доступа к
 * полям.
 * <p>
 * 2. Необходимо реализовать предзаполненный список (тип
 * “ArrayList<Employee>”) с объектами класса “Employee”, по которым будем
 * выполняться задание. Необходимо создать не менее 5 элементов списка.
 * <p>
 * 3. Выполнить задание в соответствии с вашим вариантом. При
 * выполнении задания необходимо использовать возможности Stream API!
 * <p>
 * Вариант 1: Отфильтровать сотрудников, оставив только тех, кто старше 30 лет.
 */
public class Task3 {
    /**
     * Класс сотрудника
     */
    private static class Employee {
        private String fullName;
        private Integer age;
        private String department;
        private Double salary;

        public Employee(String fullName, Integer age, String department, Double salary) {
            this.fullName = fullName;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "fullName='" + fullName + '\'' +
                    ", age=" + age +
                    ", department='" + department + '\'' +
                    ", salary=" + salary +
                    '}';
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }
    }

    private static ArrayList<Employee> getEmployees() {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Алёна Медведева",
                20,
                "Управление персоналом",
                10000.0));
        employees.add(new Employee("Вячеслав Пыжьянов",
                33,
                "Разработка",
                100000.0));
        employees.add(new Employee("Вячеслав Мавроди",
                62,
                "Финансы",
                100.0));
        employees.add(new Employee("Лёня Голубков",
                30,
                "Партнёр",
                1000000.0));
        employees.add(new Employee("Александр Пушкин",
                20,
                "Маркетинг",
                200000.0));
        return employees;
    }

    public static void main(String[] args) {
        ArrayList<Employee> employees = getEmployees();

        employees.stream()
                .filter(s -> s.getAge() > 30)
                .forEach(System.out::println);
    }
}
