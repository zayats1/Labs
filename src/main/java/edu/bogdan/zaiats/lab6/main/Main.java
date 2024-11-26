package edu.bogdan.zaiats.lab6.main;

import edu.bogdan.zaiats.lab6.commands.Add;
import edu.bogdan.zaiats.lab6.commands.Read;
import edu.bogdan.zaiats.lab6.console.Menu;
import edu.bogdan.zaiats.lab6.service.MusicService;

import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IllegalStateException {
        var console = new Scanner(System.in);
        var service = new MusicService();
        var menu = new Menu(new Read(service),new Add(service));
        console = new Scanner(System.in);
        System.out.println(menu.help());
        menu.show(console,System.out);
    }
}