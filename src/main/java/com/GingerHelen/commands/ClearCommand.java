package com.GingerHelen.commands;

import com.GingerHelen.utility.CollectionManager;
import com.GingerHelen.exceptions.NoSuchCommandException;

public class ClearCommand extends Command {
    private final CollectionManager collectionManager;
    public ClearCommand(CollectionManager collectionManager) {
        super("clear", "очистить коллекцию");
        this.collectionManager = collectionManager;
     }
     public void execute(String argument) throws NoSuchCommandException{
            if (!argument.isEmpty()) {
                throw new NoSuchCommandException();
            }
            collectionManager.clear();
     }
}
