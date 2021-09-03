package Model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {

    private String journal_id = "";
    private String portada = "";
    private String abbreviation = "";
    private String description = "";
    private String name = "";

    public Revista(JSONObject jsonObject) throws JSONException {
        journal_id = jsonObject.getString("journal_id").toString();
        portada = jsonObject.getString("portada").toString();
        abbreviation = jsonObject.getString("abbreviation").toString();
        description = jsonObject.getString("description").toString();
        name = jsonObject.getString("name").toString();
    }

    public static ArrayList<Revista> JsonObjectsBuild  (JSONArray datos) throws JSONException{
        ArrayList<Revista> revistas = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            Log.i("Logs", datos.getJSONObject(i).toString());
            revistas.add(new Revista(datos.getJSONObject(i)));
        }
        return revistas;
    }

    public Revista() {
    }

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
