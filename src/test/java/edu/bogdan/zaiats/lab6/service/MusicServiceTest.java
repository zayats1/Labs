package edu.bogdan.zaiats.lab6.service;

import edu.bogdan.zaiats.lab6.csv.MusicCsvParser;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MusicServiceTest {
    private final ByteArrayOutputStream printRes = new ByteArrayOutputStream();
    private MusicService service;

    @BeforeEach
    void before() {
        service = new MusicService();
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
    void after() {
        System.setIn(System.in);
        System.setOut(System.out);
    }


    @Test
    void addRecord() {
        var data = "Foreword\nMeteora\nLinkin park\n0:13\nrock\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        service.addRecord();
        service.show();
        var out = printRes.toString();
        var expected = """
                Enter name of the record
                Album name
                Author name
                Durations
                Style
                The record is added to your collection
                Type  music, that you want to listen(default: all)
                Foreword  Meteora  Linkin park  0:13  rock
                """;
        assertEquals(expected, out);
    }

    @Test
    void show() {
        service.show();
        var expected = """
                Nothing to show
                Enter name of the record
                Album name
                Author name
                Durations
                Style
                The record is added to your collection
                Type  music, that you want to listen(default: all)
                The music is not found
                """;

        var data = "Foreword\nMeteora\nLinkin park\n0:13\nrock\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        service.addRecord();
        data = "Honduras\nZal Rock\nZenyk\n2:35\nrock\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        service.show();

        var out = printRes.toString();
        assertEquals(expected, out);
    }

     // Todo refactor the test into smaller
    @Test
    void removeRecord() {
        var data = "Linkin\n0\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        service.removeRecord();

        data = "Linkin\n5\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        service.removeRecord();

         data = "Linkin\n-1\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        service.removeRecord();

         data = "Linkin\n-n\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        service.removeRecord();


        data = "Foreword\nMeteora\nLinkin park\n0:13\nrock\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        service.addRecord();


        data = "Linkin\n5\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        data = "Linkin\nh\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        service.removeRecord();
        data = "Linkin\n0\n";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        var expected = """
                Which music do you want to remove?
                Select music
                idx is out of range
                Which music do you want to remove?
                Select music
                idx is out of range
                Which music do you want to remove?
                Select music
                idx is out of range
                Which music do you want to remove?
                Select music
                Nothing to remove
                Enter name of the record
                Album name
                Author name
                Durations
                Style
                The record is added to your collection
                Which music do you want to remove?
                Select music
                0 Music[name=Foreword, album=Meteora, author=Linkin park, duration=0:13, style=rock]
                Nothing to remove
                Which music do you want to remove?
                Select music
                0 Music[name=Foreword, album=Meteora, author=Linkin park, duration=0:13, style=rock]
                The Music removed from the list
                Type Save, if you want the change
                Which music do you want to remove?
                Select music
                Nothing to remove
                """;
        service.removeRecord();
        var out = printRes.toString();
        var empty = new ByteArrayInputStream("\n".getBytes());
        System.setIn(empty);
        service.removeRecord();
        out = printRes.toString();
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
        String[] lines = {"Foreword,Meteora,Linkin park,0:13,rock",
                "Don't Stay,Meteora,Linkin park,3:07,rock",
                "Somewhere I Belong,Meteora,Linkin park,3:33,rock",
                "Lying from You,Meteora,Linkin park,2:55,nu metal"};

        var records = Arrays.stream(lines).map(MusicCsvParser::fromLine).toList();
        var prompt = "Linkin";
        var found = service.findRecord(prompt, records);

        var actual = """
                Music[name=Foreword, album=Meteora, author=Linkin park, duration=0:13, style=rock]
                Music[name=Don't Stay, album=Meteora, author=Linkin park, duration=3:07, style=rock]
                Music[name=Somewhere I Belong, album=Meteora, author=Linkin park, duration=3:33, style=rock]
                Music[name=Lying from You, album=Meteora, author=Linkin park, duration=2:55, style=nu metal]""";
        assertEquals(actual, String.join("\n", found.stream().map(Record::toString).toList()));


        prompt = "Don't Stay";
        actual = "Music[name=Don't Stay, album=Meteora, author=Linkin park, duration=3:07, style=rock]";
        found = service.findRecord(prompt, records);
        assertEquals(actual, String.join("\n", found.stream().map(Record::toString).toList()));

        prompt = "ggg";
        actual = "";
        found = service.findRecord(prompt, records);
        assertEquals(actual, String.join("\n", found.stream().map(Record::toString).toList()));

        prompt = "";
        found = service.findRecord(prompt, records);
        actual = """
                Music[name=Foreword, album=Meteora, author=Linkin park, duration=0:13, style=rock]
                Music[name=Don't Stay, album=Meteora, author=Linkin park, duration=3:07, style=rock]
                Music[name=Somewhere I Belong, album=Meteora, author=Linkin park, duration=3:33, style=rock]
                Music[name=Lying from You, album=Meteora, author=Linkin park, duration=2:55, style=nu metal]""";
        assertEquals(actual, String.join("\n", found.stream().map(Record::toString).toList()));
    }
}