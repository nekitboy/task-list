package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionAdd extends Action {

    private Map<String, Project> projects;
    private Map<Long, Task> tasks;

    public ActionAdd(Console console, String command) {
        super(console, command);
    }

    /**
     * Adds new project or task
     *
     * @param projects projects pool
     * @param tasks tasks pool
     * @return status of action execution
     */
    @Override
    public ActionStatus execute(Map<String, Project> projects, Map<Long, Task> tasks) {
        this.projects = projects;
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

    /**
     * Adds new project
     *
     * @param name project name
     */
    private void addProject(String name) {
        projects.put(name, new Project(name));
    }

    /**
     * Adds task to project
     *
     * @param projectName project in which task should be added
     * @param description task description
     */
    private void addTask(String projectName, String description) {
        Project project = projects.get(projectName);
        if (project == null) {
            console.printError("Could not find a project with the name \"%s\".", projectName);
            return;
        }
        Task task = new Task(description, false);
        tasks.put(task.getId(), task);
        project.addTask(task.getId());
    }
}