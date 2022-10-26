package persistence;

import org.json.JSONObject;

// Some methods used in this class were inspired by methods in JsonSerialization program
// GitHub Link: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo.git

// Represents a writable object that converts Objects to JSONObjects
public interface Writable {

    // EFFECTS: returns this as JSON Object
    JSONObject toJson();

}
