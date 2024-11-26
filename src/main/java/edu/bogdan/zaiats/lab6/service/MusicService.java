package edu.bogdan.zaiats.lab6.service;

import edu.bogdan.zaiats.lab6.console.MusicReader;
import edu.bogdan.zaiats.lab6.csv.MusicCsvParser;
import edu.bogdan.zaiats.lab6.music.Music;
import edu.bogdan.zaiats.lab6.storage.Reader;
import edu.bogdan.zaiats.lab6.storage.Writer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MusicService {

    private  final List<Music> records = new LinkedList<>();
   public  void addRecord(){
          var music = MusicReader.read(System.in);
          music.ifPresent(records::add);
          System.out.println("The record is added to your collection");
   }

   public void show() {
       var records = String.join("\n",this.records.toString());
       if (records.isBlank()){
           System.out.println("Nothing to show");
           return;
       }
       System.out.println("Type name of  music, that you want to listen");
       var scanner = new Scanner(System.in);
       var predicate = scanner.nextLine();
       var found = findRecord(predicate,this.records);
       if (found.isEmpty()){
           System.out.println("The box of records is empty!\n Put some melodies in it");
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
       var found = findRecord(predicate,this.records);
       for (var music : found){
           System.out.println(found.indexOf(music) + " " + music);
       }
       var idx = scanner.nextInt();
       if(idx >= found.size() || idx < 0 ){
           System.out.println("idx is out of range");
           return;
       }
       records.remove(idx);
       System.out.println("The Music removed from the list\n Type Save, if you want the change");
   }
   public void load(){
        try {
            var data = Reader.readFile("saved.csv");

        for (var line : data){
              var music = MusicCsvParser.fromLine(line);
              if (music != null && !records.contains(music)){
                  records.add(music);
              }
            }
           System.out.println("Loaded");
        } catch (FileNotFoundException e) {
           System.out.println("No file");
        }
     }


    public void save() {
        List<String> data = records.stream().map(MusicCsvParser::toLine).toList();
        try {
            Writer.write("saved.csv",String.join("\n",data));
            System.out.println("Saved successfully");
        } catch (IOException e) {
            System.out.println("Something went wrong while saving the file");
            System.out.println(e.toString());
        }
    }

    public List<Music> findRecord(String predicate,List<Music> records) {
        return records.stream()
              .filter(record -> record.toString().toLowerCase().contains(predicate.toLowerCase())).toList();
    }
}
