package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionAdd extends Action {

    private Map<String, Project> tasks;

    public ActionAdd(Console console, String command) {
        super(console, command);
    }

    @Override
    public ActionStatus execute(Map<String, Project> tasks) {
        this.tasks = tasks;
        String[] subcommandRest = command.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
        return ActionStatus.NONE;
    }

    private void addProject(String name) {
        tasks.put(name, new Project(name));
    }

    private void addTask(String projectName, String description) {
        Project project = tasks.get(projectName);
        if (project == null) {
            console.printError("Could not find a project with the name \"%s\".", project);
            return;
        }
        project.setTask(new Task(description, false));
    }
}