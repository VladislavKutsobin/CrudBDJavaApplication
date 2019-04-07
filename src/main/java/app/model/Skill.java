package app.model;

public class Skill extends NameEntity {
    public Skill(int id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "\n" + "id=" + getId()+ "---" + "Skill:" + getName();
    }
}
