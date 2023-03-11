package com.GingerHelen.utility;

import com.GingerHelen.exceptions.InvalidInputException;
import com.GingerHelen.data.*;
import com.GingerHelen.utility.FlatFiller;
import com.GingerHelen.exceptions.IllegalValueException;

import javax.script.ScriptException;

public class FlatFillerMain {
    private final FlatReader reader;
    private final InputManager inputManager;
    private final OutputManager outputManager;
    private final CollectionManager collectionManager;
    private FlatFiller flatFiller;

    public FlatFillerMain(FlatReader reader, InputManager inputManager,
                             OutputManager outputManager, CollectionManager collectionManager) {
        this.reader = reader;
        this.inputManager = inputManager;
        this.outputManager = outputManager;
        this.collectionManager = collectionManager;
        flatFiller = new FlatFiller(outputManager, inputManager);
    }

    public String fillName() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Enter name", reader::readNotEmptyString);
    }


    public int fillX() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Enter x coordinate", reader::readX);
    }


    public long fillY() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Enter y coordinate", reader::readY);
    }


    public Coordinates fillCoordinates() throws ScriptException, InvalidInputException {
        return new Coordinates(this.fillX(), this.fillY());
    }


    public Long fillArea() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Enter area", reader::readArea);
    }


    public long fillNumberOfRooms() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Enter number of rooms", reader::readGreaterNullLong);
    }


    public Furnish fillFurnish() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Chose the furnish type. Type NONE, FINE, LITTLE", reader::readFurnish);
    }


    public View fillView() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Chose the view. Type STREET, PARK, BAD, NORMAL, TERRIBLE", reader::readView);
    }


    public Transport fillTransport() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Chose the transport. Type FEW, NONE, LITTLE, NORMAL, ENOUGH", reader::readTransport);
    }


    public String fillHouseName() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Enter name of house", reader::readNotNullString);
    }

    public Long fillHouseYear() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Enter year, when house was build", reader::readHouseYear);
    }
    public Integer fillHouseNumberOfFloors() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Enter number of floors in house", reader::readGreaterNullInteger);
    }
    public long fillHouseNumberFlatsOnFloor() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Enter number flats on floor", reader::readGreaterNullLong);
    }
    public Long fillHouseNumberOfLifts() throws ScriptException, InvalidInputException {
        return flatFiller.fill("Enter number of lifts", reader::readGreaterNullLong);
    }
    public House fillHouse() throws ScriptException, InvalidInputException {
        return new House(this.fillHouseName(), this.fillHouseYear(), this.fillHouseNumberOfFloors(),
                this.fillHouseNumberFlatsOnFloor(), this.fillHouseNumberOfLifts());
    }


    public Flat fillFlat() throws ScriptException, InvalidInputException {
        return new Flat(this.fillName(), this.fillCoordinates(), this.fillArea(), this.fillNumberOfRooms(), this.fillFurnish(),
                this.fillView(), this.fillTransport(), this.fillHouse(), collectionManager);
    }
}
