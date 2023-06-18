package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final int MEAL_ID = START_SEQ + 3;
    public static final int NOT_FOUND = ADMIN_ID;
    public static final Meal meal = new Meal(MEAL_ID, LocalDateTime.of(2020, 2, 12, 0, 0),
            "description", 1000);
    public static final List<Meal> meals = new ArrayList<>();

    static {
        meals.add(new Meal(MEAL_ID, LocalDateTime.of(2020, 2, 12, 0, 0),
                "description", 1000));
        meals.add(new Meal(MEAL_ID + 1, LocalDateTime.of(2020, 1, 12, 0, 0),
                "another description", 500));
    }

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.now(), "new meal", 500);
    }

    public static Meal getUpdated() {
        Meal updated = new Meal(meal);
        updated.setDescription("updated");
        updated.setCalories(700);
        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields("dateTime").isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparatorIgnoringFields("dateTime").isEqualTo(expected);
    }
}
