package edu.bogdan.zaiats.lab6.console;

import edu.bogdan.zaiats.lab6.commands.Add;
import edu.bogdan.zaiats.lab6.commands.Read;
import org.junit.jupiter.api.Test;
import edu.bogdan.zaiats.lab6.service.MusicService;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @Test
    void getItems() {
        var service = new MusicService();
        var menu = new Menu(new Read(service),new Add(service));
        assertEquals("Read\nAdd"
               , menu.getItems());
    }

    @Test
    void get() {
        var menu = new Menu();
        var command = menu.get("Help");
        assertFalse(command.isPresent());

        var service = new MusicService();
        var newMenu = new Menu(new Add(service));
        var addCommand = newMenu.get("Add");
        assertTrue(addCommand.isPresent());
        assertEquals(addCommand.get().getName(), Add.class.getSimpleName());
    }
}