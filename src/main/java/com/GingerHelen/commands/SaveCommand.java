package com.GingerHelen.commands;

import com.GingerHelen.exceptions.NoSuchCommandException;
import com.GingerHelen.utility.CollectionManager;
import com.GingerHelen.utility.OutputManager;

public class SaveCommand extends Command {
    private final CollectionManager collectionManager;

    private final OutputManager outputManager;

    public SaveCommand(CollectionManager collectionManager, OutputManager outputManager) {
        super("save", "сохранить коллекцию в файл");
        this.collectionManager = collectionManager;
        this.outputManager = outputManager;
    }
    public void execute(String argument) throws NoSuchCommandException {
        if (!argument.isEmpty()) {
            throw new NoSuchCommandException();
        }
        collectionManager.save(outputManager);
    }
}
