package edu.bogdan.zaiats.lab6.commands;

public class Quit implements Command{

    @Override
    public void execute() {
       System.exit(0);
    }
}
