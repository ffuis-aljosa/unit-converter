package unitconverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class CurrencyLoader {
    String[] currencies;
    double[] exchangeRates;

    public String[] getCurrencies() {
        return currencies;
    }

    public double[] getExchangeRates() {
        return exchangeRates;
    }
    
    public void loadCurrencies() throws MalformedURLException, IOException {
        URL url = new URL("http://api.fixer.io/latest");
        
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        
        InputStream inStream = connection.getInputStream();
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
        
        String response = "";
        String line;
        
        while ((line = reader.readLine()) != null) {
            response += line;
        }
        
        JSONObject json = new JSONObject(response);
        JSONObject rates = json.getJSONObject("rates");
        
        JSONArray keys = rates.names();
        int keysLength = keys.length();
        
        currencies = new String[keysLength + 1];
        exchangeRates = new double[keysLength + 1];
        
        currencies[0] = json.getString("base");
        exchangeRates[0] = 1;
        
        for (int i = 0; i < keysLength; i++) {
            String key = keys.getString(i);
            Double value = rates.getDouble(key);
            
            currencies[i + 1] = key;
            exchangeRates[i + 1] = 1 / value;
        }
    }
}
