package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionShare extends Action {

    private Map<String, Project> projects;
    private Map<Long, Task> tasks;

    public ActionShare(Console console, String command) {
        super(console, command);
    }

    /**
     * Shares task between projects
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
        if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            int id = Integer.parseInt(projectTask[1]);
            shareTask(projectTask[0], id);
        }
        return ActionStatus.NONE;
    }

    /**
     * Adds task with id `taskId` to project `projectName`
     *
     * @param projectName project name
     * @param taskId task id
     */
    private void shareTask(String projectName, int taskId) {
        Task task = this.tasks.get((long) taskId);
        Project project = this.projects.get(projectName);
        if (task == null) {
            console.printError("Could not find a task with the id \"%s\".", taskId);
            return;
        }
        if (project == null) {
            console.printError("Could not find a project with the name \"%s\".", projectName);
            return;
        }
        project.addTask(task.getId());
    }
}
