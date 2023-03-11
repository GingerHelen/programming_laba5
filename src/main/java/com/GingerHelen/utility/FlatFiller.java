package com.GingerHelen.utility;

import com.GingerHelen.exceptions.IllegalValueException;
import com.GingerHelen.exceptions.InvalidInputException;
import javax.script.ScriptException;

public class FlatFiller {
    private final OutputManager outputManager;
    private final InputManager inputManager;
    public FlatFiller(OutputManager outputManager, InputManager inputManager) {
        this.outputManager = outputManager;
        this.inputManager = inputManager;
    }
    public <T> T fill(String message, Reader<T> reader) throws InvalidInputException, ScriptException {
        T returns;
        while (true) {
            try {
                outputManager.print(message + ": ");
                returns = reader.read();
                break;
            } catch (NumberFormatException e) {
                outputManager.printlnImportantMessage("Value must be a number");
                if (inputManager.getScriptMode()) {
                    throw new ScriptException("Number expected");
                }
            } catch (IllegalArgumentException e) {
                outputManager.printlnImportantMessage("Choose anything from list");
                if (inputManager.getScriptMode()) {
                    throw new ScriptException("An enum value was expected");
                }
            } catch (IllegalValueException e) {
                outputManager.printlnImportantMessage(e.getMessage());
                if (inputManager.getScriptMode()) {
                    throw new ScriptException(e.getMessage());
                }
            }
        }
        return returns;
    }
}
