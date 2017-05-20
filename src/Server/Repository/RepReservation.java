package Server.Repository;

import Server.Model.Reservation;
import Server.Model.User;
import Server.Repository.IRepReservation;

/**
 * Created by Robert Iacob on 14.05.2017.
 */
public class RepReservation implements IRepReservation {
    private static RepReservation repReservationInstante = null;

    private RepReservation(){ }

    public static RepReservation getRepReservationInstante() {
        if(repReservationInstante == null)
            repReservationInstante = new RepReservation();
        return repReservationInstante;
    }

    @Override
    public void createReservation(Reservation reservation) {

    }

    @Override
    public Reservation readReservation(User newUser) {
        return null;
    }

    @Override
    public void updateReservation(User newUser) {

    }

    @Override
    public void deleteReservation(User newUser) {

    }
    //TODO Adauga, sterge, update rezervare
}
