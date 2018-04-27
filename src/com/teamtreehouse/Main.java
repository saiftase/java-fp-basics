package com.teamtreehouse;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class Main {

    public static void yell (String words){
        Objects.requireNonNull(words, () -> "Created issue " + Main.createIssue());
        System.out.printf("%s!!!%n", words.toUpperCase());
    }

    public static String createIssue (){
        return "1";
    }

    public static void main(String[] args) {
        List<String> ingredients = Arrays.asList(
            "flour",
            "salt",
            "baking powder",
            "butter",
            "eggs",
            "milk"
        );

        // Basic for loop
        for (int i = 0; i < ingredients.size(); i++){
            String ingredient = ingredients.get(i);
            System.out.println(ingredient);
        }

        // Enhanced for loop
        for(String ingredient : ingredients){
            System.out.println(ingredient);
        }

        // For each with SAM
        ingredients.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        });

        // For each with lambda / anonymous function
        ingredients.forEach((String ingredient) -> {
            System.out.println(ingredient);
        });

        // For each with lambda / anonymous function (abbreviated)
        ingredients.forEach(ingredient -> System.out.println(ingredient));

        // With reusable consumer function
        Consumer<String> printer = ingredient -> System.out.println(ingredient);
        ingredients.forEach(printer);

        // Method reference
        ingredients.forEach(System.out::println);

        // Method reference - another example
        Main.yell("Hello World");
        ingredients.forEach(Main::yell);

        // Test 'Supplier' function shape
        // requireNotNull in yell is triggered when passed a null value
        // Other useful function shapes include 'function' and 'predicate'
        Main.yell(null);
    }
}
