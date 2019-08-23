package com.ydh.offer;

import java.io.*;

public class FileUtil {




    public static void main(String[] args) {

        try {
            // read file content from file
            StringBuffer sb= new StringBuffer("");
            String path = "/Users/daniel/Desktop/11.docx";
            FileReader reader = new FileReader(path);

            BufferedReader br = new BufferedReader(reader);
            String str = null;
            int i = 0;

            while((str = br.readLine()) != null) {

                sb.append(str+"/n");
                //i++;
                System.out.println(str);

            }
            br.close();
            reader.close();


            // write string to file
            FileWriter writer = new FileWriter("/Users/daniel/Desktop/111.docx");
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(sb.toString());

            bw.close();

            writer.close();

        }

        catch(FileNotFoundException e) {

            e.printStackTrace();

        }

        catch(IOException e) {

            e.printStackTrace();

        }



    }
}
