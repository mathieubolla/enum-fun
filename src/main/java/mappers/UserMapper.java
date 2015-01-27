package mappers;

import source_domain.CallbackEnumWithFactory;
import source_domain.DomainObjectGraph;
import source_domain.Gender;
import org.fest.util.VisibleForTesting;
import target_domain.FlatTarget;

import java.util.function.Function;

public class UserMapper {
    private final Function<Gender, CallbackEnumWithFactory> genderFactory;

    public UserMapper() {
        this(CallbackEnumWithFactory.FACTORY);
    }

    @VisibleForTesting
    protected UserMapper(Function<Gender, CallbackEnumWithFactory> factory) {
        genderFactory = factory;
    }

    public void map(DomainObjectGraph graph, FlatTarget target) {
        genderFactory.apply(graph.getMain().getGender()).accept(target::setMain);
        genderFactory.apply(graph.getSecondary().getGender()).accept(target::setSecondary);
    }
}
