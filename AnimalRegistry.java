import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalRegistry {

    private List<Animal> animals = new ArrayList<>();
    private Counter counter = new Counter();

    public void start() {
        Counter counter = new Counter();
        counter.start();
        try {
            Scanner scanner = new Scanner(System.in);
            boolean exit = false;
            while (!exit) {
                System.out.println("1. Завести новое животное");
                System.out.println("2. Показать список животных");
                System.out.println("3. Обучить животное новым командам");
                System.out.println("4. Выход");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Введите имя животного:");
                        String name = scanner.nextLine();
                        System.out.println("Введите тип животного (dog/cat/hamster/horse/camel/donkey):");
                        String type = scanner.nextLine();
                        addAnimal(name, type);
                        break;
                    case 2:
                        showAnimals();
                        break;
                    case 3:
                        System.out.println("Введите имя животного:");
                        name = scanner.nextLine();
                        teachAnimal(name);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("Некорректный выбор");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addAnimal(String name, String type) {
        switch (type) {
            case "dog":
                animals.add(new Dog(name));
                break;
            case "cat":
                animals.add(new Cat(name));
                break;
            case "hamster":
                animals.add(new Hamster(name));
                break;
            case "horse":
                animals.add(new Horse(name));
                break;
            case "camel":
                animals.add(new Camel(name));
                break;
            case "donkey":
                animals.add(new Donkey(name));
                break;
            default:

System.out.println("Некорректный тип животного");
        }
        counter.add();
    }

    private void showAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Животные не найдены");
        } else {
            for (Animal animal : animals) {
                System.out.println(animal.getName() + " - " + animal.getClass().getSimpleName());
            }
        }
    }

    private void teachAnimal(String name) {
        Animal animal = findAnimalByName(name);
        if (animal == null) {
            System.out.println("Животное не найдено");
        } else {
            animal.teachCommands();
        }
    }

    private Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        AnimalRegistry registry = new AnimalRegistry();
        registry.start();
    }
}

