package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionHelp extends Action {

    @Override
    public ActionStatus execute(Map<String, Project> tasks) {
        print("Commands:");
        print("  show");
        print("  add project <project name>");
        print("  add task <project name> <task description>");
        print("  delete <task ID>");
        print("  check <task ID>");
        print("  uncheck <task ID>");
        console.printNewLine();
        return ActionStatus.NONE;
    }
}