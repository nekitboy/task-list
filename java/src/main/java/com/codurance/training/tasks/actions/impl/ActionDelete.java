package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

public class ActionDelete extends Action {

    public ActionDelete(Console console, String command) {
        super(console, command);
    }
    private Map<String, Project> projects;

    /**
     * Deletes task
     *
     * @param projects projects pool
     * @param tasks tasks pool
     * @return status of action execution
     */
    @Override
    public ActionStatus execute(Map<String, Project> projects, Map<Long, Task> tasks) {
        this.projects = projects;
        String[] subcommandRest = command.split(" ", 2);
        int id = Integer.parseInt(subcommandRest[0]);
        Task task = tasks.get((long) id);
        if (task == null) {
            console.printError("Could not find a task with an ID of %d.", id);
            return ActionStatus.NONE;
        }
        if (subcommandRest.length > 1 && subcommandRest[1] != null) {
            deleteFromProject(subcommandRest[1], (long) id);
        }
        else {
            tasks.remove((long) id);
            for (Map.Entry<String, Project> tasksEntry : projects.entrySet()) {
                Project project = tasksEntry.getValue();
                project.deleteTask(id);
            }
        }
        return ActionStatus.NONE;
    }

    private void deleteFromProject(String projectName, Long id) {
        Project project = projects.get(projectName);
        if (project == null) {
            console.printError("Could not find a project with the name %s.", projectName);
            return;
        }
        project.deleteTask(id);
    }
}