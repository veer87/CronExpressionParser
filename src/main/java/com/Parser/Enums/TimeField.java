package com.Parser.Enums;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TimeField {
    MINUTES(0, "minutes"),
    HOURS(1, "hours"),
    DAY_OF_MONTH(2, "day of month"),
    MONTH(3, "month"),
    DAY_OF_WEEK(4, "day of week"),
    COMMAND(5, "command");


    private int id;
    private String name;

    TimeField(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private static final Map<Integer, TimeField> reverseLookupById =
            Stream.of(TimeField.values())
                    .collect(Collectors.toMap(TimeField::getId, Function.identity()));

    private static final Map<String, TimeField> reverseLookupByName =
            Stream.of(TimeField.values())
                    .collect(Collectors.toMap(TimeField::getName, Function.identity()));

    private int getId() { return this.id;}
    private String getName() { return this.name; }

    public static TimeField ofId(int id) { return reverseLookupById.get(id); }

    public static TimeField ofName(int name) { return reverseLookupByName.get(name); }

}
