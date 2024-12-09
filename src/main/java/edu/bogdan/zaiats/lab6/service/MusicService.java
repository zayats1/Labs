package edu.bogdan.zaiats.lab6.service;

import edu.bogdan.zaiats.lab6.console.MusicReader;
import edu.bogdan.zaiats.lab6.csv.MusicCsvParser;
import edu.bogdan.zaiats.lab6.music.Music;
import edu.bogdan.zaiats.lab6.storage.Reader;
import edu.bogdan.zaiats.lab6.storage.Writer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MusicService {
    protected  final Logger logger = LogManager.getLogger();
    private  final List<Music> records = new LinkedList<>();
   public  void addRecord(){
          var music = MusicReader.read(System.in);
          music.ifPresent(records::add);
          System.out.println("The record is added to your collection");
   }

   public void show() {
       if (this.records.isEmpty()){
           System.out.println("Nothing to show");
           logger.debug("Nothing to show");
           return;
       }

       System.out.println("Type  music, that you want to listen(default: all)");

       var scanner = new Scanner(System.in);
       var predicate = "";
       try {
           predicate = scanner.nextLine();
       } catch (Exception e) {
           predicate = "";
           logger.error("No lines to parse \n{}",e.getMessage());
       }

       var found = findRecord(predicate,this.records);
       if (found.isEmpty()){
           System.out.println("The music is not found");
           logger.debug("The music is not found");
           return;
       }

       var oneliner = found.stream().map(music -> String.join("  ",
               music.name(),
               music.album(),
               music.author(),
               music.duration(),
               music.style())).toList();

       var readable = String.join("\n",oneliner);
       System.out.println(String.join("\n",readable));
   }


   public void removeRecord(){
       System.out.println("Which music do you want to remove?");
       System.out.println("Select music");
       var scanner = new Scanner(System.in);
       var predicate = scanner.nextLine();
       if (predicate.isBlank() ) {
           System.out.println("Nothing to remove");
           return;
       }
       var found = findRecord(predicate,this.records);
       for (var music : found){
           System.out.println(found.indexOf(music) + " " + music);
       }
       var idx = -1;
       try {
       var scanned = scanner.nextLine();
           idx  = Integer.parseInt(scanned);
       } catch (Exception e) {
           System.out.println("Nothing to remove");
           logger.error("Nothing to remove\n{}",e.toString());
           return;
       }

       if(idx >= found.size() || idx < 0 ){
           System.out.println("idx is out of range");
           logger.error("idx is out of the range, idx = {}, found size is: {}",idx,found.size());
           return;
       }
       records.remove(idx);
       System.out.println("The Music removed from the list\nType Save, if you want the change");
       logger.debug("User removed a music record");
   }
   public void load(){
       var filename = "saved.csv";
        try {
            var data = Reader.readFile(filename);

        for (var line : data){
              var music = MusicCsvParser.fromLine(line);
              if (music != null && !records.contains(music)){
                  records.add(music);
              }
            }
           System.out.println("Loaded");
            logger.debug("User loaded a file");
        } catch (FileNotFoundException e) {
           System.out.println("No file");
           logger.error("File {} was not found",filename);
        }
     }


    public void save() {
        List<String> data = records.stream().map(MusicCsvParser::toLine).toList();
        try {
            Writer.write("saved.csv",String.join("\n",data));
            System.out.println("Saved successfully");
        } catch (IOException e) {
            System.out.println("Something went wrong while saving the file");
            logger.error("Something went wrong while saving the file\n {}",e.getMessage());
        }
    }

     List<Music> findRecord(String predicate, List<Music> records) {
        return records.stream()
              .filter(record -> record.toString().toLowerCase().contains(predicate.toLowerCase())).toList();
    }
}
