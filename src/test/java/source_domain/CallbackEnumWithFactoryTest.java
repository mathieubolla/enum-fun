package source_domain;

import org.junit.Test;

import java.util.function.Function;

import static testutils.MoreAssertions.assertThat;

public class CallbackEnumWithFactoryTest {

    public static final Function<Gender, CallbackEnumWithFactory> FACTORY = CallbackEnumWithFactory.FACTORY;

    @Test
    public void shouldProvideSaneFactory() {
        assertThat(FACTORY.apply(Gender.FEMALE)).isEqualTo(CallbackEnumWithFactory.FEMME);
        assertThat(FACTORY.apply(Gender.MALE)).isEqualTo(CallbackEnumWithFactory.HOMME);
        assertThat(FACTORY.apply(null)).isEqualTo(CallbackEnumWithFactory.DEFAULT);
    }

    @Test
    public void shouldMapAsSpecifiedCode() {
        assertThat(FACTORY.apply(Gender.MALE)).sends("h");
        assertThat(FACTORY.apply(Gender.FEMALE)).sends("f");
        assertThat(FACTORY.apply(null)).sendsNothing();
    }
}