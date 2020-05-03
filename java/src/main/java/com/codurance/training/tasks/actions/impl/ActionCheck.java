package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionCheck extends Action {

    private final boolean isDone;

    public ActionCheck(Console console, String command, boolean isDone) {
        super(console, command);
        this.isDone = isDone;
    }

    /**
     * Checks or Unchecks task
     *
     * @param projects projects pool
     * @param tasks tasks pool
     * @return status of action execution
     */
    @Override
    public ActionStatus execute(Map<String, Project> projects, Map<Long, Task> tasks) {
        int id = Integer.parseInt(command);

        Task task = tasks.get((long) id);
        if (task != null) {
            task.setDone(isDone);
            return ActionStatus.NONE;
        }
        console.printError("Could not find a task with an ID of %d.", id);
        return ActionStatus.NONE;
    }

}
