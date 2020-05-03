package com.codurance.training.tasks;

import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionFactory;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.LinkedHashMap;
import java.util.Map;

public final class TaskList implements Runnable {

    private final Map<String, Project> projects = new LinkedHashMap<>();
    private final Map<Long, Task> tasksPool = new LinkedHashMap<>();
    private final Console console;

    public TaskList(Console console) {
        this.console = console;
    }

    public void run() {
        ActionStatus status = ActionStatus.NONE;
        Action action;
        while (status != ActionStatus.QUIT) {
            String commandString = console.readCommand();
            action = ActionFactory.read(commandString, console);
            status = action.execute(projects, tasksPool);
        }
    }
}
