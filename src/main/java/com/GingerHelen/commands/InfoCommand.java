package com.GingerHelen.commands;

import com.GingerHelen.exceptions.NoSuchCommandException;
import com.GingerHelen.utility.CollectionManager;
import com.GingerHelen.utility.OutputManager;

public class InfoCommand extends Command {

    private final CollectionManager collectionManager;

    private final OutputManager outputManager;

    public InfoCommand(CollectionManager collectionManager, OutputManager outputManager) {
        super("info","вывести информацию о коллекции (тип, дата инициализации, количество элементов и т.д. )");
        this.collectionManager = collectionManager;
        this.outputManager = outputManager;
    }
    public void execute(String argument) throws NoSuchCommandException {
        if (!argument.isEmpty()) {
            throw new NoSuchCommandException();
        }
        outputManager.printlnImportantMessage(CollectionManager.collectionInfo());
    }
}
