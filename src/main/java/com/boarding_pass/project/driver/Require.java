package com.boarding_pass.project.driver;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class Require {
    HashMap<String, Integer> duration = new HashMap<String, Integer>();
    Calendar time = Calendar.getInstance();

    {
        duration.put("Alabama", 54);
        duration.put("Alaska", 449);
        duration.put("Arizona", 181);
        duration.put("Arkansas", 106);
        duration.put("California", 273);
        duration.put("Colorado", 161);
        duration.put("Connecticut", 108);
        duration.put("Delaware", 89);
        duration.put("Florida", 66);
        duration.put("Geogia", 20);
        duration.put("Hawaii", 549);
        duration.put("Idaho", 242);
        duration.put("Illinois", 76);
        duration.put("Indiana", 66);
        duration.put("Iowa", 105);
        duration.put("Kansas", 101);
        duration.put("Kentucky", 43);
        duration.put("Louisiana", 72);
        duration.put("Maine", 162);
        duration.put("Maryland", 79);
        duration.put("Massachusetts", 117);
        duration.put("Michigan", 92);
        duration.put("Minnesota", 146);
        duration.put("Mississippi", 51);
        duration.put("Missouri", 84);
        duration.put("Montana", 220);
        duration.put("Nebraska", 140);
        duration.put("Nevada", 252);
        duration.put("New Hampshire", 123);
        duration.put("New Jersey", 99);
        duration.put("New Mexico", 168);
        duration.put("New York", 101);
        duration.put("North Carolina", 47);
        duration.put("North Dakota", 179);
        duration.put("Ohio", 69);
        duration.put("Oklahoma", 102);
        duration.put("Oregon", 280);
        duration.put("Pennsylvania", 86);
        duration.put("Rhode Island", 154);
        duration.put("South Carolina", 35);
        duration.put("Tennessee", 35);
        duration.put("Texas", 112);
        duration.put("Utah", 213);
        duration.put("Vermont", 144);
        duration.put("Virginia", 65);
        duration.put("Washington", 285);
        duration.put("West Virginia", 58);
        duration.put("Wisconsin", 163);
        duration.put("Wyoming", 196);
    }


    public Require(String name, String email, String destination, long phoneNo, char gender, int age,int month, int day, int hour){
        this.time.set(2021,month,day,hour,0);
    }

    public Calendar eTA(String destination) {
        try{
            this.time.add(Calendar.MINUTE,duration.get(destination));
        }catch (Exception e){
            e.printStackTrace();
        }


        return time;
    }


    public int priceCal(int age,char gender, String destination ){
        int deduction = 0;
        if(gender=='F'||gender=='f'){
            deduction +=25;
        }
        if (age<=12){
            deduction+= 50;
        }else if (age>=60){
            deduction+=60;
        }
        return duration.get(destination)*deduction/100;

    }
    public void putInFile(String name, String email, String destination, long phoneNo, char gender, int age,int month, int day, int hour) {
        String fileName = "data.txt";
        Path path = Paths.get(fileName);
        Charset charset = StandardCharsets.UTF_8;
        try{
            Files.deleteIfExists(path);
            Files.createFile(path);
            Files.write(path, name.getBytes(charset));
            Files.write(path, email.getBytes(charset));
            Files.write(path, destination.getBytes(charset));
            Files.write(path, String.valueOf(phoneNo).getBytes(charset));
            Files.write(path, String.valueOf(gender).getBytes(charset));
            Files.write(path, String.valueOf(age).getBytes());
            Files.write(path, String.valueOf(month).getBytes());
            Files.write(path, String.valueOf(day).getBytes());
            Files.write(path, String.valueOf(hour).getBytes());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
