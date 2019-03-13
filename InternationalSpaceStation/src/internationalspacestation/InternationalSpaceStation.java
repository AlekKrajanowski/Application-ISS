package internationalspacestation;

public class InternationalSpaceStation {
    
    public static void main(String[] args) throws Exception {
        
        dataDownload PickUp = new dataDownload();//Utworzenie obiektu PickUp, aby uruchomić funkcję do wypisywania danych. 
        PickUp.getData();//Wywołanie funkcji, która pobiera a zarazem wypisuje dane.
    }
}
