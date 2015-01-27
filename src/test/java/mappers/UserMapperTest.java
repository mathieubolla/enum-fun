package mappers;

import org.junit.Test;
import source_domain.DomainObject;
import source_domain.DomainObjectGraph;
import source_domain.Gender;
import target_domain.FlatTarget;

import static org.fest.assertions.Assertions.assertThat;

public class UserMapperTest {
    @Test
    public void shouldCopyAllValues() {
        DomainObjectGraph graph = new DomainObjectGraph(new DomainObject(Gender.MALE), new DomainObject(Gender.FEMALE));
        FlatTarget target = new FlatTarget();

        new UserMapper().map(graph, target);

        assertThat(target.getMain()).isEqualTo("h");
        assertThat(target.getSecondary()).isEqualTo("f");
    }

    @Test
    public void shouldAcceptNulls() {
        DomainObjectGraph graph = new DomainObjectGraph(new DomainObject(null), new DomainObject(null));
        FlatTarget target = new FlatTarget();

        new UserMapper().map(graph, target);

        assertThat(target.getMain()).isNull();
        assertThat(target.getSecondary()).isNull();
    }
}