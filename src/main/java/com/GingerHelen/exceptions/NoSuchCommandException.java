package com.GingerHelen.exceptions;

public class NoSuchCommandException extends Exception {
 public String getMessage() {
     return "Command with wrong argument. Try to tipe help to get all commands with their name and description";
 }
}
