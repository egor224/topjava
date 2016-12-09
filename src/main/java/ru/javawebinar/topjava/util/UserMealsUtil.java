package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        final List<UserMealWithExceed> lstUserMeal = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);

        lstUserMeal.forEach(System.out::println);
        //       for (UserMealWithExceed userMeal : lstUserMeal
//                )
        //           System.out.println(userMeal.getDescription());

    }

    public static List<UserMealWithExceed> getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
       final List<UserMealWithExceed> userMealWithExceedList = new ArrayList<>();
//        for (UserMeal userMeal : mealList
//                ) {
//            final LocalTime dateTime = LocalTime.of(userMeal.getDateTime().getHour(),
//                    userMeal.getDateTime().getMinute(), userMeal.getDateTime().getSecond());
//            if (Duration.between(dateTime, startTime).isNegative() && !Duration.between(dateTime, endTime).isNegative()) {
//                userMealWithExceedList.add(new UserMealWithExceed(userMeal.getDateTime(), userMeal.getDescription(),
//                        userMeal.getCalories(), userMeal.getCalories() > caloriesPerDay));
//            }


//        }
       // Map<LocalTime, Integer> localTimeIntegerMap =
        Map<LocalDate, Integer> localTimeIntegerMap = mealList.stream()
                .collect(Collectors.groupingBy(p -> p.getDateTime().toLocalDate(), Collectors.summingInt(p -> p.getCalories())));
      // localTimeIntegerMap.forEach((p1,p2)-> System.out.println(p1.toString()));
        return mealList.stream().filter(p -> TimeUtil.isBetween(p.getDateTime().toLocalTime(), startTime, endTime))
                .map(p -> new UserMealWithExceed(p.getDateTime(), p.getDescription(), p.getCalories(),
                        localTimeIntegerMap.get(p.getDateTime().toLocalDate()) > caloriesPerDay))
                .collect(Collectors.toList());
        // .forEach(p-> System.out.println(p));


    }
}
