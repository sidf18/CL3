import java.rmi.Naming;
// (also make sure you have these imports if needed)
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.net.MalformedURLException;

public class HotelServer {
    public static void main(String[] args) {
        try {
            // LocateRegistry.createRegistry(1099);  // this should stay commented
            HotelBookingImpl hotel = new HotelBookingImpl();
            Naming.rebind("rmi://localhost/HotelService", hotel);
            System.out.println("Hotel Booking Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
