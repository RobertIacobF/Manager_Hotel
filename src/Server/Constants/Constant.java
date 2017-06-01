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

    public enum Messages{
        freeClean, freeUnclean, busyUnclean, busyClean;
    }
}
