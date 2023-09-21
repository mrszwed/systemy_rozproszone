import IHouse.DeviceInfo;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;

import java.util.ArrayList;
import java.util.List;

public class Serwer {
    List<DeviceInfo> devices=new ArrayList<>();

    void registerDevice(String type, String name, String location, String description){
        DeviceInfo di=new DeviceInfo(type, name, location, description);
        devices.add(di);
    }

    void setupDevices(ObjectAdapter adapter){
        HeatingImp hServant = new HeatingImp();
        String name="heating-salon";
        String category="heating";
        String location="salon";
        adapter.add(hServant, new Identity(name, category));
        registerDevice(category, name, location, "ogrzewanie w salonie");

        DimmableLightImp dlServant = new DimmableLightImp();
        name="dimmableLight-salon";
        category="dimmableLight";
        location="salon";
        adapter.add(dlServant, new Identity(name, category));
        registerDevice(category, name, location, "sciemniane swiatlo w salonie");

        name="motionSensor-salon";
        MotionSensorImp msServant = new MotionSensorImp(name);
        category="motionSensor";
        location="salon";
        adapter.add(msServant, new Identity(name, category));
        registerDevice(category, name, location, "detektor ruchu w salonie");

        hServant = new HeatingImp();
        name="heating-kuchnia";
        category="heating";
        location="kuchnia";
        adapter.add(hServant, new Identity(name, category));
        registerDevice(category, name, location, "ogrzewanie w kuchni");

        LightImp lServant = new LightImp();
        name="light-kuchnia";
        category="light";
        location="kuchnia";
        adapter.add(lServant, new Identity(name, category));
        registerDevice(category, name, location, "swiatlo w kuchni");

        hServant = new HeatingImp();
        name="heating-sypialnia";
        category="heating";
        location="sypialnia";
        adapter.add(hServant, new Identity(name, category));
        registerDevice(category, name, location, "ogrzewanie w sypialni");

        dlServant = new DimmableLightImp();
        name="dimmableLight-sypialnia";
        category="dimmableLight";
        location="sypialnia";
        adapter.add(dlServant, new Identity(name, category));
        registerDevice(category, name, location, "sciemniane swiatlo w sypialni");

        name="motionSensor-sypialnia";
        msServant = new MotionSensorImp(name);
        category="motionSensor";
        location="sypialnia";
        adapter.add(msServant, new Identity(name, category));
        registerDevice(category, name, location, "detektor ruchu w sypialni");
    }

    public void execute(String[] args)
    {
        int port=10000;
        if(args.length>=1){
            port=Integer.parseInt(args[0]);
        }
        int status = 0;
        Communicator communicator = null;

        try	{
            communicator = Util.initialize(args);
            String serverString=String.format("tcp -h 127.0.0.2 -p %d -z : udp -h 127.0.0.2 -p %d -z", port, port);
            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter"+port, serverString);

            DiscoverImp discoverServant = new DiscoverImp(devices);

            adapter.add(discoverServant, new Identity("discover", "discover"));

            setupDevices(adapter);
            adapter.activate();

            System.out.println("Entering event processing loop...");
            communicator.waitForShutdown();

        }
        catch (Exception e) {
            System.err.println(e);
            status = 1;
        }
        if (communicator != null) {
            try {
                communicator.destroy();
            }
            catch (Exception e) {
                System.err.println(e);
                status = 1;
            }
        }
        System.exit(status);
    }


    public static void main(String[] args)
    {
        Serwer app = new Serwer();
        app.execute(args);
    }

}
