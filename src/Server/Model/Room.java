package Server.Model;

import Server.Constants.Constant;

public class Room {
    //private int roomId;
    private String roomNumber;
    private int bedNumber;
    private RoomFare roomFare;

    private boolean hasTV;
    private boolean hasWIFI;
    private boolean hasGizer;
    private boolean hasPhone;

    public Room(String roomNo) {
        roomNumber = roomNo;
    }

    //public int getRoomId() { return roomId; }
    //public void setRoomId(int roomId) { this.roomId = roomId; }

    public String getRoomNumber() { return roomNumber; }

    public void setRoomNumber(String roomNumber) { this.roomNumber = roomNumber; }

    public int getBedNumber() { return bedNumber; }

    public void setBedNumber(int bedNumber) { this.bedNumber = bedNumber; }

    public boolean isHasTV() { return hasTV; }

    public void setHasTV(boolean hasTV) { this.hasTV = hasTV; }

    public boolean isHasWIFI() { return hasWIFI; }

    public void setHasWIFI(boolean hasWIFI) { this.hasWIFI = hasWIFI; }

    public boolean isHasGizer() { return hasGizer; }

    public void setHasGizer(boolean hasGizer) { this.hasGizer = hasGizer; }

    public boolean isHasPhone() { return hasPhone; }

    public void setHasPhone(boolean hasPhone) { this.hasPhone = hasPhone; }

    public RoomFare getRoomFare() { return roomFare; }

    public void setRoomFare(RoomFare roomFare) { this.roomFare = roomFare; }
}
