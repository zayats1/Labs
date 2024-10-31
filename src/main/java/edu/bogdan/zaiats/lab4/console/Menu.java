package edu.bogdan.zaiats.lab4.console;

import edu.bogdan.zaiats.lab4.commands.Command;

import java.util.*;

public class Menu {
    HashMap <String,Command> commands;

    public Menu (Command ... p) {
        this.commands = new HashMap<String, Command>() {{
            for (var command : p) {
                put(command.getClass().getSimpleName(),command);
            }
        }};
    }

    public String getItems(){
        var names = new ArrayList<String>();
        var context = new Object() {
            static int pos = 1;
        };
        commands.forEach((name,_)->
                {
                    names.add(context.pos + " " + name);
                    context.pos += 1;
                }
        );

        return names.toString().replaceAll(",","\n").replaceAll("[\\[\\]]","");
    }

    public Optional<Command> get(String name){
       return Optional.of(commands.get(name));
    }
}
