package tech.codingclub.helix.global;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlConnectionExample {
    public static String sendGet(String urlStr) throws IOException {
        StringBuilder result=new StringBuilder();
        URL url=new URL(urlStr);
        HttpURLConnection conn=(HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader rd=new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line;
        while ((line= rd.readLine())!=null){
            result.append(line);
        }
        rd.close();
        return result.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println(sendGet("https://codingclub.tech/test-get-request?name=Mehak"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
