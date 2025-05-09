import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class HotelBookingImpl extends UnicastRemoteObject implements HotelBooking {
    private List<String> bookings;

    protected HotelBookingImpl() throws RemoteException {
        super();
        bookings = new ArrayList<>();
    }

    @Override
    public synchronized String bookRoom(String guestName) throws RemoteException {
        if (bookings.contains(guestName)) {
            return "Booking failed: " + guestName + " already has a room.";
        }
        bookings.add(guestName);
        return "Booking successful for " + guestName;
    }

    @Override
    public synchronized String cancelBooking(String guestName) throws RemoteException {
        if (!bookings.contains(guestName)) {
            return "Cancellation failed: No booking found for " + guestName;
        }
        bookings.remove(guestName);
        return "Booking canceled for " + guestName;
    }

    @Override
    public synchronized List<String> getBookings() throws RemoteException {
        return new ArrayList<>(bookings);
    }
}
