package util;

import java.util.Random;

public class WordGenerator {
    static Random rand = new Random();
    public static String nextWord(){
        int len=rand.nextInt(3,12);
        StringBuilder b = new StringBuilder(len);
        for(int i=0; i<len; i++){
            int w=rand.nextInt(0,26);
            if(i==0){
                b.append((char)('A'+w));
            }
            else{
                b.append((char)('a'+w));
            }
        }
        return b.toString();
    }
}
