package internationalspacestation;

import java.net.*;
import java.io.*;
import org.json.JSONObject;

public class dataDownload  {
    //Tablica wykorzystana do zapisywania danych wysyłanych przez ISS.
    double[][] tabdata;
    //Funkcja pobiera dane o satelicie ISS z linku Url.
    public dataDownload() {
        this.tabdata = new double[2][3];
    }
    @SuppressWarnings("empty-statement")
    void getData() throws Exception{
        
        for (int i=0;i<2;i++){
            
            URL object = new URL("http://api.open-notify.org/iss-now.json");             
            StringBuffer reply;
            
        try (BufferedReader in = new BufferedReader(new InputStreamReader(object.openStream()))) {
            
            String inputLine;
            reply = new StringBuffer();
            
            while ((inputLine = in.readLine()) != null) 
            {
                reply.append(inputLine);
            }
        }
            JSONObject myresponse = new JSONObject(reply.toString());   
            tabdata [i][0] = Double.parseDouble(myresponse.getJSONObject("iss_position").getString("latitude"));
            tabdata [i][1] = Double.parseDouble(myresponse.getJSONObject("iss_position").getString("longitude"));
            tabdata [i][2] = Double.parseDouble(myresponse.getString("timestamp")); 
            System.out.println("Time" + i + ": " + myresponse.getString("timestamp")+"[s]");
            System.out.println("Latitude" + i + ": "+tabdata[i][0]);
            System.out.println("Longitude" + i + ": "+tabdata[i][1]);
            
            if(i==1)
            break;
            
            Thread.sleep(5000);  
        }
            SpeedAndRoad road = new SpeedAndRoad();
            road.x1=tabdata[0][0];
            road.x2=tabdata[1][0];
            road.y1=tabdata[0][1];
            road.y2=tabdata[1][1];
            road.time=tabdata[0][2];
            road.time1=tabdata[1][2];
            road.Calculate(); 
    };  
}
