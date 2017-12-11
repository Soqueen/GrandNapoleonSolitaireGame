package mcgill.ecse456.grandnapoleonsolitairegame;

/**
 * GNS Android Game Application
 * ScoreTable.java
 * Purpose: Feature of scoretable includes id, name, step counter and timer.
 *
 * @author Sok Heng Lim
 * @version 1.0 11/15/2017
 */

public class ScoreTable {
    private int _id;
    private String _name;
    private String _time;
    private int _step;
    // Set default constructor - cannot remove since android need it
    public ScoreTable(){

    }

    // Main constructor
    public ScoreTable(String name, String time, int step){
        this._name = name;
        this._time = time;
        this._step = step;
    }
    public void set_id(int id){
        this._id = id;
    }

    public void set_name(String name){
        this._name = name;
    }

    public void set_time(String time){
        this._time = time;
    }

    public void set_step(int step){
        this._step = step;
    }

    public int get_id(){
        return _id;
    }

    public String get_name(){
        return _name;
    }

    public String get_time(){
        return _time;
    }

    public  int get_step(){
        return _step;
    }
}
