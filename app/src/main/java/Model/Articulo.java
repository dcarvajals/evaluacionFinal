package Model;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Articulo {

    private String section = "";
    private String publication_id = "";
    private String title = "";
    private String doi = "";
    private String abstractx = "";
    private String date_published = "";
    private String authors = "";
    private String keywords = "";

    public Articulo(JSONObject jsonObject) throws JSONException {
        section = jsonObject.getString("section").toString();
        publication_id = jsonObject.getString("publication_id").toString();
        title = jsonObject.getString("title").toString();
        doi = jsonObject.getString("doi").toString();
        abstractx = jsonObject.getString("abstract").toString();
        date_published = jsonObject.getString("date_published").toString();

        //obtener los actors
        JsonParser parser_auth = new JsonParser();
        String autoresobjecet = jsonObject.getString("authors").toString();
        JsonArray autores = parser_auth.parse(autoresobjecet).getAsJsonArray();
        for(int i = 0; i < autores.size(); i++){
            JsonObject obj_aut = autores.get(i).getAsJsonObject();
            authors += obj_aut.get("nombres").getAsString() +", ";
            if(i == autores.size() - 1){
                authors += obj_aut.get("nombres").getAsString();
            }
        }

        //obtener las palabras claves
        JsonParser parser_key = new JsonParser();
        String keyobject = jsonObject.getString("keywords").toString();
        JsonArray palabras = parser_key.parse(keyobject).getAsJsonArray();
        for(int i = 0; i < palabras.size(); i++){
            JsonObject obj_key = palabras.get(i).getAsJsonObject();
            keywords += obj_key.get("keyword").getAsString() +", ";
            if(i == palabras.size() - 1){
                keywords += obj_key.get("keyword").getAsString();
            }
        }

    }

    public static ArrayList<Articulo> JsonObjectsBuild  (JSONArray datos) throws JSONException {
        ArrayList<Articulo> articulo = new ArrayList<>();
        for (int i = 0; i < datos.length(); i++) {
            Log.i("Logs", datos.getJSONObject(i).toString());
            articulo.add(new Articulo(datos.getJSONObject(i)));
        }
        return articulo;
    }

    public Articulo () {  }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getPublication_id() {
        return publication_id;
    }

    public void setPublication_id(String publication_id) {
        this.publication_id = publication_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getAbstractx() {
        return abstractx;
    }

    public void setAbstractx(String abstractx) {
        this.abstractx = abstractx;
    }

    public String getDate_published() {
        return date_published;
    }

    public void setDate_published(String date_published) {
        this.date_published = date_published;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
