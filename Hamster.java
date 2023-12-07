public class Hamster extends Pet {
    public Hamster(String name) {
        super(name);
    }

    @Override
    public void teachCommands() {
        System.out.println("Хомяк не может выполнять команды");
    }
}
