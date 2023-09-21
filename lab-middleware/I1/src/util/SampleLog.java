package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SampleLog {
    static Map<String, Sample> log=new HashMap<>();

    public static void addData(String name, double data){
        var sample=log.get(name);
        if(sample==null){
            sample=new Sample();
            sample.name=name;
        }
        sample.data.add(data);
        log.put(name, sample);
    }

    public static Sample get(String name){
        return log.get(name);
    }

    public static Set<String> getSampleNames(){
        return log.keySet();
    }

}
