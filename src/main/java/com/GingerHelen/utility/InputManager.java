package com.GingerHelen.utility;

import java.io.*;
import java.util.Stack;

public class InputManager {
    private final Stack<BufferedReader> readers = new Stack<>();
    private final Stack<File> files = new Stack<>();
    private boolean scriptMode = false;
    private final OutputManager outputManager;

    public InputManager(BufferedInputStream bufferedInputStream, OutputManager outputManager) {
        readers.push(new BufferedReader(new InputStreamReader(bufferedInputStream)));
        this.outputManager = outputManager;
    }

    public String read() throws SomethingExceptions{ //TODO добавить исключение
        try {
            if () { //TODO проверка есть ли что читать вообще пока не придумала
                return readers.peek().readLine();
            } else {
                if (scriptMode) {
                    finishReadScript();
                    return read();
                } else {
                    throw new SomethingExceptions();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startReadScript(String fileName) {
        File scriptFile = new File(fileName);
        if (files.contains(scriptFile)) {
            outputManager.printlnImportantMessage("Recursion detected in file " + files.peek().getName()
                    + ". The script " + scriptFile.getName() + " will not be executed twice!");
        } else {
            try {
                outputManager.println("Start reading from file " + scriptFile.getName() + "...");
                readers.push(new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream(fileName)))));
                files.push(scriptFile);
                scriptMode = true;
                outputManager.muteNotifications();
            } catch (IOException e) {
                outputManager.printlnImportantMessage("Cannot find file " + scriptFile.getName());
            }
        }
    }

    public boolean getScriptMode() {
        return scriptMode;
    }

    public void finishReadScript() {
        if (scriptMode) {
            if (readers.size() == 2) {
                scriptMode = false;
                outputManager.enableNotifications();
            }
            readers.pop();
            outputManager.println("Reading from file " + files.pop().getName() + " was finished");
        }
    }
}
