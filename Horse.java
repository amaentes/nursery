import java.util.Scanner;

public class Horse extends WorkingAnimal {
    public Horse(String name) {
        super(name);
    }

    @Override
    public void teachCommands() {
        System.out.println("Введите новую команду для лошади:");
        String command = new Scanner(System.in).nextLine();
        if (command.equals("бежать") || command.equals("остановиться") || command.equals("прыгать")) {
            getCommands().add(command);
            System.out.println("Команда добавлена");
        } else {
            System.out.println("Лошадь не может выполнить эту команду");
        }
    }
}
