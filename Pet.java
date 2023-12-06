// Дочерний класс для домашних животных
public class Pet extends Animal {
    private String name;

    public Pet(String type, String name) {
        super(type);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

