package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.commands.Command;

import java.io.PrintStream;
import java.util.*;

public class Menu  {
    protected HashMap<String, Command> commands;

    public Menu(Command... commands) {
        this.init(commands);
    }

    protected void init(Command... commands) {
        this.commands = new LinkedHashMap<>() {{
            for (var command : commands) {
                put(command.getName(), command);
            }
        }};
    }

    public List<String> getNames() {
        var names = new ArrayList<String>();
        for (Map.Entry<String, Command> entry : commands.entrySet()) {
            String name = entry.getKey();
            names.add(name);
        }
        return names;
    }


    @Override
    public String toString() {
        return this.help();
    }

    public Optional<Command> get(String name) {
        if (commands.containsKey(name)) {
            return Optional.of(commands.get(name));
        } else {
            return Optional.empty();
        }
    }

public String help(){
        return "Available Commands" + "\n" + "Quit" + "\n" + "Help" + "\n"  + String.join("\n", this.getNames()) +  "\n";

}
public void show(Scanner console, PrintStream out) {
        while (true) {
            var commandName = console.nextLine();
        if (commandName.equals("Help") || commandName.equals("h")) {
            this.help();
            continue;
        }

        if (commandName.equals("Quit")) {
            break;
        }

        var command = this.get(commandName);

        command.ifPresentOrElse(Command::execute, () -> out.print("Try again\n To see commands type Help\n"));
    }
}
}
