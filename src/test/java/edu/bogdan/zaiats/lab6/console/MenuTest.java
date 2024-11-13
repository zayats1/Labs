package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.commands.Add;
import edu.bogdan.zaiats.lab6.commands.Help;
import edu.bogdan.zaiats.lab6.commands.Read;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void getItems() {
        var menu = new Menu(new Read(),new Add(),new Help());
        assertEquals(menu.getItems(), """
                1 Read
                2 Add
                3 Help""");
    }

    @Test
    void get() {
        var menu = new Menu(new Help());
        var command = menu.get("Help");
        assertTrue(command.isPresent());
        assertEquals(command.get().getName(), Help.class.getSimpleName());
    }
}