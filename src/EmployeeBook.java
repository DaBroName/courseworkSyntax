public class EmployeeBook {
    // поле-массив
    private final Employee[] employees;

    public EmployeeBook() {
        this.employees = new Employee[10];
    }

    public void printAllEmployees() {
        System.out.println("Список всех сотрудников:");
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp.toString());
            }
        }
    }

    // ищем сумму всех зарплат, идущих в массиве до первого null. Далее делим ее на количество
    public int calculateAverageSalary() {
        int count = 0;
        int sum = 0;

        for (Employee emp : employees) {
            // при встрече null - подсчет прекращается
            if (emp == null) {
                break;
            }
            // Прибавляем зарплату каждого сотрудника к общей сумме
            sum += emp.getSalary();
            count++;
        }
        return (sum / count);
    }

}
