package com.GingerHelen.utility;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputManager {
    private final FileOutputStream fileOutputStream;
    private MessageNotifications messageNotifications = MessageNotifications.ON;

    private enum MessageNotifications {
        ON,
        OFF
    }

    public OutputManager(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    public void println(String string) {
        if (messageNotifications.equals(MessageNotifications.ON)) {
            printlnImportantMessage(string);
        }
    }

    public void printlnImportantMessage(String string) {
        try {
            fileOutputStream.write(string.getBytes());
            fileOutputStream.write("\n".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void print(String string) {
        try {
            if (messageNotifications.equals(MessageNotifications.ON)) {
                fileOutputStream.write(string.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void muteNotifications() {
        messageNotifications = MessageNotifications.OFF;
    }

    public void enableNotifications() {
        messageNotifications = MessageNotifications.ON;
    }
}
