package edu.bogdan.zaiats.lab4.main;

import edu.bogdan.zaiats.lab4.commands.Add;
import edu.bogdan.zaiats.lab4.commands.Help;
import edu.bogdan.zaiats.lab4.commands.Read;
import edu.bogdan.zaiats.lab4.console.Menu;

class Main {
    public static void main(String[] args) {
//        List<String> lines = null;
//        if (args.length < 1){
//            System.out.println("no args?");
//            return;
//        }
//
//        try {
//          lines =  Reader.readFile(args[0]);
//          System.out.println(lines);
//        } catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//            return;
//        }
//
//        lines.forEach(
//                line -> System.out.println(MusicCsvParser.fromLine(line))
//        );
        var menu = new Menu(new Read(), new Add(), new Help());

        System.out.println("Commands");
        System.out.println(menu.getItems());


    }
}