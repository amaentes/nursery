public class Main {
    public static void main(String[] args) {
        try (Counter counter = new Counter()) {
            counter.add();
            System.out.println("Значение счетчика: " + counter.getCount());
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}