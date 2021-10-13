package com.boarding_pass.project.driver;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;

public class Require {
    Input input;
    int boardNumber;
    {
        Random r = new Random( System.currentTimeMillis() );
        boardNumber = 10000 + r.nextInt(10000);
    }

    public final static HashMap<String, Integer> duration = new HashMap<String, Integer>();

    public Calendar getTime() {
        return time;
    }

    Calendar time = Calendar.getInstance();

    //the hash map key is destination, and
    //the hash map value is the minutes it takes to travel there, also is the full price
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



    public Require( Input toInput){
        input = toInput;
        time.set(2021,input.getMonth()-1,input.getDay(),input.getHour(),0);
    }

    public Calendar eTA() {
        if(duration.containsKey(input.getDestination())) {
            try {
                this.time.add(Calendar.MINUTE, duration.get(input.getDestination()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else System.out.println("eTA: the destination not match");

        return time;
    }

    //for simplicity, the full price is the minutes it takes to travel to the place
    public int priceCal(){
        int deduction = 0;
        if(input.getGender()=='F'|| input.getGender()=='f'){
            deduction +=25;
        }
        if (input.getAge()<=12){
            deduction+= 50;
        }else if (input.getAge()>=60){
            deduction+=60;
        }
        System.out.println("the full price is: $"+ duration.get(input.getDestination()));
        System.out.println("your discount is: "+ deduction + " %");
        return duration.get(input.getDestination())*(100-deduction)/100;

    }
    public void putInFile() {
        String fileName = "data.txt";
        Path path = Paths.get(fileName);
        Charset charset = StandardCharsets.UTF_8;
        try{
            Files.deleteIfExists(path);
            Files.createFile(path);
            Files.write(path, input.getName().getBytes(charset), StandardOpenOption.APPEND);
            Files.write(path, (", " + input.getEmail()).getBytes(charset), StandardOpenOption.APPEND);
            Files.write(path, (", " + input.getDestination()).getBytes(charset), StandardOpenOption.APPEND);
            Files.write(path, (", " + String.valueOf(input.getPhoneNumber())).getBytes(charset), StandardOpenOption.APPEND);
            Files.write(path, (", " + String.valueOf(input.getGender())).getBytes(charset), StandardOpenOption.APPEND);
            Files.write(path, (", " + String.valueOf(input.getAge())).getBytes(), StandardOpenOption.APPEND);
            Files.write(path, (", " + String.valueOf(input.getMonth())).getBytes(), StandardOpenOption.APPEND);
            Files.write(path, (", " + String.valueOf(input.getDay())).getBytes(), StandardOpenOption.APPEND);
            Files.write(path, (", " + String.valueOf(input.getHour())).getBytes(), StandardOpenOption.APPEND);
            Files.write(path, (", " + String.valueOf(boardNumber)).getBytes(charset), StandardOpenOption.APPEND);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public int getBoardNumber() {
        return boardNumber;
    }
}
