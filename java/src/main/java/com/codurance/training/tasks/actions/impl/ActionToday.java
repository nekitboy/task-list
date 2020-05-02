package com.codurance.training.tasks.actions.impl;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.Project;
import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionStatus;

import java.util.Map;

import static java.time.Clock.systemDefaultZone;
import static java.time.LocalDate.now;

public class ActionToday extends Action {

    public ActionToday(Console console) {
        super(console);
    }

    @Override
    public ActionStatus execute(Map<String, Project> tasks) {
        ;

        for (Map.Entry<String, Project> tasksEntry : tasks.entrySet()) {
            String output = tasksEntry.getKey();
            Project project = tasksEntry.getValue();
            console.writer.println(output);
            for (Task task : project.getTasks()) {
                if (now(systemDefaultZone()).equals(task.getDeadline())) {
                    console.writer.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
                }
            }
            console.printNewLine();
        }
        return ActionStatus.NONE;
    }
}