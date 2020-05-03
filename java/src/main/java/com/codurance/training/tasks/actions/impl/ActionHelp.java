package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionHelp extends Action {

    public ActionHelp(Console console) {
        super(console);
    }

    @Override
    public ActionStatus execute(Map<String, Project> projects, Map<Long, Task> tasks) {
        print("Commands:");
        print("  show");
        print("  add project <project name>");
        print("  add task <project name> <task description>");
        print("  share task <project name> <task ID>");
        print("  delete <task ID>");
        print("  delete <task ID> <project name");
        print("  check <task ID>");
        print("  uncheck <task ID>");
        console.printNewLine();
        return ActionStatus.NONE;
    }
}