package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.commands.*;
import edu.bogdan.zaiats.lab6.service.MusicService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
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
    void help() {
        var menu = new Menu();
        var help = menu.help();
        assertEquals("""
                Available Commands
                Quit
                Help
                """, help);
    }


    @Test
    void get() {
        var menu = new Menu();
        var command = menu.get("Helps");
        assertFalse(command.isPresent());

        var service = new MusicService();
        var newMenu = new Menu(new Add(service));
        var addCommand = newMenu.get("Add");
        assertTrue(addCommand.isPresent());
        assertEquals(addCommand.get().getName(), Add.class.getSimpleName());
    }

    @Test
    void show() {
        var service = new MusicService();
        var menu = new Menu(
                new Show(service),
                new Add(service),
                new Save(service),
                new Load(service),
                new Remove(service)
        );

        var data = """
                Help
                
                Quit
                """;
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        var console = new Scanner(System.in);
        menu.show(console,
                new PrintStream(printRes));
        var expected = """
                Available Commands
                Quit
                Help
                Show
                Add
                Save
                Load
                Remove
                Try again
                To see commands type Help
                """;
        var out = printRes.toString();
        assertEquals(expected, out);
    }
}