package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.time.LocalDate;
import java.util.Map;

public class ActionDeadline extends Action {

    public ActionDeadline(Console console, String command) {
        super(console, command);
    }

    @Override
    public ActionStatus execute(Map<String, Project> projects, Map<Long, Task> tasks) {
        String[] subcommandRest = command.split(" ", 2);

        int id = Integer.parseInt(subcommandRest[0]);
        LocalDate deadline = LocalDate.parse(subcommandRest[1]);

        Task task = tasks.get((long) id);

        if (task != null) {
            task.setDeadline(deadline);
            return ActionStatus.NONE;
        }

        console.printError("Could not find a task with an ID of %d.", id);
        return ActionStatus.NONE;
    }
}
