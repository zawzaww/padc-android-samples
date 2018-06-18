package com.zawzaw.hellopadc.network;

import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import com.zawzaw.hellopadc.utils.NewsConstants;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class HttpUrlConnectionDataAgent implements NewsDataAgent {

    private static HttpUrlConnectionDataAgent objInstance;

    public HttpUrlConnectionDataAgent() {

    }

    public static HttpUrlConnectionDataAgent getObjInstance() {
        if (objInstance == null) {
            objInstance = new HttpUrlConnectionDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadNewsList(final int page, final String accessToken) {

        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... voids) {

                URL url;
                BufferedReader reader = null;
                StringBuilder stringBuilder;

                try {
                    // Create the HttpURLConnection.
                    url = new URL(NewsConstants.BASE_API + NewsConstants.GET_NEWS); // 1
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // 2

                    // Just want to do an HTTP POST here.
                    connection.setRequestMethod("POST"); // 3

                    // Give it 15 seconds to respond.
                    connection.setReadTimeout(15 * 1000); // 4

                    connection.setDoInput(true); // 5
                    connection.setDoOutput(true);

                    // Put the request parameter into NameValuePair list.
                    List<NameValuePair> params = new ArrayList<>(); // 6
                    params.add(new BasicNameValuePair(NewsConstants.PARAM_ACCESS_TOKEN, accessToken));
                    params.add(new BasicNameValuePair(NewsConstants.PARAM_PAGE, String.valueOf(page)));

                    // Write the parameters from NameValuePair list into connection obj.
                    OutputStream outputStream = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    writer.write(getQuery(params));
                    writer.flush();
                    writer.close();
                    outputStream.close();

                    connection.connect(); // 7

                    // Read the output from the server.
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // 8
                    stringBuilder = new StringBuilder();

                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        stringBuilder.append(line + "\n");
                    }

                    String responseString = stringBuilder.toString(); // 9
                    return responseString;

                } catch (Exception e) {
                    Log.e("ERROR", e.getMessage());
                } finally {
                    // Close the reader; this can throw an exception too, so
                    // wrap it in another try/catch block.
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException ioe) {
                            Log.e("ERROR", ioe.getMessage());
                            ioe.printStackTrace();
                        }
                    }
                }
                return null;
            }

            @Override
            protected void onPostExecute(String responseString) {
                super.onPostExecute(responseString);
            }

        }.execute();

    }

    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params) {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }

}
