package com.codurance.training.tasks.actions;

import com.codurance.training.tasks.Console;
import com.codurance.training.tasks.actions.impl.*;

public class ActionFactory {
    private ActionFactory() {}

    public static Action read(String commandString, Console console) {
        String[] commandRest = commandString.split(" ", 2);
        String command = commandRest[0];
        switch (command) {
            case "show":
                return new ActionShow(console);
            case "quit":
                return new ActionQuit();
            case "add":
                return new ActionAdd(console, commandRest[1]);
            case "delete":
                return new ActionDelete(console, commandRest[1]);
            case "check":
                return new ActionCheck(console, commandRest[1], true);
            case "uncheck":
                return new ActionCheck(console, commandRest[1], false);
            case "deadline":
                return new ActionDeadline(console, commandRest[1]);
            case "today":
                return new ActionToday(console);
            case "help":
                return new ActionHelp(console);
            case "share":
                return new ActionShare(console, commandRest[1]);
        }
        return new ActionError();
    }
}