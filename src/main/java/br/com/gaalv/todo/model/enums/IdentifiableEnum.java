package br.com.gaalv.todo.model.enums;

import java.util.stream.Stream;

public interface IdentifiableEnum {

    int getId();

    static <T extends Enum<T> & IdentifiableEnum> T toEnum(Class<T> enumClass, Integer id) {

        if (id == null || enumClass == null) return null;

        return Stream.of(enumClass.getEnumConstants())
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(String.format("Invalid id %d in %s",
                        id,
                        enumClass.getSimpleName())));
    }
}
