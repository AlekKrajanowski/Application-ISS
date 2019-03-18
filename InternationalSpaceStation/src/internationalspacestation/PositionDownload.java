package internationalspacestation;
import java.net.*;
import java.io.*;
import org.json.JSONObject;
/**
 *
 * @author Alek
 */
//Klasa stworzona do zwracania czasu, szerokości i długości geograficznej ISS
public class PositionDownload {
    
        double getLatitude() throws Exception{
            URL object = new URL("http://api.open-notify.org/iss-now.json");             
            StringBuffer reply;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(object.openStream()))) {
            String inputLine;
            reply = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                reply.append(inputLine);
            }
        }
            JSONObject myresponse = new JSONObject(reply.toString());   
            double latitude = Double.parseDouble(myresponse.getJSONObject("iss_position").getString("latitude"));
        
        return latitude;}
        
        double getLongitude() throws Exception{
            URL object = new URL("http://api.open-notify.org/iss-now.json");             
            StringBuffer reply;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(object.openStream()))) {
            String inputLine;
            reply = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                reply.append(inputLine);
            }
        }
            JSONObject myresponse = new JSONObject(reply.toString());   
            double longitude = Double.parseDouble(myresponse.getJSONObject("iss_position").getString("longitude"));
        
        return longitude;}
        
        double getTime() throws Exception{
            URL object = new URL("http://api.open-notify.org/iss-now.json");             
            StringBuffer reply;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(object.openStream()))) {
            String inputLine;
            reply = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                reply.append(inputLine);
            }
        }
            JSONObject myresponse = new JSONObject(reply.toString());   
            double time = Double.parseDouble(myresponse.getString("timestamp"));
    
        return time;}
}   


