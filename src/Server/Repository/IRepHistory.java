package Server.Repository;

import Server.Model.HotelRoom;
import Server.Model.Reservation;

/**
 * Created by Robert Iacob on 17.05.2017.
 */
public interface IRepHistory {
    void createHistory(Reservation newReservation);

    Reservation readHistory(HotelRoom newHotelRoom);

    void updateHistory(Reservation newReservation);

    void deleteHistory(Reservation newReservation);
}
