package me.lvguowei.espressoexample;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> rule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void shouldBeAbleToAddTasksAndHaveThemVisible() {
        for (int i = 0; i < 11; i++) {
            addTask("task " + i);
        }

        // onView(withId(R.id.task_list)).perform(RecyclerViewActions.scrollToPosition(10));
        // onView(withText("task 10")).check(matches(isDisplayed()));
        onView(withId(R.id.task_list)).perform(RecyclerViewActions.scrollTo(Matchers.withTaskViewName("task 10")));
    }

    private void addTask(String name) {
        // go to new task screen
        onView(withId(R.id.menu_main_new_task)).perform(click());

        // enter task name
        onView(withId(R.id.new_task_task_name)).perform(click());
        onView(withId(R.id.new_task_task_name)).perform(typeText(name));

        // enter task desc
        onView(withId(R.id.new_task_task_desc)).perform(click());
        onView(withId(R.id.new_task_task_desc)).perform(typeText("some task"));

        // click add button
        Espresso.closeSoftKeyboard();
        onView(withId(R.id.action_button)).perform(click());
    }
}
