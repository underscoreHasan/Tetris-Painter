package persistence;

import org.json.JSONObject;

// Interface to enforce implementation of a method that allows conversion of the instances
// of the inheriting class into JSON objects.
public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
