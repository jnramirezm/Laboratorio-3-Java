package Model;

import java.util.ArrayList;

public class Card {
    private ArrayList<String> num;

    public Card(ArrayList<String> num){
        this.num = num;
    }

    public ArrayList<String> getNum() {
        return num;
    }

    public void setNum(ArrayList<String> num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "" +
                num
                ;
    }
    public Integer size(){
        return num.size();
    }

    public String get(Integer n){
        return num.get(n);
    }
}
