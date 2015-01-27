package source_domain;

public class DomainObject {
    private final Gender gender;

    public DomainObject(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return gender;
    }
}
