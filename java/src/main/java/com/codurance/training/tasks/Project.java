package com.codurance.training.tasks;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Project {
    private final Map<Long, Boolean> tasksIds = new LinkedHashMap<>();
    private String name;

    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addTask(long id) {
        tasksIds.put(id, true);
    }

    public void deleteTask(long id) {
        tasksIds.remove(id);
    }

    public Map<Long, Boolean> getTasksIds() {
        return tasksIds;
    }
}
