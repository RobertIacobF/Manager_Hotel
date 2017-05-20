package Server.Repository;

import Server.Model.HotelRoom;
import Server.Model.Reservation;

/**
 * Created by Robert Iacob on 14.05.2017.
 */
public class RepHistory implements IRepHistory {
    private static RepHistory repHistoryInstance = null;

    private RepHistory(){ }

    public static RepHistory getRepHistoryInstance() {
        if(repHistoryInstance == null)
            repHistoryInstance = new RepHistory();
        return repHistoryInstance;
    }

    @Override
    public void createHistory(Reservation newReservation) {

    }

    @Override
    public Reservation readHistory(HotelRoom newHotelRoom) {
        return null;
    }

    @Override
    public void updateHistory(Reservation newReservation) {

    }

    @Override
    public void deleteHistory(Reservation newReservation) {

    }
    //TODO Adauga, sterge, update rezervare

}
