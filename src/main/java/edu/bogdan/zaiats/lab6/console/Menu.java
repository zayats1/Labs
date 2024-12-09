package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.commands.Command;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.PrintStream;
import java.util.*;

public class Menu {
    protected  final Logger logger = LogManager.getLogger();
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


    public Optional<Command> get(String name) {
        if (commands.containsKey(name)) {
            return Optional.of(commands.get(name));
        } else {
            return Optional.empty();
        }
    }

    public String help() {
        return "Available Commands" + "\n" + "Quit" + "\n" + "Help" + "\n" + String.join("\n", this.getNames());
    }

    public void show(Scanner console, PrintStream out) {
        logger.info("Menu");
        while (true) {
            var commandName = console.nextLine();
            if (commandName.equalsIgnoreCase("Help")) {
                System.out.println(this.help());
                logger.info("User wants to know the commands");
                continue;
            }

            if (commandName.equalsIgnoreCase("Quit")) {
                logger.info("User quits the menu");
                break;
            }

            var command = this.get(commandName);
            logger.debug(commandName);
            command.ifPresentOrElse(c ->{
                c.execute();
                logger.debug("User executed the {}  command",c.getName());
            }, () -> {
                out.print("Try again\nTo see commands type Help\n");
                logger.warn("User enters wrong command");
            });
        }
    }
}
