package util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Sample {
    public String name;
    public List<Double> data=new ArrayList<>();

    public void write(PrintWriter pw) {
        pw.printf("%s\n",name);
        for(int i=0; i<data.size(); i++){
            pw.printf(Locale.US, "%f\n",data.get(i));
        }
    }

    public void writeToFile(String name) throws IOException {
        FileWriter fileWriter = new FileWriter(name);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        write(printWriter);
        printWriter.close();
    }
}
