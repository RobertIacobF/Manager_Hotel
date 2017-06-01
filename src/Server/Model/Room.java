package Server.Model;

public class Room {
    private String roomNumber;
    private int bedNumber;
    private RoomFare roomFare;
    private String roomStatus; //free, freeUnclean, busy, busyUnclean;

    private boolean hasTV;
    private boolean hasWIFI;
    private boolean hasGizer;
    private boolean hasPhone;
    private boolean hasBathRoom;
    private boolean hasPool;
    private boolean hasBalcony;

    public Room(String roomNo) {
        roomNumber = roomNo;
    }

    public String getStatus() { return roomStatus; }

    public void setStatus(String status) { this.roomStatus = status; }

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

    public boolean isHasBathRoom() {
        return hasBathRoom;
    }

    public void setHasBathRoom(boolean hasBathRoom) {
        this.hasBathRoom = hasBathRoom;
    }

    public boolean isHasPool() {
        return hasPool;
    }

    public void setHasPool(boolean hasPool) {
        this.hasPool = hasPool;
    }

    public boolean isHasBalcony() {
        return hasBalcony;
    }

    public void setHasBalcony(boolean hasBalcony) {
        this.hasBalcony = hasBalcony;
    }
}
