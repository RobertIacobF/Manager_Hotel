package Server.Constants;

/**
 * Created by Robert Iacob on 14.05.2017.
 */
public class Constant {
    public enum RoomStatus {
        free, freeUnclean, busy, busyUnclean;
    }

    public enum UserType {
        simpleUser, receptionist, admin;
    }

    public enum RoomProp {
        singleRoom, twinRoom, suiteRoom, doubleRoom;
    }

    public enum RoomOptions {
        jacuzzi, roomService, pool, TV, airCond, fridge, balcony, bathroom;
    }

    public enum Messages{
        freeClean, freeUnclean, busyUnclean, busyClean;
    }
}
