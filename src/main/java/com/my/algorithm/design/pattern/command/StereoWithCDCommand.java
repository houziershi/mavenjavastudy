package com.my.algorithm.design.pattern.command;

public class StereoWithCDCommand implements Command {

    private Stereo stereo;

    public StereoWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.stereoWithCD();
    }
}
