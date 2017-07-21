package me.lvguowei.espressoexample;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldBeAbleToAddTasksAndHaveThemVisible() {
        // go to new task screen
        onView(withId(R.id.menu_main_new_task)).perform(click());

        // enter task name
        onView(withId(R.id.new_task_task_name)).perform(click());
        onView(withId(R.id.new_task_task_name)).perform(typeText("foo"));

        // enter task desc
        onView(withId(R.id.new_task_task_desc)).perform(click());
        onView(withId(R.id.new_task_task_desc)).perform(typeText("bar"));

        // click add button
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.action_button)).perform(click());

        // check the new task on screen
        onView(withText("foo")).check(matches(isDisplayed()));
    }
}
