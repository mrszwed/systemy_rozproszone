import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Zlecenie implements Serializable {
    private String nazwaAgencji;
    private String typZlecenia;
    private int numerZlecenia;
    private String statusZlecenia="nowe";
    private String ktoZrealizowal="";

    Zlecenie(String nazwaAgencji, String typZlecenia, int numerZlecenia){
        this.nazwaAgencji=nazwaAgencji;
        this.typZlecenia=typZlecenia;
        this.numerZlecenia=numerZlecenia;
    }

    static Set<String> nazwyZlecen=new HashSet<>();
    static{
        nazwyZlecen.add("po"); //przewóz osób
        nazwyZlecen.add("pl"); //przewóz ładunku
        nazwyZlecen.add("us"); //umieszczenie satelity
    }

    public static Set<String> getNazwyZlecen(){
        return nazwyZlecen;
    }


    @Override
    public String toString() {
        return "Zlecenie{" +
                "nazwaAgencji='" + nazwaAgencji + '\'' +
                ", typZlecenia='" + typZlecenia + '\'' +
                ", numerZlecenia=" + numerZlecenia +
                ", statusZlecenia='" + statusZlecenia + '\'' +
                ", ktoZrealizowal='" + ktoZrealizowal + '\'' +
                '}';
    }

    String toJson(){
        JSONObject jo = new JSONObject(this);
//        jo.put("nazwaAgencji", nazwaAgencji);
//        jo.put("typZlecenia", typZlecenia);
        return jo.toString();
    }

    static Zlecenie fromJSON(String json){
        JSONObject jsonObject = new JSONObject(json);
        Zlecenie zlecenie=new Zlecenie();
        zlecenie.nazwaAgencji=jsonObject.getString("nazwaAgencji");
        zlecenie.typZlecenia=jsonObject.getString("typZlecenia");
        zlecenie.numerZlecenia= jsonObject.getInt("numerZlecenia");
        zlecenie.statusZlecenia=jsonObject.getString("statusZlecenia");
        zlecenie.ktoZrealizowal=jsonObject.getString("ktoZrealizowal");
        return zlecenie;
    }
}
