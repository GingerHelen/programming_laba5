package com.GingerHelen.commands;

import com.GingerHelen.exceptions.NoSuchCommandException;
import com.GingerHelen.utility.OutputManager;

import java.util.ArrayList;

public class HelpCommand extends Command {

    private final ArrayList<Command> commands;

    private final OutputManager outputManager;

    public HelpCommand(ArrayList<Command> commands, OutputManager outputManager) {
        super("help","вывести справку по доступным командам");
        this.commands = commands;
        this.outputManager = outputManager;
    }
    public void execute(String argument) throws NoSuchCommandException {
        if (!argument.isEmpty()) {
            throw new NoSuchCommandException();
        }
        outputManager.printlnImportantMessage("Список доступных комманд:");
        for (Command command: commands) {
            outputManager.printlnImportantMessage(command.getName() + ": " + command.getDescription());
        }
    }
}
