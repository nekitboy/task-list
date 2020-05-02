package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionCheck extends Action {

    private final boolean isDone;
    private Map<String, Project> tasks;

    public ActionCheck(Console console, String command, boolean isDone) {
        super(console, command);
        this.isDone = isDone;
    }

    @Override
    public ActionStatus execute(Map<String, Project> tasks) {
        this.tasks = tasks;

        int id = Integer.parseInt(command);

        for (Map.Entry<String, Project> tasksEntry : tasks.entrySet()) {
            Project project = tasksEntry.getValue();
            Task task = project.getTask(id);

            if (task != null) {
                task.setDone(isDone);
                return ActionStatus.NONE;
            }
        }
        console.printError("Could not find a task with an ID of %d.", id);
        return ActionStatus.NONE;
    }

}
