package internationalspacestation;

import java.awt.Desktop;
import java.net.URI;
import java.util.Scanner;

public class InternationalSpaceStation {
     public static int menu(){
        System.out.println("Choose the option:");
        System.out.println("1.Calculate Speed and Road");
        System.out.println("2.Go to online ISS tracking");
        System.out.println("3.Save the result");
        System.out.println("4.Show the Latitude, Longitude and Time of 2 positions");
        System.out.println("5.Read the save");
        System.out.println("6.Get data one more ");
        System.out.println("7.EXIT");
        
        Scanner write = new Scanner(System.in);
        int choice = write.nextInt(); 
        return choice;
    }
    public static void main(String[] args) throws Exception {
        DataDownload PickUp = new DataDownload();
        PickUp.getData();
        DataBase PickU = new DataBase();
        PositionDownload data = new PositionDownload();
        int choice = menu();
        while(choice!=0){ 
        switch(choice){
            case 1: 
                PickUp.writeSpeedandRoad();
                break;
            case 2:
                Desktop desktop = java.awt.Desktop.getDesktop();
                URI uri = new java.net.URI("https://www.nasa.gov/multimedia/nasatv/iss_ustream.html");
                desktop.browse(uri); 
                break;
            case 3:
                PickU.savePosition(data.getTime(), data.getLongitude(), data.getLatitude());
                break;
            case 4:
                PickUp.writeResult();
                break;
            case 5:
                PositionTable table=new PositionTable();
                table.setVisible(true);
                break;
            case 6:
                PickUp.getData();
                break;
            case 7:
                System.out.println("Thanks for using this Application");
                System.exit(0);
        }
        System.out.println("\nPress Enter to contionue...");
        System.in.read();
        choice = menu();
    }
}
}
