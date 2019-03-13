package internationalspacestation;

public class SpeedAndRoad {
    //Zmienne typu double, które zostały użyte do obliczeń drogi oraz prędkości ISS.
    double x1, x2, y1, y2, road, time, time1, speed;
    
    //Funkcja obliczająca drogę pokonaną przez satelitę ISS od początku zapisanych odczytów,
    //oraz prędkość ISS na podstawie dwóch odczytów.
    void Calculate(){
        
        road = Math.sqrt(((Math.pow(Math.abs(x2-x1), 2))+(Math.pow(Math.abs(y2-y1),2))));
        road=road*111.196672;
        System.out.println("Distance:"+road+"km");
        
        speed = road/(time1-time);     
        System.out.println("Speed:"+Math.abs(speed)+"km/s");
    }
}

