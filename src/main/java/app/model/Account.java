package app.model;

import java.util.Set;

public class Account extends BaseEntity {
    private String login;
    private String developerData;
    private Developer developer;

    public Account() {}
    public Account(Integer id, String login, String developerData) {
        super(id);
        this.developerData = developerData;
        this.login = login;
    }

    public String getDeveloperData() {
        return developerData;
    }

    public void setDeveloperData(String developerData) {
        this.developerData = developerData;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }
}
