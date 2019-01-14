package com.my.algorithm.design.pattern.command;

/**
 * @Description: command设计模式
 * @author: guokun
 * @data: 2018/8/16
 */
public class RemoteControlTest {
    public static void main(String[] args)
    {
        SimpleRemoteControl remote =
                new SimpleRemoteControl();
        Light light = new Light();
        Stereo stereo = new Stereo();

        // we can change command dynamically
        remote.setCommand(new
                LightOnCommand(light));
        remote.buttonWasPressed();
        remote.setCommand(new
                StereoWithCDCommand(stereo));
        remote.buttonWasPressed();
        remote.setCommand(new
                StereoOffCommand(stereo));
        remote.buttonWasPressed();
    }
}
