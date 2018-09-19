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
import static com.neopragma.legacy.utils.ErrorMessages.*;

/**
 * Utility service to look up city and state based on a zip code
 * @throws CityStateLookupException when performing remote call for city and state lookup, wraps IOException and URISyntaxException
 *
 * @author neopragma
 * @version 1.0.0
 */
public class CityStateLookup {

    public CityState findCityStateBasedOnZipCode(String zipCode) throws CityStateLookupException{
        CityState cityState;
        CloseableHttpResponse response = null;
        try {
            URI uri = getCityStateSearchUri(zipCode);
            HttpGet request = new HttpGet(uri);
            CloseableHttpClient httpclient = HttpClients.createDefault();
            response = httpclient.execute(request);
            cityState = extractCityStateFromHttpResponse(response);
        } catch (IOException ioException) {
            throw new CityStateLookupException(FAILED_TO_MAKE_REMOTE_CALL.value, ioException);
        } finally {
            try {
                if (response != null) response.close();
            } catch (IOException ioException) {
                throw new CityStateLookupException(UNABLE_TO_CLOSE_HTTP_RESPONSE.value, ioException);
            }
        }
        return cityState;
    }

    private CityState extractCityStateFromHttpResponse(CloseableHttpResponse response) {
        CityState cityState = new CityState("", "");
        HttpEntity entity = response.getEntity();
        try {
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
        } catch (IOException ioException){
            throw new CityStateLookupException(FAILED_TO_MAKE_REMOTE_CALL.value, ioException);
        }

        return cityState;
    }

    private URI getCityStateSearchUri(String zipCode) {
        try {
            return new URIBuilder()
                    .setScheme("http")
                    .setHost("www.zip-codes.com")
                    .setPath("/search.asp")
                    .setParameter("fld-zip", zipCode)
                    .setParameter("selectTab", "0")
                    .setParameter("srch-type", "city")
                    .build();
        } catch (URISyntaxException uriSyntaxException){
            throw new CityStateLookupException(FAILED_TO_BUILD_URI.value, uriSyntaxException);
        }
    }
}
