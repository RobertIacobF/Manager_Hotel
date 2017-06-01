package Server.Repository;

import Server.Model.Room;
import Server.Model.RoomFare;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RepRoom {
    //TODO toate camerele cu frigider, tv, baie in camera, wifi, cele libere, cele libere de la o anumita data

    Connection conn;
    PreparedStatement statement = null;
    ResultSet result = null;

    public RepRoom() { conn = DatabaseConnection.connToDB();}

    public void insertRoom(Room room) {
        try {
            String insertQuery = "insert into room('room_no','bed_number','tv','wifi','gizer','phone','room_class','meal_id')"
                    + " values('"
                    + room.getRoomNumber()
                    + "'," + room.getBedNumber() + ""
                    + ",'" + room.isHasTV() + "'"
                    + ",'" + room.isHasWIFI() + "'"
                    + ",'" + room.isHasGizer() + "'"
                    + ",'" + room.isHasPhone() + "'"
                    + ",'" + room.getRoomFare().getRoomType() + "'"
                    + ")";

            statement = conn.prepareStatement(insertQuery);
            statement.execute();

            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, "successfully inserted a new Room ");
        }
        catch (SQLException ex) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "InsertQuery of Room Class Failed");
        }
        finally {
            closeStatementOnly();
        }
    }

    public void updateRoom(Room room) {
        try {
            String updateQuery ="update room set room_no = '"
                    +room.getRoomNumber()+"', bed_number="
                    +room.getBedNumber()+", tv = '"
                    +boolToString(room.isHasTV())+"', wifi = '"
                    +boolToString(room.isHasWIFI())+"',gizer = '"
                    +boolToString(room.isHasGizer())+"', phone = '"
                    +boolToString(room.isHasPhone())+"', room_class= '"
                    +room.getRoomFare().getRoomType()+"', meal_id = "
                    ;

            statement = conn.prepareStatement(updateQuery);
            statement.execute();

            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, "successfully updated a room");
        }
        catch (SQLException ex) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Update query Failed");
        }
        finally {
            closeStatementOnly();
        }

    }

    public void deleteRoom(int roomId) {
        try {
            String deleteQuery = "delete from room where room_id=" + roomId;
            statement = conn.prepareStatement(deleteQuery);
            statement.execute();

            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, "Deleted room");
        }
        catch (SQLException ex) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, ex.toString() + "\n" + "Delete query room Failed");
        }
        finally {
            closeStatementOnly();
        }
    }


    public ResultSet getRooms() {
        try {
            String query = "select * from room";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        }
        catch (SQLException ex) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Room DB Operation");
        }
        finally {
            closeAll();
        }
        return result;
    }

    public int getNoRooms() {
        int rooms = -1;
        try {
            String query = "select count(room_no)  as noRoom from room";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
            while(result.next()) {
                rooms = result.getInt("noRoom");
            }
        }
        catch (SQLException ex) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming count Room DB Operation");
        }
        finally {
            closeAll();
        }
        return rooms;
    }

    public ResultSet getRoomsByStatus(String roomStatus){
        return result;
    }

    public ResultSet getARoomByNo(int roomNo){
        return result;
    }

    public ResultSet getAllRoomNames() {
        try {
            String query = "select room_no from room";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        }
        catch (SQLException ex) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Room_No  ROOM DB Operation");
        }
        finally {
            closeAll();
        }
        return result;
    }

    public ResultSet getARoomDetails(int roomNo){
        //camera ocupata, camera eliberata dar necuratata, camera libera)
        return result;
    }

    public ResultSet getRoomsFromFloor(int floor){
        try {
            String query = "";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        }
        catch (SQLException ex) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Room_No  ROOM DB Operation");
        }
        finally {
            closeAll();
        }
        return result;
    }

    public int getNoRoomsFromFloor(){
        return 0;
    }

    public ResultSet searchRoomsByPrice(float price){
        try {
            String query = "1";
            statement = conn.prepareStatement(query);
            result = statement.executeQuery();
        }
        catch (SQLException ex) {
            //TODO AICI TREBUIE AFISARE IN WEB, UN WEB ALLERT;
            //JOptionPane.showMessageDialog(null, ex.toString() + "\n error coming from returning all Room_No  ROOM DB Operation");
        }
        finally {
            closeAll();
        }
        return result;
    }

    public ResultSet searchRoomsByType(String type){
        return result;
    }

    public ResultSet searchRoomsByOption(String option){
        return result;
    }

    public ResultSet searchRoomsByStatus(String status){
        return result;
    }

    public String boolToString(boolean value) {
        return value ? "true" : "false";
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
