package edu.bogdan.zaiats.lab6.service;

import edu.bogdan.zaiats.lab6.commands.*;
import edu.bogdan.zaiats.lab6.console.Menu;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MusicServiceTest {
    private final MusicService service = new MusicService();
    private final ByteArrayOutputStream printRes = new ByteArrayOutputStream();
    @BeforeEach
    void before() {
        try {
            printRes.flush();
        } catch (IOException e) {
            System.out.println("Done");
        }
        var data = "Foreword\nMeteora\nLinkin park\n0:13\nrock\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        System.setOut(new PrintStream(printRes));
    }

    @AfterEach
    void after(){
        System.setIn(System.in);
        System.setOut(System.out);
    }


    @Test
    void addRecord() {
        var data = "Foreword\nMeteora\nLinkin park\n0:13\nrock\n";
        service.addRecord();
        System.setIn(new ByteArrayInputStream(data.getBytes()));

    }

    @Test
    void show() {
    }

    @Test
    void removeRecord() {
        var expected = """
        Which music do you want to remove?
        Select music
        Nothing to remove
        """;
        
        
        
        
        
        
        
        
        

        var empty = new ByteArrayInputStream("\n".getBytes());
        service.removeRecord();
        var out = printRes.toString();
        assertEquals(expected, out);
    }

    @Test
    void load() {
    }

    @Test
    void save() {
    }

    @Test
    void findRecord() {

    }
}