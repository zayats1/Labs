package edu.bogdan.zaiats.lab6.main;

import edu.bogdan.zaiats.lab6.commands.*;
import edu.bogdan.zaiats.lab6.console.Menu;
import edu.bogdan.zaiats.lab6.service.MusicService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

class Main {
    protected static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws IllegalStateException {
        var console = new Scanner(System.in);
        var service = new MusicService();
        var menu = new Menu(new Show(service),new Add(service),new Save(service),new Load(service),new Remove(service));
        System.out.println(menu.help());
        menu.show(console,System.out);
        logger.info("Hello World!");
    }
}