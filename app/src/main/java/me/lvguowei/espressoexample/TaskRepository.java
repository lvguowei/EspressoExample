package me.lvguowei.espressoexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class TaskRepository {

    private Map<String, Task> map;

    public TaskRepository() {
        map = new LinkedHashMap<>();
    }

    public void put(Task task) {
        map.put(task.uuid, task);
    }

    public Task get(String uuid) {
        return map.get(uuid);
    }

    public List<Task> getAll() {
        List<Task> result = new ArrayList<>();
        for (Task t : map.values()) {
            result.add(t);
        }
        return result;
    }
}
