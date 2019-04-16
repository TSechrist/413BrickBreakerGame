package dev.game.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Util {

    public static String loadFileAsString(String path)
    {
        StringBuilder builder = new StringBuilder();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath() + path));
            String input;
            while((input = br.readLine()) != null)
            {
                builder.append(input + "\n");
            }
            br.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        return builder.toString();

    }

    public static int parseInt(String num)
    {
        try{
            return Integer.parseInt(num);
        }
        catch(Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

}
