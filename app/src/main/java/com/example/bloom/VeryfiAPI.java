package com.example.bloom;

import java.util.Arrays;
import java.util.List;

import veryfi.*;

public class VeryfiAPI {
    public VeryfiAPI() {
    }

    public void verifyUser() {
        String clientId = BuildConfig.CLIENT_ID;
        String clientSecret = BuildConfig.CLIENT_SECRET;
        String username = BuildConfig.USERNAME;
        String apiKey = BuildConfig.APIKEY;

//        Client client = VeryfiClientFactory.createClient( clientId, clientSecret, username, apiKey);
//        List<String> categories = Arrays.asList("Advertising & Marketing", "Automotive");
//        String jsonResponse = client.processDocument("example1.jpg", categories, false, null);
//        return jsonResponse;
    }
}

