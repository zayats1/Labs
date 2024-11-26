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

public class MusicService {

    private  final List<Music> records = new LinkedList<>();
   public  void addRecord(){
          var music = MusicReader.read(System.in);
          music.ifPresent(records::add);
          System.out.println("The record is added to your collection");
   }

   public void read() {
       var records = String.join("\n",this.records.toString());
       if (this.records.isEmpty()){
           System.out.println("The box of records is empty!\n Put some melodies in it");
           return;
       }
       System.out.println(records);
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

        } catch (FileNotFoundException e) {
           System.out.println("No file");
        }
     }


    public void save() {
        List<String> data = records.stream().map(Music::toString).toList();
        try {
            Writer.write("saved.csv",String.join("\n",data));
        } catch (IOException e) {
            System.out.println("Something went wrong while saving the file");
            System.out.println(e.toString());
        }
    }

    public void removeRecord() {

    }
}
