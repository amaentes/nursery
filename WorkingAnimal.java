// Дочерний класс для вьючных животных
public class WorkingAnimal extends Animal {
    private String workType;

    public WorkingAnimal(String type, String workType) {
        super();
        this.workType = workType;
    }

    public String getWorkType() {
        return workType;
    }
}