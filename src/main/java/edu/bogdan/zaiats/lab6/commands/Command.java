package edu.bogdan.zaiats.lab6.commands;

public interface Command {
    void execute();

    default String getName() {
        return this.getClass().getSimpleName();
    }
}
