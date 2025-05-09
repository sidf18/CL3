import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class HotelClient {
    public static void main(String[] args) {
        try {
            HotelBooking hotel = (HotelBooking) Naming.lookup("rmi://localhost/HotelService");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("\nHotel Booking System");
                System.out.println("1. Book a Room");
                System.out.println("2. Cancel Booking");
                System.out.println("3. View Bookings");
                System.out.println("4. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter guest name: ");
                        String name = scanner.nextLine();
                        System.out.println(hotel.bookRoom(name));
                        break;
                    case 2:
                        System.out.print("Enter guest name to cancel: ");
                        String cancelName = scanner.nextLine();
                        System.out.println(hotel.cancelBooking(cancelName));
                        break;
                    case 3:
                        List<String> bookings = hotel.getBookings();
                        System.out.println("Current Bookings: " + bookings);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
