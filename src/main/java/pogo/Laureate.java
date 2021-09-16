package pogo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class Laureate {
    private long id;
    private String firstname;
    private String surname;
    private String born;
    List<Prize> prizes;

    private int lauriatedAge;

    public int calculateLauriatedAge(){
        int prizeYear = prizes.get(0).getYear();
        int born =this.born==null?0:Integer.parseInt(this.born.substring(0,4));
        return prizeYear-born;
    }
}
