package app.model;

import java.util.Set;

public class Developer extends BaseEntity {
    private String firstName;
    private String lastName;
    private Set<Skill> skills;
    private Account account;

    public Developer(Integer id, String firstName, String lastName, Set<Skill> skills, Account account) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.skills = skills;
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
