package com.GingerHelen.utility;

import com.GingerHelen.commands.*;

import java.util.ArrayList;


public class CommandManager {
    private final ArrayList<Command> commands = new ArrayList<>();
    public CommandManager(CollectionManager collectionManager, FlatFillerMain flatFillerMain, InputManager inputManager, OutputManager outputManager) {
        commands.add(new ClearCommand(collectionManager));
        commands.add(new InfoCommand(collectionManager, outputManager));
        commands.add(new HelpCommand(commands, outputManager));
        commands.add(new ExitCommand());
    }

}
