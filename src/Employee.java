public class Employee {
    // статическая переменная-счетчик
    private static int counter = 0;

    // поля класса
    private final int id; // ID номер сотрудника, final - не меняется
    private String fullName; // Ф.И.О.
    private int department; // отделы от 1 до 5
    private int salary; // зарплата в интервале 50–450

    // конструктор для создания обьекта
    public Employee(String fullName, int department, int salary) {
        this.id = counter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    // метод для вывода информации о сотруднике
    @Override
    public String toString() {
        return "ID: " + id + "Сотрудник: " + fullName + ", Отдел: " + department + ", Зарплата: " + salary;
    }

}
