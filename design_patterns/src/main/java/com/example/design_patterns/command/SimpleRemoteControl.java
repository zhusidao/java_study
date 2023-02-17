package com.example.design_patterns.command;

/**
 * 执行者
 * @author ZhuSiDao
 * @date 2020/12/30
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl(Command slot) {
        this.slot = slot;
    }

    public void setSlot(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed() {
        slot.execute();
    }

    public static void main(String[] args) {
        Command command = new LightOnCommand(new Light());
        new SimpleRemoteControl(command).buttonWasPressed();
    }
}
