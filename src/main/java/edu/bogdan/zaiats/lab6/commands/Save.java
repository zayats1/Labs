package edu.bogdan.zaiats.lab6.commands;

import edu.bogdan.zaiats.lab6.service.MusicService;

public class Save extends MusicServiceCommand{
    public Save(MusicService service) {
        super(service);
    }

    @Override
    public void execute() {
       service.save();
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
