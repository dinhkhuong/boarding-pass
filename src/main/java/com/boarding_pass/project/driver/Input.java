package com.boarding_pass.project.driver;

import java.util.*;

class Input
{
    private String name, email, destination;
    private long phoneNumber;
    private char gender;
    private int age, month, day, hour;

    Scanner scan = new Scanner(System.in);

    public Input() {
        this.assignValues();
    }

    private void assignValues() {
        name();
    }

    private void name() {
        System.out.println("Please enter your Name: ");
        this.name = inputString();
        email();
    }

    private void email() {
        System.out.println("Please enter your Email: ");
        email = inputString();
        phoneNumber();
    }

    private void phoneNumber() {
        System.out.println("Please enter your Phone Number: ");
        long maxPhone = (long) Math.pow(10, 10) - 1;
        phoneNumber = inputLong(0, maxPhone);
        gender();
    }

    private void gender() {
        System.out.println("Please enter your Gender: ");
        gender = inputString().toUpperCase().charAt(0);
        System.out.println("Please enter your Age: ");
        age = (int)inputLong(0, Integer.MAX_VALUE);
        travel();
    }

    private void travel() {
        System.out.println("Please enter the month in which you wish to travel: ");
        month = (int)inputLong(1, 12);
        int maxDay = daysOfTheMonth(month);
        day(maxDay);
    }

    private void day(int maxDay) {
        System.out.println("Please enter the day of the month on which you wish to travel: ");
        day = (int)inputLong(1, maxDay);
        destination();
    }

    private void destination() {
        System.out.println("Please enter your Destination: ");
        destination = inputString();
        hour();
    }

    private void hour() {
        System.out.println("Please enter the hour on which you wish to depart: ");
        hour = (int)inputLong(0, 23);
    }

    private String inputString()
    {
        String s = "Not initialized";
        try
        {
            s = scan.nextLine();
        }
        catch(NoSuchElementException e)
        {
            System.out.println("NoSuchElementException");
        }
        catch(IllegalStateException e)
        {
            System.out.println("IllegalStateException");
        }
        catch(Exception e)
        {
            System.out.println("Generic Exception");
        }
        return s;
    }

    private long inputLong(long min, long max)
    {
        long l = -1;
        boolean isInvalid = true;
        while(isInvalid)
        {
            try
            {
                l = scan.nextLong();
                scan.nextLine();
                if(l >= min && l <= max)
                {
                    isInvalid = false;
                }
                else
                {
                    System.out.println("Please enter a number between " + min + " and " + max);
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("InputMismatchException");
            }
            catch(NoSuchElementException e)
            {
                System.out.println("NoSuchElementException");
            }
            catch(IllegalStateException e)
            {
                System.out.println("IllegalStateException");
            }
            catch(Exception e)
            {
                System.out.println("Generic Exception");
            }
        }
        return l;
    }

    private int daysOfTheMonth(int month)
    {
        if(month == 9 || month == 4 || month == 6 || month == 11)
        {
            return 30;
        }
        else if(month == 2)
        {
            return 28;
        }
        else
        {
            return 31;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "Input{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", destination='" + destination + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", gender=" + gender +
                ", age=" + age +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                '}';
    }
}

