import java.util.Scanner;

public class AnimalRegistryProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AnimalRegistry registry = new AnimalRegistry();

        boolean exit = false;
        while (!exit) {
            System.out.println("Меню:");
            System.out.println("1. Завести новое домашнее животное");
            System.out.println("2. Завести новое вьючное животное");
            System.out.println("3. Узнать о животном");
            System.out.println("4. Обучить животное");
            System.out.println("5. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Очистка ввода

            switch (choice) {
                case 1:
                    System.out.println("Введите тип домашнего животного (собака, кошка и т.д.): ");
                    String petType = scanner.nextLine();
                    System.out.println("Введите имя: ");
                    String petName = scanner.nextLine();
                    registry.addPet(petType, petName);
                    break;
                case 2:
                    System.out.println("Введите тип вьючного животного (лошадь, верблюд и т.д.): ");
                    String workType = scanner.nextLine();
                    registry.addWorkingAnimal(workType);
                    break;
                case 3:
                    System.out.println("Введите имя животного: ");
                    String name = scanner.nextLine();
                    registry.findAnimal(name);
                    break;
                case 4:
                    System.out.println("Введите имя животного: ");
                    String animalName = scanner.nextLine();
                    registry.trainAnimal(animalName);
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
        scanner.close();
    }
}