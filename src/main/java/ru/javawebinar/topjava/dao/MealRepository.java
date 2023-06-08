package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.Collection;

public interface MealRepository {
    Meal save(Meal meal);

    Meal getById(int id);

    Collection<Meal> getAll();

    void delete(int id);
}
