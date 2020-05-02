package com.codurance.training.tasks.actions;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;

import java.util.Map;

public abstract class Action {

    protected String command;
    protected Console console;

    public Action(Console console, String command) {
        this.command = command;
        this.console = console;
    }

    public Action(Console console) {
        this.command = "None";
        this.console = console;
    }

    public Action() {
        this.command = "None";
        this.console = null;
    }

    protected void print(String output) {
        console.writer.println(output);
    }

    abstract public ActionStatus execute(Map<String, Project> tasks);

}