package source_domain;

import utils.EnumUtils;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public enum CallbackEnumWithFactory implements Supplier<Gender[]>, Consumer<Consumer<String>> {
    HOMME("h", Gender.MALE),
    FEMME("f", Gender.FEMALE),
    DEFAULT("") {
        @Override
        public void accept(Consumer<String> callback) {
            // nothing
        }
    };

    private final String code;
    private final Gender[] genders;

    public static final Function<Gender, CallbackEnumWithFactory> FACTORY = EnumUtils.fromEnumUtil(values());

    CallbackEnumWithFactory(String code, Gender... genders) {
        this.code = code;
        this.genders = genders;
    }

    @Override
    public Gender[] get() {
        return genders;
    }

    @Override
    public void accept(Consumer<String> callback) {
        callback.accept(code);
    }
}
