package edu.bogdan.zaiats.lab6.commands;

import edu.bogdan.zaiats.lab6.service.MusicService;

public class Add extends  MusicServiceCommand {
    public Add(MusicService service) {
        super(service);
    }

    @Override
    public void execute() {
        this.service.addRecord();
    }
}
