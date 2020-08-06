package com.itheima.exception12;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Zi extends Fu {
    public void show()  {
        SimpleDateFormat sdf = new SimpleDateFormat();
        try {
            sdf.parse("");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
