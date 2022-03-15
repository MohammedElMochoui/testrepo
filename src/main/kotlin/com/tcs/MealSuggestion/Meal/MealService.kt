package com.tcs.MealSuggestion.Meal

import org.springframework.stereotype.Service

@Service
class MealService {
    val l: MutableList<Meal> = mutableListOf(
        Meal(1,
            "Vegetable mix for soup raw",
            listOf<String>(
                "Parsley fresh",
                "Celery leaves fresh",
                "Carrot raw av",
                "Leek raw",
                "Onions raw",
                "Celeriac raw",
            ),
            attributes = mutableListOf<String>(
                "chewable"
            ),
            "This Vegetable Soup has become one of my most popular soup recipes and for good reason! It’s healthy, it’s comforting and 1,000 times better than what you’ll get in a can! Full of flavor and so easy to make you can’t go wrong with a big warm bowl of vegetable soup."
        ),

        Meal(2,
            "Lasagna bolognese ready to eat",
            listOf<String>(
                "Binding agents averaged",
                "Cheese Gouda 48+ age 8 wk-4 mths",
                "Onions boiled",
                "Minced pork raw",
                "Oil vegetable av",
                "Carrot winter boiled",
                "Tomatoes classic round boiled",
                "Sauce hot liquid ready made <12% fat",
                "Pasta white av boiled",
                "Salt not fortified w iodine",
            ),
            attributes = mutableListOf<String>(
                ""
            ),
            "Lasagne (US: /ləˈzɑːnjə/, also UK: /ləˈzænjə/,[1] Italian: [laˈzaɲɲe]; singular lasagna, Italian: [laˈzaɲɲa]) are a type of pasta, possibly one of the oldest types,[2] made of very wide, flat sheets. Either term can also refer to an Italian dish made of stacked layers of lasagne alternating with fillings such as ragù (ground meats and tomato sauce), vegetables, cheeses (which may include ricotta, mozzarella, and parmesan), and seasonings and spices, like Italian seasoning, such as garlic, oregano and basil.[3]."),

    )

    fun getAllMeals() : MutableList<Meal> {
        return l;
    }

    fun getTopic(ingredients : List<String>, attributes : List<String>) : List<Meal> {

        val result : MutableList<Meal> = mutableListOf<Meal>();

        l.forEachIndexed { index, meal ->
            if (meal.ingredients.containsAll(ingredients) &&
                        meal.attributes.containsAll(attributes)) {
                result.add(meal);
            }
        }

        return result;
    }

    fun addMeal(body : MealQuery) {
        l.add(
            Meal(l.last().id+1,
                 body.name,
                 body.ingredients,
                 body.attributes,
                 body.description)
        );
    }

    fun addAttribute(body : MealQuery) {
        l.forEachIndexed { index, meal ->
            if (meal.id == body.id) {
                body.attributes.forEach { attribute ->
                    if (!meal.attributes.contains(attribute)) meal.attributes.add(attribute);
                }
            }
        }
    }
}