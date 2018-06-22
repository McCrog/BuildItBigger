package com.udacity.javajoker;

import java.util.Random;

/**
 * Created by McCrog on 23/06/2018.
 *
 */

public enum Jokes {

    /**
     * source: http://www.quickfunnyjokes.com/british.html
     */
    EnglandJokes(
            "Q: Why is no one late in London? \nA: Because there is a big clock right in the middle of town.",
            "Q: Why is England the wettest country? \nA: Because the queen has reigned there for years!",
            "Q: How does every English joke start? \nA: By looking over your shoulder.",
            "Q: What do you call an English restaurant that only serves pancakes? \nA: All Day Brexit",
            "Q: Why did the American Siamese twins move to England? \nA: So the other one could drive!"
    );

    private final String[] jokes;

    Jokes(String... s) {
        jokes = s;
    }

    public String getJokes() {
        Random random = new Random();
        return jokes[random.nextInt(jokes.length)];
    }
}
