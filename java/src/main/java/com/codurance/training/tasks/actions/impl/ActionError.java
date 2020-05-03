package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionError  extends Action {

    @Override
    public ActionStatus execute(Map<String, Project> projects, Map<Long, Task> tasks) {
        String message = "I don't know what the command \"%s\" is.";
        console.printError(message, command);
        return ActionStatus.NONE;
    }
}