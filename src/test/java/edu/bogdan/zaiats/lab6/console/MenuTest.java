package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.commands.Add;
import edu.bogdan.zaiats.lab6.service.MusicService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void help() {
        var menu = new Menu();
        var help = menu.help();
        assertEquals("Available Commands\nQuit\nHelp\n" + "\n", help);
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
}