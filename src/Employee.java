public class Employee {
    // поля класса
    private String fullName; // Ф.И.О.
    private int department; // отделы от 1 до 5
    private int salary; // зарплата в интервале 50–450

    // конструктор для создания обьекта
    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    // метод для вывода информации о сотруднике
    @Override
    public String toString() {
        return "Сотрудник: " + fullName + ", Отдел: " + department + ", Зарплата: " + salary;
    }

}
