package com.codurance.training.tasks;

import com.codurance.training.tasks.action.ActionIdentifier;
import com.codurance.training.tasks.action.Actions;
import com.codurance.training.tasks.action.ActionsBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final Map<String, Project> tasks = new LinkedHashMap<>();
    private final Console console;

    public TaskList(Console console) {
        this.console = console;
    }

    public void run() {
        while (true) {
            String command = console.readCommand();
            if (command.equals(TaskList.QUIT)) {
                break;
            }
            execute(command);
        }
    }

    private void execute(String commandLine) {
        String[] commandRest = commandLine.split(" ", 2);
        String command = commandRest[0];
        Actions commands = new ActionsBuilder()
                .withAction(new ActionIdentifier("show"), this::show)
                .withAction(new ActionIdentifier("add"), () -> add(commandRest[1]))
                .withAction(new ActionIdentifier("check"), () -> check(commandRest[1]))
                .withAction(new ActionIdentifier("uncheck"), () -> uncheck(commandRest[1]))
                .withAction(new ActionIdentifier("help"), this::help)
                .withDefault(() -> error(command))
                .build();
        commands.execute(new ActionIdentifier(command));
    }

    private void show() {
        for (Map.Entry<String, Project> tasksEntry : tasks.entrySet()) {
            String output = tasksEntry.getKey();
            Project project = tasksEntry.getValue();
            print(output);
            for (Task task : project.getTasks()) {
                console.writer.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
            }
            console.printNewLine();
        }
    }

    private void print(String output) {
        console.writer.println(output);
    }

    private void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        if (subcommand.equals("project")) {
            addProject(subcommandRest[1]);
        } else if (subcommand.equals("task")) {
            String[] projectTask = subcommandRest[1].split(" ", 2);
            addTask(projectTask[0], projectTask[1]);
        }
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

    private void check(String idString) {
        setDone(idString, true);
    }

    private void uncheck(String idString) {
        setDone(idString, false);
    }

    private void setDone(String idString, boolean done) {
        int id = Integer.parseInt(idString);

        for (Map.Entry<String, Project> tasksEntry : tasks.entrySet()) {
            Project project = tasksEntry.getValue();
            Task task = project.getTask(id);

            if (task != null) {
                task.setDone(done);
                return;
            }
        }
        console.printError("Could not find a task with an ID of %d.", id);
    }

    private void help() {
        print("Commands:");
        print("  show");
        print("  add project <project name>");
        print("  add task <project name> <task description>");
        print("  check <task ID>");
        print("  uncheck <task ID>");
        console.printNewLine();
    }

    private void error(String command) {
        String message = "I don't know what the command \"%s\" is.";
        console.printError(message, command);
    }
}
