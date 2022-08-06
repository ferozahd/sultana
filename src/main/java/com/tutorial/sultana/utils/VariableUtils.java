package com.tutorial.sultana.utils;

import com.tutorial.sultana.exceptions.InvalidConversion;
import org.bson.types.ObjectId;
import org.mapstruct.Named;

@Named("VariableUtils")
public class VariableUtils {
    @Named("objectIdToString")
    public static String toString(ObjectId id) {
        try {
            return id.toHexString();
        } catch (Exception e) {
            throw new InvalidConversion("Id is not an hexadecimal number");
        }
    }

    @Named("stringToObjectId")
    public static ObjectId toObjectId(String id) {
        try {
            return new ObjectId(id);
        } catch (Exception e) {
            throw new InvalidConversion("Id is not an hexadecimal number");
        }
    }





}
