package me.lvguowei.espressoexample;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class Matchers {

    public static Matcher<View> withTaskViewName(final String expected) {
        return new TypeSafeMatcher<View>() {
            @Override
            protected boolean matchesSafely(View item) {
                if (item != null && item.findViewById(R.id.task_item_task_name) != null) {
                    TextView taskName = (TextView) item.findViewById(R.id.task_item_task_name);
                    return !TextUtils.isEmpty(taskName.getText()) && taskName.getText().toString().equals(expected);
                } else {
                    return false;
                }
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("Looked for " + expected + " in the task_item_layout.xml file");
            }
        };
    }
}
