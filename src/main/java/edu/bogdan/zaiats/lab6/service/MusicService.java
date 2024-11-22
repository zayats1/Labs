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
   }

   public void read() {
       var records = String.join("\n",this.records.toString());
       System.out.println(records);
   }
}
