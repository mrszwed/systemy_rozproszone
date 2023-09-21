import javax.swing.plaf.TableHeaderUI;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Main {

    public static void main(String[] args) {
//        Zlecenie z=new Zlecenie("aa", "tt", 7);
//        String zj=z.toJson();
//        System.out.println(zj);
//        Zlecenie zl=Zlecenie.fromJSON(zj);
//        System.out.println(zl);

        try {

            Przewoznik p1 = new Przewoznik("po","pl", "przewoznik1");
            p1.setup();
            new Thread(p1).start();

            Przewoznik p2 = new Przewoznik("pl","us", "przewoznik2");
            p2.setup();
            new Thread(p2).start();

            Admin admin=new Admin();
            admin.autorun=true;
            admin.setup();
            new Thread(admin).start();

            Agencja a=new Agencja("agencja1");
            a.setup();
            a.run();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }

    }
}
