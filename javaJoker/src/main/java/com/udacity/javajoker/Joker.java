package com.udacity.javajoker;

/**
 * Created by McCrog on 23/06/2018.
 *
 */

public class Joker {
    public String tellJoke() {
        return Jokes.EnglandJokes.getJokes();
    }
}
