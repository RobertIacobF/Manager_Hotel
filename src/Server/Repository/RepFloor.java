package Server.Repository;

import Server.Model.HotelRoom;

/**
 * Created by Robert Iacob on 14.05.2017.
 */
public class RepFloor implements IRepFloor {
    //TODO Adauga, sterge, update etaj, adauga, sterge, update camere

    private static RepFloor repFloorInstance = null;

    private RepFloor(){ }

    public static RepFloor getRepFloorInstance() {
        if(repFloorInstance == null)
            repFloorInstance = new RepFloor();
        return repFloorInstance;
    }

    @Override
    public void createFloor(HotelRoom newHotelRoom) {

    }

    @Override
    public HotelRoom readFloor(int number) {
        return null;
    }

    @Override
    public void updateFloor(int number, HotelRoom hotelRoom) {

    }

    @Override
    public void deleteFloor(int number) {

    }
}
