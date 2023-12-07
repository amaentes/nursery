import java.util.Scanner;

public class Dog extends Pet {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void teachCommands() {
        System.out.println("Введите новую команду для собаки:");
        String command = new Scanner(System.in).nextLine();
        if (command.equals("сидеть") || command.equals("лежать") || command.equals("апорт")) {
            getCommands().add(command);
            System.out.println("Команда добавлена");
        } else {
            System.out.println("Собака не может выполнить эту команду");
        }
    }
}
