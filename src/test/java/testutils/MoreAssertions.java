package testutils;

import org.fest.assertions.Assertions;
import org.fest.assertions.Fail;
import org.fest.assertions.GenericAssert;

import java.util.function.Consumer;

public class MoreAssertions extends Assertions {
    public static class ConsumerAssertions extends GenericAssert<ConsumerAssertions, Consumer<Consumer<String>>> {
        protected ConsumerAssertions(Consumer<Consumer<String>> consumer) {
            super(ConsumerAssertions.class, consumer);
        }

        public ConsumerAssertions sends(String value) {
            actual.accept(valeur -> Assertions.assertThat(valeur).isEqualTo(value));

            return this;
        }

        public ConsumerAssertions sendsNothing() {
            actual.accept(valeur -> {throw Fail.fail("We should send nothing in "+actual.getClass().getCanonicalName());});

            return this;
        }
    }

    public static ConsumerAssertions assertThat(Consumer<Consumer<String>> source) {
        return new ConsumerAssertions(source);
    }
}
