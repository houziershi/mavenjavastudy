package com.my.algorithm.design.pattern.command;

public class StereoWithDVDCommand implements Command {

    private Stereo stereo;

    public StereoWithDVDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.stereoWithCD();
    }
}
