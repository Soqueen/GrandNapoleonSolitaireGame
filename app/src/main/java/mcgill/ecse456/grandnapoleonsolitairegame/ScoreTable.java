package mcgill.ecse456.grandnapoleonsolitairegame;


public class ScoreTable {
    private int _id;
    private String _name, _time, _step;

    public ScoreTable(){

    }

    public ScoreTable(String name, String time, String step){
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

    public void set_step(String step){
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

    public  String get_step(){
        return _step;
    }
}
