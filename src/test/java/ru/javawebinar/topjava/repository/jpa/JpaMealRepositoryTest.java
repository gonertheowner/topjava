package ru.javawebinar.topjava.repository.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static ru.javawebinar.topjava.MealTestData.*;
import static ru.javawebinar.topjava.UserTestData.ADMIN_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

@ContextConfiguration("classpath:spring/spring-db.xml")
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class JpaMealRepositoryTest {

    @Autowired
    MealRepository repository;

    @Test
    public void create() {
        Meal created = repository.save(getNew(), USER_ID);
        int newId = created.id();
        Meal newMeal = getNew();
        newMeal.setId(newId);
        MEAL_MATCHER.assertMatch(created, newMeal);
        MEAL_MATCHER.assertMatch(repository.get(newId, USER_ID), newMeal);
    }

    @Test
    public void update() {
        Meal updated = getUpdated();
        repository.save(updated, USER_ID);
        MEAL_MATCHER.assertMatch(repository.get(MEAL1_ID, USER_ID), getUpdated());
    }

    @Test
    public void updateNotOwn() {
        assertNull(repository.save(getUpdated(), ADMIN_ID));
    }

    @Test
    public void delete() {
        assertTrue(repository.delete(MEAL1_ID, USER_ID));
    }

    @Test
    public void deleteNotOwn() {
        assertFalse(repository.delete(MEAL1_ID, ADMIN_ID));
    }

    @Test
    public void deleteNotFound() {
        assertFalse(repository.delete(NOT_FOUND, USER_ID));
    }

    @Test
    public void get() {
        Meal actual = repository.get(MEAL1_ID, USER_ID);
        MEAL_MATCHER.assertMatch(actual, meal1);
    }

    @Test
    public void getNotOwn() {
        assertNull(repository.get(MEAL1_ID, ADMIN_ID));
    }

    @Test
    public void getNotFound() {
        assertNull(repository.get(NOT_FOUND, USER_ID));
    }

    @Test
    public void getAll() {
        MEAL_MATCHER.assertMatch(repository.getAll(USER_ID), meals);
    }

    @Test
    public void getBetweenHalfOpen() {
        MEAL_MATCHER.assertMatch(repository.getBetweenHalfOpen(
                LocalDateTime.of(2020, 1, 30, 0, 0),
                LocalDateTime.of(2020, 2, 1, 0, 0),
                USER_ID), meals);
    }
}