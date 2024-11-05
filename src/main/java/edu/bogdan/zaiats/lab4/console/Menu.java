package edu.bogdan.zaiats.lab4.console;

import edu.bogdan.zaiats.lab4.commands.Command;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Collectors;

public class Menu {
    HashMap<String, Command> commands;

    public Menu(Command @NotNull ... p) {
        this.commands = new HashMap<String, Command>() {{
            for (var command : p) {
                put(command.getName(), command);
            }
        }};
    }

    public String getItems() {
        var names = new ArrayList<String>();
        var keys = commands.keySet().toArray();
        for (int i = 0; i < commands.size(); i++) {
            var name = keys[i];
            names.add(i + 1 + " " + name);
        }

        return names.stream().map(it -> it.trim() + "\n").collect(Collectors.joining());
    }


    public Optional<Command> get(String name) {
        return Optional.of(commands.get(name));
    }

    @Override
    public String toString() {
        return "Available commands\n" +
                this.getItems();
    }
}
