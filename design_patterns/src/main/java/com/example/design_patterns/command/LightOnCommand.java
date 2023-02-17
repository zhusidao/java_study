package com.example.design_patterns.command;

/**
 * 具体命令
 *
 * @author ZhuSiDao
 * @date 2020/12/30
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
