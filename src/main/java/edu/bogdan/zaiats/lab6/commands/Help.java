package edu.bogdan.zaiats.lab6.commands;

import edu.bogdan.zaiats.lab6.console.Menu;

public class Help implements Command {
    private final Menu menu;

    public Help(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        System.out.println("Available commands:");
        System.out.println(menu);
    }
}
