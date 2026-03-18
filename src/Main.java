import java.util.Random;
import java.util.Scanner;


public class Main {

    // использовано с разбора курсовой
    private final static Random RANDOM = new Random();

    private final static String[] NAMES = {"Иван", "Петр", "Андрей", "Михаил", "Павел", "Олег"};
    private final static String[] SURNAMES = {"Иванов", "Петров", "Андреев", "Михаилов", "Павелов", "Олегов"};
    private final static String[] PATRONYMIC_NAMES = {"Иванович", "Петрович", "Андреевич", "Михаилович",
            "Павлович", "Олегович"};

    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            String fullName = SURNAMES[RANDOM.nextInt(SURNAMES.length)] + " " +
                    NAMES[RANDOM.nextInt(NAMES.length)] + " " +
                    PATRONYMIC_NAMES[RANDOM.nextInt(PATRONYMIC_NAMES.length)];
            book.addEmployee(new Employee(fullName, RANDOM.nextInt(1, 6), RANDOM.nextInt(50, 451)));
        }

        // Список всех сотрудники
        book.printAllEmployees();

        // Средняя зарплата
        book.calculateAverageSalary();

        System.out.print("\nВведите схему налога (1 - PROPORTIONAL или 2 - PROGRESSIVE): ");
        String scheme = scanner.nextLine();
        book.printTax(scheme);

        System.out.println("\nИндексация зарплаты в 1 отделе на 8%");
        book.indexSalary(1, 8);

        System.out.println("\nПервый в 1 отделе с ЗП > 150:");
        book.printFirstEmployeeWithSalaryAbove(1, 150);

        System.out.println("\nПервые сотрудники с ЗП < 170");
        book.printFirstNEmpoyeesWithSalaryBelow(170, 2);

        System.out.println("\nПервые сотрудники с ЗП < 170 из всего массива");
        book.printFirstNEmpoyeesWithSalaryBelow(170, 1);

        System.out.println("\nПолучение данных сотрудника оп ID");
        System.out.println(book.getEmployeeById(3));

        System.out.println("\nПроверка наличия сотрудника ID 3:");
        book.containsEmployee(3);
    }
}