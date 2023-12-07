import java.util.Scanner;

public class Camel extends WorkingAnimal {
    public Camel(String name) {
        super(name);
    }

    @Override
    public void teachCommands() {
        System.out.println("Введите новую команду для верблюда:");
        String command = new Scanner(System.in).nextLine();
        if (command.equals("идти") || command.equals("останавливаться") || command.equals("колоть воду")) {
            getCommands().add(command);
            System.out.println("Команда добавлена");
        } else {
            System.out.println("Верблюд не может выполнить эту команду");
        }
    }
}
