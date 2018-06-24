package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;

import com.udacity.jokesfactory.JokeActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;

/**
 * Created by alex on 24/06/2018.
 */
public class EndpointAsyncTaskTest {
    @Rule
    public final ActivityTestRule<JokeActivity> mActivityTestRule = new ActivityTestRule<>(JokeActivity.class);

    @Before
    public void setUp() {
        new EndpointAsyncTask().execute(mActivityTestRule.getActivity());
    }

    @Test
    public void checkTextView_isDisplayed() {
        onView(withId(R.id.joke_text_view)).check(matches(isDisplayed()));
    }

    @Test
    public void checkTextView_notEmpty() {
        onView(withId(R.id.joke_text_view)).check(matches(not(withText(""))));
    }

}