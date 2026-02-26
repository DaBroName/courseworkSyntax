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


}
