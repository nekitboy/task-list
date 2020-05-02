package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionQuit extends Action {

    @Override
    public ActionStatus execute(Map<String, Project> tasks) {
        return ActionStatus.QUIT;
    }
}
