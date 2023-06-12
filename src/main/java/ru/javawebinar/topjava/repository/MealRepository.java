package ru.javawebinar.topjava.repository;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealRepository {
    // null if updated meal does not belong to userId
    Meal save(Integer userId, Meal meal);

    // false if meal does not belong to userId
    boolean delete(Integer userId, int mealId);

    // null if meal does not belong to userId
    Meal get(Integer userId, int mealId);

    // ORDERED dateTime desc
    Collection<Meal> getAll(Integer userId);
}
