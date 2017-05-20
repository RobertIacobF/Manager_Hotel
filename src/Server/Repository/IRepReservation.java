package Server.Repository;

import Server.Model.Reservation;
import Server.Model.User;

import javax.jws.soap.SOAPBinding;

/**
 * Created by Robert Iacob on 17.05.2017.
 */
public interface IRepReservation {
    void createReservation(Reservation reservation);

    Reservation readReservation(User newUser);

    void updateReservation(User newUser);

    void deleteReservation(User newUser);
}
