package source_domain;

public class DomainObjectGraph {
    private final DomainObject main;
    private final DomainObject secondary;

    public DomainObjectGraph(DomainObject main, DomainObject secondary) {
        this.main = main;
        this.secondary = secondary;
    }

    public DomainObject getSecondary() {
        return secondary;
    }

    public DomainObject getMain() {
        return main;
    }
}
