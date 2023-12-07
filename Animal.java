import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Animal {
    private String name;
    private List<String> commands = new ArrayList<>();

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void teachCommands() {
        System.out.println("Введите новую команду:");
        String command = new Scanner(System.in).nextLine();
        commands.add(command);
        System.out.println("Команда добавлена");
    }

    public void showAbilities() {
    }
}





