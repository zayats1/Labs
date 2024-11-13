package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.commands.Command;

import java.util.*;

public class Menu {
    HashMap <String,Command> commands;

    public Menu (Command ... p) {
         this.init(p);
    }

    protected void init(Command ... p) {
        this.commands = new LinkedHashMap<>() {{
            for (var command : p) {
                put(command.getClass().getSimpleName(), command);
            }
        }};
    }
    public String getItems(){
        var names = new ArrayList<String>();
        var context = new Object() {
            int pos = 1;
        };
        commands.forEach((name,_)->
                {
                    names.add(context.pos + " " + name);
                    context.pos += 1;
                }
        );
        // .replaceAll(",","\n").replaceAll("[\\[\\]]","");
       return  String.join("\n",names);
    }

    @Override
    public String toString() {
        return this.getItems();
    }

    public Optional<Command> get(String name){
       return Optional.of(commands.get(name));
    }
}
