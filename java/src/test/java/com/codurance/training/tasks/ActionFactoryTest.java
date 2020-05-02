package com.codurance.training.tasks;

import com.codurance.training.tasks.actions.Action;
import com.codurance.training.tasks.actions.ActionFactory;
import com.codurance.training.tasks.actions.impl.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class ActionFactoryTest {

    Console console;

    @Test
    public void show() {
        Action action = ActionFactory.read("show", console);
        assertThat(action, instanceOf(ActionShow.class));
    }

    @Test
    public void quit() {
        Action action = ActionFactory.read("quit", console);
        assertThat(action, instanceOf(ActionQuit.class));
    }

    @Test
    public void add() {
        Action action = ActionFactory.read("add project secrets", console);
        assertThat(action, instanceOf(ActionAdd.class));
    }

    @Test
    public void check() {
        Action action = ActionFactory.read("check 1", console);
        assertThat(action, instanceOf(ActionCheck.class));
    }

    @Test
    public void uncheck() {
        Action action = ActionFactory.read("uncheck 1", console);
        assertThat(action, instanceOf(ActionCheck.class));
    }

    @Test
    public void help() {
        Action action = ActionFactory.read("help", console);
        assertThat(action, instanceOf(ActionHelp.class));
    }

    @Test
    public void error() {
        Action action = ActionFactory.read("some errored text", console);
        assertThat(action, instanceOf(ActionError.class));
    }

}
