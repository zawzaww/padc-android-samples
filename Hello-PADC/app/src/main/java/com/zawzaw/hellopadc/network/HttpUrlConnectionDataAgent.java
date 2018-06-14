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
    public void loadNewsList(int page, final String accessToken) {

        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                URL url;
                BufferedReader bufferedReader = null;
                StringBuilder stringBuilder;

                try {
                    // Step(1)
                    url = new URL(NewsConstants.BASE_URL + NewsConstants.GET_NEWS);
                    // Step(2)
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                    // Step(3)
                    connection.setRequestMethod("POST");

                    // Step(4)
                    connection.setReadTimeout(15 * 1000);

                    // Step(5)
                    connection.setDoInput(true);
                    connection.setDoOutput(true);

                    // Step(6)
                    List<NameValuePair> params = new ArrayList<>();
                    params.add(new BasicNameValuePair(NewsConstants.PARAM_ACCESS_TOKEN, accessToken));

                    // Step(7)
                    OutputStream outputStream = connection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    writer.write(getQuery(params));
                    writer.flush();
                    writer.close();
                    outputStream.close();

                    connection.connect();

                    // Step(8)
                    bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    stringBuilder = new StringBuilder();

                    // Step(9)
                    String responseString = stringBuilder.toString();

                    return responseString;

                } catch (Exception e) {
                    Log.e(" ", e.getMessage());
                }

                finally {
                    // Close the reader; this can throw an exception too, so
                    // wrap it in another try/catch block.
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    }
                }

                return null;
            }

            @Override
            protected void onPostExecute(String s) {

                super.onPostExecute(s);
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
