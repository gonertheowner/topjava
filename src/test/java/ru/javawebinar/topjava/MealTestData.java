package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final int MEAL_ID = START_SEQ + 3;
    public static final int NOT_FOUND = START_SEQ + 10;
    public static final Meal meal = new Meal(MEAL_ID, LocalDateTime.of(2020, 2, 12, 10, 0),
            "description", 1000);
    public static final Meal notExistingMeal = new Meal(NOT_FOUND, LocalDateTime.now(), "", 100);
    public static final List<Meal> meals = Arrays.asList(
            new Meal(MEAL_ID, LocalDateTime.of(2020, 2, 12, 10, 0),
                    "description", 1000),
            new Meal(MEAL_ID + 1, LocalDateTime.of(2020, 2, 15, 13, 0),
                    "another description", 500)
    );

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.of(2023, 6, 1, 0, 0), "new meal", 500);
    }

    public static Meal getUpdated() {
        Meal updated = new Meal(meal);
        updated.setDescription("updated");
        updated.setCalories(700);
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparator().isEqualTo(expected);
    }
}
