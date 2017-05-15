package Server.Model;

import Server.Constants.Constant;

public class HotelRoom {
    int etaj;
    int numar;
    Constant.RoomProp proprietati;
    Constant.RoomOptions optiuni;

    public int getEtaj() { return etaj;}

    public void setEtaj(int etaj) { this.etaj = etaj;}

    public int getNumar() { return numar;}

    public void setNumar(int numar) { this.numar = numar;}

    public Constant.RoomProp getProprietati() { return proprietati;}

    public void setProprietati(Constant.RoomProp proprietati) { this.proprietati = proprietati;}

    public Constant.RoomOptions getOptiuni() { return optiuni; }

    public void setOptiuni(Constant.RoomOptions optiuni) { this.optiuni = optiuni;}
}
