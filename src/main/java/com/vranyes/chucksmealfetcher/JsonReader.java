package com.vranyes.chucksmealfetcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;


import java.nio.charset.Charset;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;

public class JsonReader {

  private final String url;

  public JsonReader(String url) {
    this.url = url;
  }

  private static String readJsonFromURL(Reader bufferedReaderFromURL) throws IOException {
    StringBuilder stringBuilder = new StringBuilder();
    int i;
    while ((i = bufferedReaderFromURL.read()) != -1) {
      stringBuilder.append((char) i);
    }
    return removeBrackets(stringBuilder.toString());
  }

  private static String removeBrackets(String string) {
    return string.substring(1, string.length() - 1);
  }

public JSONObject readJsonFromUrl() throws IOException, JSONException, URISyntaxException {
    try {
        InputStream is = new URI(url).toURL().openStream();
    
        try {
            BufferedReader bufferedReaderFromURL = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readJsonFromURL(bufferedReaderFromURL);
            JSONObject Mealjson = new JSONObject(jsonText);
            return Mealjson;
        } finally {
            is.close();
        }
    }finally{}
  }

}