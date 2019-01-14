package com.my.algorithm.design.pattern.command;

public class StereoOnCommand implements Command {
    private Stereo stereo;

    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
       stereo.stereoOn();
    }
}
