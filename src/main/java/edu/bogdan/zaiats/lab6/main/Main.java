package edu.bogdan.zaiats.lab6.main;

import edu.bogdan.zaiats.lab6.commands.Add;
import edu.bogdan.zaiats.lab6.commands.Command;
import edu.bogdan.zaiats.lab6.commands.Read;
import edu.bogdan.zaiats.lab6.console.Menu;
import edu.bogdan.zaiats.lab6.service.MusicService;

import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IllegalStateException {
        var service = new MusicService();
        var menu = new Menu(new Read(service), new Add(service));

        Runnable help = () ->{
           System.out.println("Available Commands");
           System.out.println(menu);
           System.out.println("Quit\n Help");
       };


        help.run();
        while(true) {
            var console = new Scanner(System.in);

            var commandName = console.nextLine();

            if (commandName.equals("Help") || commandName.equals("h")) {
                help.run();
                continue;
            }

            if (commandName.equals("Quit")){
                 System.exit(1);
            }

            var command = menu.get(commandName);

            command.ifPresentOrElse(Command::execute, () -> System.out.print("Try again\n To see commands type Help\n"));

        }

    }
}