package com.neopragma.legacy.utils;

import com.neopragma.legacy.entity.CityState;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Utility service to look up city and state based on a zip code
 *
 * @author neopragma
 * @version 1.0.0
 */
public class CityStateLookup {
    public CityState findCityStateBasedOnZipCode(String zipCode) throws URISyntaxException, IOException {
        CityState cityState;
        URI uri = getCityStateSearchUri(zipCode);
        HttpGet request = new HttpGet(uri);
        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = httpclient.execute(request);
        try {
            HttpEntity entity = response.getEntity();
            cityState = extractCityStateFromHttpEntity(response, entity);
        } finally {
            response.close();
        }
        return cityState;
    }

    private CityState extractCityStateFromHttpEntity(CloseableHttpResponse response, HttpEntity entity) throws IOException {
        CityState cityState = new CityState("", "");
        if (entity != null) {
            BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));
            StringBuffer result = new StringBuffer();
            String line = "";
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            int metaOffset = result.indexOf("<meta ");
            int contentOffset = result.indexOf(" content=\"Zip Code ", metaOffset);
            contentOffset += 19;
            contentOffset = result.indexOf(" - ", contentOffset);
            contentOffset += 3;
            int stateOffset = result.indexOf(" ", contentOffset);
            cityState.setCity(result.substring(contentOffset, stateOffset));
            stateOffset += 1;
            cityState.setState(result.substring(stateOffset, stateOffset+2));
        }
        return cityState;
    }

    private URI getCityStateSearchUri(String zipCode) throws URISyntaxException {
        return new URIBuilder()
                .setScheme("http")
                .setHost("www.zip-codes.com")
                .setPath("/search.asp")
                .setParameter("fld-zip", zipCode)
                .setParameter("selectTab", "0")
                .setParameter("srch-type", "city")
                .build();
    }
}
