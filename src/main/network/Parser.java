package network;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Parser {

    /**
     * Prints library parsed from JSON data to console
     * @param jsonData  string containing JSON data
     * @throws JSONException when jsonData cannot be parsed as a JSONArray
     */
    public String parseLibrary(String jsonData) throws JSONException {
        JSONObject library = new JSONObject(jsonData);
        JSONObject l = library.getJSONObject("queryresult");
        JSONArray l2 = l.getJSONArray("pods");
        JSONObject l3 = l2.getJSONObject(0);
        JSONArray l4 = l3.getJSONArray("subpods");
        JSONObject l5 = l4.getJSONObject(0);
        return l5.getString("plaintext");
    }

    /**
     * Prints book parsed from JSON object to console
     * @param book  a JSON object representing a book
     * @throws JSONException when book does not have a title or an author field
     */
}
