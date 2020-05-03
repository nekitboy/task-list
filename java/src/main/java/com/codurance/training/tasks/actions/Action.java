package com.codurance.training.tasks.actions;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;

import java.util.Map;

public abstract class Action {

    protected String command;
    protected Console console;

    /**
     * @param console IO console
     * @param command action parameters
     */
    public Action(Console console, String command) {
        this.command = command;
        this.console = console;
    }

    /**
     * @param console IO console
     */
    public Action(Console console) {
        this.command = "None";
        this.console = console;
    }

    /**
     *
     */
    public Action() {
        this.command = "None";
        this.console = null;
    }

    /**
     * Prints string to console
     *
     * @param output string to be printed in console
     */
    protected void print(String output) {
        this.console.writer.println(output);
    }

    /**
     * Executes user command
     *
     * @param projects projects pool
     * @param tasksPool tasks pool
     * @return status of action execution
     */
    abstract public ActionStatus execute(Map<String, Project> projects, Map<Long, Task> tasksPool);

}