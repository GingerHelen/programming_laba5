package com.GingerHelen;

import com.GingerHelen.data.*;
import com.GingerHelen.utility.CollectionManager;
import com.GingerHelen.utility.Parser;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        /* TreeMap<Long, Flat> map = new TreeMap<>();
        Flat flat = new Flat(1, "name", new Coordinates(1, 2), (long) 123, 23, Furnish.FINE, View.BAD, Transport.ENOUGH,
                new House("house", (long) 2023, 4, 4, (long) 1));
        map.put((long) 1, flat);
        Flat flat2 = new Flat(2, "name", new Coordinates(4, 2), (long) 123, 23, Furnish.FINE, View.BAD, Transport.ENOUGH,
                new House("house", (long) 2023, 4, 4, (long) 1));
        map.put((long) 2, flat2);

        FileWriter writer = new FileWriter("collection.json");
        writer.write(Parser.serialize(map));
        writer.close(); */
        Path file = Paths.get("collection.json");
        List<String> str = Files.readAllLines(file);
        StringBuilder b = new StringBuilder("\n");
        for(String s : str) {
            b.append(s);
        }
        try {
            TreeMap<Long, Flat> flats = Parser.deSerialize(b.toString());
            CollectionManager collectionManager = new CollectionManager(flats, "collection.json");
            System.out.println(collectionManager);
        } catch (JsonSyntaxException e) {
            System.out.println("wrong json syntax");
        }
    }
}
