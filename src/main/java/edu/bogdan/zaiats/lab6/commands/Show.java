package edu.bogdan.zaiats.lab6.commands;

import edu.bogdan.zaiats.lab6.service.MusicService;

public class Show extends MusicServiceCommand {
    public Show(MusicService service) {
        super(service);
    }

    @Override
    public void execute() {
        this.service.show();
    }
}