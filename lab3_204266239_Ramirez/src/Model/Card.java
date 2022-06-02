package Model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Collections;

public class Card {
    private ArrayList<String> num;


    public Card(){
        this.num = new ArrayList<String>();
    }

    public Card(ArrayList<String> num){

        this.num = num;
        Collections.shuffle(num);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(num, card.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
