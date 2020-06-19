package network;

import org.json.JSONException;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkFile {
    private String problem;
    private String answer;

    public NetworkFile(String problem) {
        this.problem = problem;
        if (problem.contains("+")) {
            changeAdditionSign();
        }
    }

    private void changeAdditionSign() {
        problem = problem.replace("+", "%2B");
    }

    public void derivateProb() {
        String apikey = "T935PK-YTQEVK2WRV";
        String londonweatherquery = "http://api.wolframalpha.com/v2/query?appid=";
        String operation = "&input=" + problem + "&includepodid=Derivative&output=json";
        try {
            String theURL = londonweatherquery + apikey + operation;
            URL url = new URL(theURL);
            String jsondata = readSource(url.openStream());
            Parser parser = new Parser();
            answer = parser.parseLibrary(jsondata);
        } catch (JSONException | MalformedURLException e) {
            System.out.println("Error parsing JSON data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAnswer() {
        return answer;
    }



    private String readSource(InputStream is) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
            sb.append("\n");
        }

        br.close();

        return sb.toString();
    }

}

