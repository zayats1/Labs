package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.music.Music;

import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Scanner;

public class MusicReader {
   public static Optional<Music> read(InputStream source){
        try {
             var scanner = new Scanner(source);
             System.out.println("Enter name of the record");
             var name =  scanner.nextLine();
             System.out.println("Album name");
             var album = scanner.nextLine();
             System.out.println("Author name");
             var author = scanner.nextLine();
             System.out.println("Durations");
             var duration = scanner.nextLine();
             System.out.println("Style");
             var style = scanner.nextLine();
             return Optional.of(new Music(name,album,author,duration,style));
        } catch (NoSuchElementException  e) {
             System.out.println("Nothing to parse"); // TODO log
        } catch (IllegalStateException e) {
             System.out.println("Illegal state");
        }
        return Optional.empty();
    }
}