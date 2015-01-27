package utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class EnumUtils {
    public static <T extends Enum & Supplier<U[]>, U extends Enum> Function<U, T> fromEnumUtil(T[] values) {
        Map<U, T> mapping = new HashMap<>(values.length);
        for (T value : values) {
            U[] sources = value.get();
            if (sources == null || sources.length == 0) {
                tryPut(mapping, value, null);
                continue;
            }
            for (U source : sources) {
                tryPut(mapping, value, source);
            }
        }

        return mapping::get;
    }

    private static <T extends Enum & Supplier<U[]>, U extends Enum> void tryPut(Map<U, T> mapping, T value, U source) {
        if(mapping.containsKey(source)) {
            throw new IllegalStateException("Naming clash for "+value.getClass().getCanonicalName());
        }
        mapping.put(source, value);
    }
}
