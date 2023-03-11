package com.GingerHelen.utility;


import com.GingerHelen.exceptions.IllegalValueException;
import com.GingerHelen.exceptions.InvalidInputException;
@FunctionalInterface
public interface Reader<T> {
    T read() throws IllegalValueException, IllegalArgumentException, InvalidInputException;
}
