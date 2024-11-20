package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.commands.Command;
import edu.bogdan.zaiats.lab6.commands.Help;
import edu.bogdan.zaiats.lab6.commands.Quit;

import java.util.*;

public class Menu {
    HashMap <String,Command> commands;

    public Menu (Command ... p) {
         this.init(p);
         var help = new Help(this);
         var quit = new Quit();
         this.commands.put(help.getName(),help);
         this.commands.put(quit.getName(),quit);
    }

    protected void init(Command ... p) {
        this.commands = new LinkedHashMap<>() {{
            for (var command : p) {
                put(command.getName(), command);
            }
        }};
    }
    public String getItems(){
        var names = new ArrayList<String>();
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            String name = entry.getKey();
            names.add(name);
        }
        // .replaceAll(",","\n").replaceAll("[\\[\\]]","");
       return  String.join("\n",names);
    }

    @Override
    public String toString() {
        return this.getItems();
    }

    public Optional<Command> get(String name){
          if (commands.containsKey(name)) {
                return Optional.of(commands.get(name));
            } else {
              return Optional.empty();
          }
    }
}
