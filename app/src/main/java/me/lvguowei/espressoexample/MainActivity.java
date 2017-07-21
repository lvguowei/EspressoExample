package me.lvguowei.espressoexample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import static android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                navigateToNewTask();
            }
        });

        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                int count = getSupportFragmentManager().getBackStackEntryCount();
                if (count == 0) {
                    fab.setVisibility(View.VISIBLE);
                }
            }
        });

        goToMainFragment();
    }

    private void goToMainFragment() {
        MainFragment fragment = MainFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content, fragment, MainFragment.class.getSimpleName())
                .commit();
    }

    /**
     * Click handler for the new menu item
     */
    public void navigateToNewTask(MenuItem item) {
        navigateToNewTask();
    }

    private void navigateToNewTask() {
        fab.setVisibility(View.GONE);
        NewTaskFragment f = NewTaskFragment.newInstance();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_content, f, NewTaskFragment.class.getSimpleName())
                .addToBackStack(NewTaskFragment.class.getSimpleName())
                .commit();
    }
}
