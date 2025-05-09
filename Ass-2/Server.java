import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Start RMI registry on port 1099
            ConcatImpl obj = new ConcatImpl();
            Naming.rebind("ConcatService", obj);
            System.out.println("Server is ready.");
        } catch (Exception e) {
            System.out.println("Server error: " + e);
        }
    }
}
