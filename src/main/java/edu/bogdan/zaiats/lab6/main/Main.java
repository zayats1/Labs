package edu.bogdan.zaiats.lab6.main;

import edu.bogdan.zaiats.lab6.commands.Add;
import edu.bogdan.zaiats.lab6.commands.Help;
import edu.bogdan.zaiats.lab6.commands.Read;
import edu.bogdan.zaiats.lab6.console.Menu;

class Main {
    public static void main(String[] args) {
        var menu = new Menu(new Read(), new Add(), new Help());

        System.out.println("Available Commands");
        System.out.println(menu);
    }
}