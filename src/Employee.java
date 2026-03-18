public class Employee {
    // статическая переменная-счетчик
    private static int counter = 1;

    // поля класса
    private final int id; // ID номер сотрудника
    private final String fullName; // Ф.И.О.
    private int department; // отделы от 1 до 5
    private int salary; // зарплата в интервале 50–450

    // конструктор для создания обьекта
    public Employee(String fullName, int department, int salary) {
        this.id = counter++;
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
    }

    // геттеры для получения
    public int getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public int getDepartment() {
        if (department >= 1 && department <= 5) {
            return department;
        } else {
            return 0;
        }
    }
    public int getSalary() {
        if (salary >= 50 && salary <= 450) {
            return salary;
        } else {
            return 0;
        }
    }

    // сеттеры для изменения отдела и зарплаты
    public void setDepartment(int department) {
        this.department = department;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        // проверка на идентичность ссылок
        if (this == o) return true;
        // проверка на null (отсутствие обьекта) и соответствие типов
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        // приведение типа к нужному классу Employee
        Employee employee = (Employee) o;
        // сравниваем зарплату
        return salary == employee.salary;
    }

    // метод для вывода информации о сотруднике
    @Override
    public String toString() {
        return "ID:" + id + " Сотрудник: " + fullName + ", Отдел: " + department + ", Зарплата: " + salary;
    }

    // метод вывода краткой информации
    public void printShortInfo() {
        System.out.println("Сотрудник: " + fullName + ", Зарплата: " + salary);
    }
}
