package Server.Repository;

import Server.Model.Booking;

import javax.swing.*;
import java.awt.print.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepBooking {
    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;

    public RepBooking() {
        conn = DatabaseConnection.connToDB();
    }

    public void insertBooking(Booking booking) {
        for (int i = 0; i < booking.getRooms().size(); i++) {
            try {
                String insertQuery = "insert into booking"
                        + "('user_id','booking_rooms','guests','check_in','check_out','booking_type','has_checked_out')" + " values("
                        + booking.getUser().getUserId() + ","
                        + booking.getRooms().get(i).getRoomNumber() + ","
                        + booking.getNoPerson()  + ","
                        + booking.getCheckInDateTime() + ","
                        + booking.getCheckOutDateTime() + ","
                        + booking.getBookingType() + ","
                        + 0
                        + ")";

                statement = conn.prepareStatement(insertQuery);
                statement.execute();

                //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
                //JOptionPane.showMessageDialog(null, "successfully inserted new Booking");
            }
            catch (SQLException ex) {
                //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
                //JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery  booking Failed");
            }
            finally {
                closeStatementOnly();
            }
        }
    }

    public void updateBooking(Booking booking){
        try {
            String updateQuery = null;

            statement = conn.prepareStatement(updateQuery);
            statement.execute();

            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, "successfully updated new Customer");
        }
        catch (SQLException e) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, e.toString() + "\n" + "Update query Failed");
        }
        finally {
            closeStatementOnly();
        }
    }

    public void deleteBooking(int bookingId){
        try {
            String deleteQuery = "";
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();

            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, "Deleted user");
        }
        catch (SQLException e) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, e.toString() + "\n" + "Delete query Failed");
        }
        finally {
            closeStatementOnly();
        }
    }

    public ResultSet getBookingInformation() {
        try {
            String query = "select * from booking";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        }
        catch (SQLException e) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, e.toString() + "\n error coming from returning all booking DB Operation");
        }
        finally {
            closeAll();
        }
        return result;
    }

    public ResultSet getBooking(int bookingId) {
        try {
            String query = "select * from booking where booking_id = " + bookingId;
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        }
        catch (SQLException e) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, e.toString() + "\n error coming from returning A booking DB Operation");
        }
        finally {
            closeAll();
        }
        return result;
    }

    public ResultSet bookingsReadyForOrder(String roomName) {
        try {
            String query = "select booking_id,booking_room,name from booking join userInfo on booking.customer_id = userInfo.user_id where booking_room like '%" + roomName + "%' and has_checked_out = 0 order by booking_id desc";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        }
        catch (SQLException e) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, e.toString() + "\n error coming from returning bookingsReadyForOrder method,BookingDb");
        }
        finally {
            closeAll();
        }
        return result;
    }

    public int getRoomPrice(int bookingId) {
        int price = -1;
        try {
            String query = "select price from booking join room on booking_room = room_no join roomType on type= room_class where booking_id=" + bookingId;
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            price = result.getInt("price");
        }
        catch (SQLException ex) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning price getRoomPrice,bookingDB");
        }
        finally {
            closeAll();
        }
        return price;
    }

    public void closeAll() {
        try {
            statement.close();
            result.close();
        }
        catch (SQLException e) {
            System.err.print(e.toString() + " >> CLOSING");
        }
    }

    public void closeStatementOnly() {
        try {
            statement.close();
            conn.close();
        }
        catch (SQLException e) {
            System.err.print(e.toString() + " >> CLOSING");
        }
    }
}