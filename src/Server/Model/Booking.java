package Server.Model;

import java.util.ArrayList;

public class Booking {
    private int bookingId;
    private long checkInDateTime;
    private long checkOutDateTime;
    private String bookingType;
    private int noPersons;
    private int roomsFare;
    private User user;
    ArrayList<Room> rooms;
    
    public Booking() {
        user = new User();
        rooms = new ArrayList<>();
        bookingId = -1;
        bookingType = "Reserved";

    }

    public void addRoom(String roomNumber) {
        rooms.add(new Room(roomNumber));
    }

    public void removeRoom(String roomNo) {
        for(Room a: rooms) {
            if(a.getRoomNumber().equals(roomNo)) {
                rooms.remove(a);
            }
        }
    }

    public int getRoomsFare() {
        int total = 0;
        for(Room room:rooms) {
            total += room.getRoomFare().getPricePerDay();
        }
        return total;
    }

    public void setRoomsFare(int roomsFare) { this.roomsFare = roomsFare; }

    public int getNoPerson() { return noPersons; }

    public void setNoPerson(int person) { this.noPersons = person; }

    public ArrayList<Room> getRooms() { return rooms; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }

    public int getBookingId() { return bookingId; }

    public void setBookingId(int booking_id) { this.bookingId = bookingId; }

    public String getBookingType() { return bookingType; }

    public void setBookingType(String bookingType) { this.bookingType = bookingType; }

    public long getCheckOutDateTime() { return checkOutDateTime;}

    public void setCheckOutDateTime(long checkOutDateTime) { this.checkOutDateTime = checkOutDateTime;}

    public long getCheckInDateTime() {
        return checkInDateTime;
    }

    public void setCheckInDateTime(long checkInDateTime) { this.checkInDateTime = checkInDateTime; }
}
