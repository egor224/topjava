package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.Collection;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * GKislin
 * 06.03.2015.
 */
@Controller
public class MealRestController {
    private  static final Logger LOG = getLogger(MealRestController.class);

    @Autowired
    private MealService service;

    public Collection<Meal> getAll() {
        LOG.info("getAll");
        return service.getAll();
    }

    public Meal get(int id) {
        LOG.info("get " + id);
        return service.get(id);
    }

    public Meal create(Meal meal) {
        meal.setId(null);
        LOG.info("create " + meal);
        return service.save(meal);
    }

    public void delete(int id) {
        LOG.info("delete " + id);
        service.delete(id);
    }

    public void update(Meal meal, int id) {
        meal.setId(id);
        LOG.info("update " + meal);
        service.update(meal);
    }
}
