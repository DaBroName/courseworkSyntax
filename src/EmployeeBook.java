public class EmployeeBook {

    // поле-массив
    private final Employee[] employees = new Employee[10];
    private int size = 0;

    // список всех сотрудников со всеми данными о них
    public void printAllEmployees() {
        System.out.println("Список всех сотрудники: ");
        for (Employee emp : employees) {
            if (emp != null) {
                System.out.println(emp);
            }
        }
    }

    // Среднее значение всех зарплат
    public void calculateAverageSalary() {
        int count = 0;
        int totalSalary = 0;
        for (Employee emp : employees) {
            if (emp != null) {
                count++;
                totalSalary += emp.getSalary();
            }
        }
        if (count > 0) {
            System.out.println("\nСредняя зарплата: " + (int) totalSalary / count);
        } else {
            System.out.println("\nСотрудников нет.");
        }
    }

    // Тип налогообложения
    public void printTax(String taxScheme) {
        System.out.println("Расчет налогов по схеме - " + taxScheme);
        for (Employee emp : employees) {
            if (emp == null) continue;
            double taxAmount;
            if ("1".equals(taxScheme)) {
                taxAmount = emp.getSalary() * 0.13;
            } else if ("2".equals(taxScheme)) {
                int s = emp.getSalary();
                taxAmount = s <= 150 ? s * 0.13 : (s <= 350 ? s * 0.17 : s * 0.21);
            } else {
                System.out.println("Неизвестная схема для: " + emp.getFullName());
                continue;
            }
            System.out.printf("Сотрудник: " + emp.getFullName() + " Налог = " + taxAmount + "\n");
        }
    }

    public void indexSalary(int department, double percent) {
        // Не индексируем если проц равен 0
        if (percent == 0) return;

        for (Employee emp : employees) {
            // Пропускаем, если объект пустой или отдел не совпадает
            if (emp == null || emp.getDepartment() != department) {
                continue;
            }
            // Расчет
            int newSalary = (int) (emp.getSalary() * (1 + percent / 100));
            emp.setSalary(newSalary);
        }
    }

    public void printFirstEmployeeWithSalaryAbove(int department, int minSalary) {
        for (int i = 0; i < employees.length && employees[i] != null; i++) {
            if (employees[i].getDepartment() == department && employees[i].getSalary() > minSalary) {
                System.out.println("Порядковый номер: " + (i + 1));
                employees[i].printShortInfo();
                break; // Останавливает цикл после нахождения первого совпадения
            }
        }
    }

    public void printFirstNEmpoyeesWithSalaryBelow(int wage, int employeeNumber) {
        int count = 0;
        int i = 0;

        while (i < employees.length) {
            if (employees[i] == null || count == employeeNumber) {
                break;
            }
            if (employees[i].getSalary() < wage) {
                employees[i].printShortInfo();
                count++;
            }
            i++;
        }
    }

    public boolean containsEmployee(int id) {
        boolean found = false;
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Сотрудник с ID " + id + " НАЙДЕН.");
        } else {
            System.out.println("Сотрудник с ID " + id + " ОТСУТСТВУЕТ.");
        }
        return found;
    }

    // Добавить сотрудника
    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                size++;
                return true;
            }
        }
        return false;
    }

    // Метод для получения сотрудника по id
    public Employee getEmployeeById(int id) {
        for (Employee emp : employees) {
            if (emp != null && emp.getId() == id) {
                return emp;

            }
        }
        return null;
    }
}