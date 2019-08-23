package com.ydh.test;

import java.util.ArrayList;
import java.util.List;

public class StringProcess {

    public static void main(String[] args) {

        String s = "DEBUG:flask.app:hello------- 1.097181797027588 \n" +
                "DEBUG:flask.app:hello------- 1.098595142364502 \n" +
                "DEBUG:flask.app:hello------- 1.1884076595306396 \n" +
                "DEBUG:flask.app:hello------- 0.697624921798706 \n" +
                "DEBUG:flask.app:hello------- 1.0119354724884033 \n" +
                "DEBUG:flask.app:hello------- 1.1231603622436523 \n" +
                "DEBUG:flask.app:hello------- 1.0768043994903564 \n" +
                "DEBUG:flask.app:hello------- 1.0866825580596924 \n" +
                "DEBUG:flask.app:hello------- 1.0419833660125732 \n" +
                "DEBUG:flask.app:hello------- 1.0872385501861572 \n" +
                "DEBUG:flask.app:hello------- 1.0065279006958008 \n" +
                "DEBUG:flask.app:hello------- 1.0358617305755615 \n" +
                "DEBUG:flask.app:hello------- 1.0841660499572754 \n" +
                "DEBUG:flask.app:hello------- 0.9903404712677002 \n" +
                "DEBUG:flask.app:hello------- 1.3687324523925781 \n" +
                "DEBUG:flask.app:hello------- 1.3280069828033447 \n" +
                "DEBUG:flask.app:hello------- 1.315380573272705 \n" +
                "DEBUG:flask.app:hello------- 1.1788601875305176 \n" +
                "DEBUG:flask.app:hello------- 1.3574261665344238 \n" +
                "DEBUG:flask.app:hello------- 1.3521168231964111 \n" +
                "DEBUG:flask.app:hello------- 1.3837668895721436 ";

        String[] ss = s.split(" ");

        List<Float> list = new ArrayList<>();
        for (String temp : ss) {
            try {
                float f = Float.parseFloat(temp);
                list.add(f);
            } catch (NumberFormatException e) {
                continue;
            }
        }

        System.out.println(list.size());
        list.forEach(System.out::println);

        double dsum = 0.0;
        for (float f : list) {
            dsum += f;
        }
        double res = dsum / list.size();
        System.out.println(res);

    }
}
