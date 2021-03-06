package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionQuit extends Action {

    /**
     * Quits from application
     *
     * @param projects projects pool
     * @param tasks tasks pool
     * @return QUIT status
     */
    @Override
    public ActionStatus execute(Map<String, Project> projects, Map<Long, Task> tasks) {
        return ActionStatus.QUIT;
    }
}
