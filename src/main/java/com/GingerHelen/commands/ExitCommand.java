package com.GingerHelen.commands;

import com.GingerHelen.exceptions.NoSuchCommandException;

public class ExitCommand extends Command {
    public ExitCommand() {
        super("exit", "завершить программу (без сохранения в файл!)");
    }
    public void execute(String argument) throws NoSuchCommandException {
        if (!argument.isEmpty()) {
            throw new NoSuchCommandException();
        }
        setExecuteFlag(false);
    }
}
