package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionUncheck extends Action {

    private Map<String, Project> tasks;

    public ActionUncheck(Console console, String command) {
        super(console, command);
    }

    @Override
    public ActionStatus execute(Map<String, Project> tasks) {
        this.tasks = tasks;
        setDone(command, false);
        return ActionStatus.NONE;
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);

        for (Map.Entry<String, Project> tasksEntry : tasks.entrySet()) {
            Project project = tasksEntry.getValue();
            Task task = project.getTask(id);

            if (task != null) {
                task.setDone(done);
                return;
            }
        }
        console.printError("Could not find a task with an ID of %d.", id);
    }
}
