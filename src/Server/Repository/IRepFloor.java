package Server.Repository;

import Server.Model.HotelRoom;

/**
 * Created by Robert Iacob on 17.05.2017.
 */
public interface IRepFloor {
    void createFloor(HotelRoom newHotelRoom);

    HotelRoom readFloor(int number);

    void updateFloor(int number, HotelRoom hotelRoom);

    void deleteFloor(int number);


}
