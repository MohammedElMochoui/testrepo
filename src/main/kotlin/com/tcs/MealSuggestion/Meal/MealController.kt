package com.tcs.MealSuggestion.Meal

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class MealController(
    @Autowired
    private val mealService: MealService
    ) {

    @RequestMapping(method= [RequestMethod.GET], value = ["/allmeals"])
    fun getAllMeals() : List<Meal> {
        return mealService.getAllMeals();
    }

    @RequestMapping(method= [RequestMethod.POST], value = ["/searchmeal"])
    fun getSuggestion(@RequestBody body : MealQuery) : List<Meal> {
        return mealService.getTopic(body.ingredients, body.attributes);
    }

    @RequestMapping(method= [RequestMethod.POST], value = ["/addmeal"])
    fun addMeal(@RequestBody body : MealQuery) {
        mealService.addMeal(body);
    }

    @RequestMapping(method= [RequestMethod.POST], value = ["/addattribute"])
    fun addAttribute(@RequestBody body : MealQuery) {
        mealService.addAttribute(body);
    }
}