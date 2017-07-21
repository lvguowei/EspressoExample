package me.lvguowei.espressoexample;

import java.util.Date;

class Task {

    public final String uuid;
    public final String name;
    public final String description;
    public final Date timestamp;

    Task(String uuid, String name, String description, Date timestamp) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.timestamp = timestamp;
    }
}
