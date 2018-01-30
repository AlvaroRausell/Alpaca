package Hack;


import org.knallgrau.utils.textcat.FingerPrint;
import org.knallgrau.utils.textcat.TextCategorizer;

import java.io.*;
import java.util.ArrayList;

public class Classifier {
    ArrayList<FingerPrint> fps;
    public Classifier(){
        fps = new ArrayList<>();
    }

    public void guess(String text){
    TextCategorizer guesser = new TextCategorizer();
            guesser.setConfFile("config.conf");
    String category;
    category = guesser.categorize(text);
    }

    public void setFP(String text, int index){
        FingerPrint fp = new FingerPrint();
        fp.create(text.toLowerCase());
        try {
            FileOutputStream fos = new FileOutputStream("Slide" + index + ".lm");
            fos.write(fp.toString().getBytes());
            fos.close();
        }
        catch(Exception e) {
        }
        fps.add(fp);


    }


    public void createConfig() throws FileNotFoundException {
        int index= 0;
        PrintWriter  out = new PrintWriter("config.conf");
        for (FingerPrint fp : fps){

            out.println("Slide"+index+".lm"+"     "+"Slide_"+index);
            index++;
        }
        out.close();
    }
}
