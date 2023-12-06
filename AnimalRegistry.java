import java.util.HashMap;
import java.util.Map;

public class AnimalRegistry {
    private Map<String, Pet> pets;
    private Map<String, WorkingAnimal> workingAnimals;

    public AnimalRegistry() {
        this.pets = new HashMap<>();
        this.workingAnimals = new HashMap<>();
    }

    public void addPet(String type, String name) {
        pets.put(name, new Pet(type, name));
    }

    public void addWorkingAnimal(String type, String workType) {
        workingAnimals.put(type, new WorkingAnimal(type, workType));
    }

    public void findAnimal(String name) {
        if (pets.containsKey(name)) {
            Pet pet = pets.get(name);
            System.out.println("Найдено домашнее животное: " + pet.getType() + ", имя: " + pet.getName());
        } else if (workingAnimals.containsKey(name)) {
            WorkingAnimal workingAnimal = workingAnimals.get(name);
            System.out.println("Найдено вьючное животное: " + workingAnimal.getType() + ", тип работы: " + workingAnimal.getWorkType());
        } else {
            System.out.println("Животное не найдено");
        }
    }

    public void trainAnimal(String name) {
        // Логика обучения животного
    }

    public void addWorkingAnimal(String workType) {
    }
}