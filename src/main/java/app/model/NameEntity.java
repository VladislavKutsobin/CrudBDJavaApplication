package app.model;

public class NameEntity extends BaseEntity {
    private String name;

    public NameEntity(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
