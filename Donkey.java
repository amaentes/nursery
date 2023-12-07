import java.util.Scanner;

public class Donkey extends WorkingAnimal {
    public Donkey(String name) {
        super(name);
    }

    @Override
    public void teachCommands() {
        System.out.println("Введите новую команду для осла:");
        String command = new Scanner(System.in).nextLine();
        if (command.equals("ездить") || command.equals("остановиться") || command.equals("нести груз")) {
            getCommands().add(command);
            System.out.println("Команда добавлена");
        } else {
            System.out.println("Осл не может выполнить эту команду");
        }
    }
}
