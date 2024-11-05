package edu.bogdan.zaiats.lab4.commands;

public interface Command {
    void execute();

    default String getName() {
        return this.getClass().getSimpleName();
    }
}
