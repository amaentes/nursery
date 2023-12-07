import java.util.Scanner;

public class Cat extends Pet {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void teachCommands() {
        System.out.println("Введите новую команду для кошки:");
        String command = new Scanner(System.in).nextLine();
        if (command.equals("ловить мышей") || command.equals("лежать на солнышке")) {
            getCommands().add(command);
            System.out.println("Команда добавлена");
        } else {
            System.out.println("Кошка не может выполнить эту команду");
        }
    }
}
