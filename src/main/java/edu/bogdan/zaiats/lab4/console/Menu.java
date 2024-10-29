package edu.bogdan.zaiats.lab4.console;

import edu.bogdan.zaiats.lab4.commands.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Menu {
    Map<String,Command> commands;

    public Menu(Map<String, Command> commands) {
        this.commands = commands;
    }

    public List<String> getItems(){
        var names = new ArrayList<String>();
        commands.forEach((name,_)->  names.add(name));
        return names;
    }

    public Optional<Command> get(String name){
       return Optional.of(commands.get(name));
    }
}
