package me.lvguowei.espressoexample;

import android.app.Application;

public class EspressoExampleApplication extends Application {

    public static TaskRepository taskRepository;

    @Override
    public void onCreate() {
        super.onCreate();

        taskRepository = new TaskRepository();
    }
}
