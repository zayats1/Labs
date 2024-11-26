package edu.bogdan.zaiats.lab6.service;

import edu.bogdan.zaiats.lab6.console.MusicReader;
import edu.bogdan.zaiats.lab6.music.Music;

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
}
