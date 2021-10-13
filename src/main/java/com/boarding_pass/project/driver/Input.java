package com.boarding_pass.project.driver;

import com.boarding_pass.project.entity.BoardingPass;
import com.boarding_pass.project.entity.BoardingPassDetails;
import com.boarding_pass.project.entity.User;
import com.boarding_pass.project.service.UserService;
import com.boarding_pass.project.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Input
{
    // Instance Variables
    private String name, email, destination;
    private long phoneNumber;
    private char gender;
    private int age, month, day, hour;
    private Date date;

    // Defined Objects to be passed to Main
    private BoardingPass boardingPass;
    private BoardingPassDetails boardingPassDetails;
    private User user;
    private UserService userService;

    // Declare Scanner
    Scanner scan;

    // Constructor sets up the Input Object
    public Input(HashMap<String, Integer> stops)
    {
        // Call constructors for defined objects
        user = new User();
        boardingPass = new BoardingPass();
        boardingPassDetails = new BoardingPassDetails();
        userService = new UserServiceImpl();

        // Prompt the user for input for all instance variables
        assignValues(stops);

        // Assign data collected from the user to the fields in the defined classes
        setUpObjects();
    }

    // assignValues calls every method that prompts the user for input and calls makeDate() to assemble the Date
    private void assignValues(HashMap<String, Integer> stops)
    {
        enterName();
        enterEmail();
        enterPhone();
        enterGender();
        enterAge();
        enterMonth();
        enterDay();
        enterDestination(stops);
        enterHour();
        makeDate();
    }

    // The enter methods ask the user for input and then scan using the input methods
    // The name of each enter method references the instance variable being accessed
    private void enterName()
    {
        System.out.println("Please enter your Name: ");
        name = inputString();
    }

    private void enterEmail()
    {
        System.out.println("Please enter your Email: ");
        email = inputString();
    }

    private void enterPhone()
    {
        System.out.println("Please enter your Phone Number: ");
        long maxPhone = (long) Math.pow(10, 10) - 1;
        phoneNumber = inputLong(0, maxPhone);
    }

    private void enterGender()
    {
        System.out.println("Please enter your Gender: ");
        gender = inputString().toUpperCase().charAt(0);
    }

    private void enterAge()
    {
        System.out.println("Please enter your Age: ");
        age = (int)inputLong(0, Integer.MAX_VALUE);
    }

    private void enterMonth()
    {
        System.out.println("Please enter the month in which you wish to travel: ");
        month = (int)inputLong(1, 12);
    }

    private void enterDay()
    {
        int maxDay = daysOfTheMonth(month);
        System.out.println("Please enter the day of the month on which you wish to travel: ");
        day = (int)inputLong(1, maxDay);
    }

    // daysOfTheMonth is a helper method for enterDay()
    // It returns the number of days expected in a given month
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

    private void enterDestination(HashMap<String, Integer> stops)
    {
        System.out.println("Please enter your Destination: ");
        //destination = inputDestination(stops);
        destination = inputString();
    }

    private void enterHour()
    {
        System.out.println("Please enter the hour on which you wish to depart: ");
        hour = (int)inputLong(0, 23);
    }

    // makeDate sets up the Date using the data stored in the instance variables
    private void makeDate()
    {
        String dash = "-";
        String sColon = ":";
        String dd = "" + day;
        String mm = "" + month;
        String yyyy = "2021";
        String hh = "";
        if(hour < 10)
        {
            hh += "0";
        }
        hh += hour;
        String min2 = "00";
        String ss = "00";
        String time = dd+dash+mm+dash+yyyy + " " + hh+sColon+min2+sColon+ss;

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        try
        {
            date = sdf.parse(time);
        }
        catch(ParseException e)
        {
            System.out.println("ParseException");
        }
    }

    // The input methods contain the code that use the scanner to take user input and handle exceptions
    // The name of the input method reference the data type that will be scanned for
    private String inputString()
    {
        scan = new Scanner(System.in);

        String s = "Not initialized";
        try
        {
            s = scan.nextLine();
        }
        catch(NoSuchElementException e) // catch NoSuchElementException if input is exhausted
        {
            System.out.println("NoSuchElementException");
            System.out.println("Please try to input again: ");
            s = inputString();
        }
        catch(IllegalStateException e) // catch IllegalStateException if scanner is closed
        {
            System.out.println("IllegalStateException");
            System.out.println("Please try to input again: ");
            s = inputString();
        }
        catch(Exception e) // catch generic exception
        {
            System.out.println("Generic Exception");
            System.out.println("Please try to input again: ");
            s = inputString();
        }
        return s;
    }

    // inputDestination is acts similarly to inputString, but uses stopCheck to check for valid Destination input
    private String inputDestination(HashMap<String, Integer> stops)
    {
        scan = new Scanner(System.in);

        String s = "Not initialized";
        try
        {
            s = scan.nextLine();
            stopCheck(stops, s);
        }
        catch(NoSuchElementException e) // catch NoSuchElementException if input is exhausted
        {
            System.out.println("NoSuchElementException");
            System.out.println("Please try to input again: ");
            s = inputDestination(stops);
        }
        catch(IllegalStateException e) // catch IllegalStateException if scanner is closed
        {
            System.out.println("IllegalStateException");
            System.out.println("Please try to input again: ");
            s = inputDestination(stops);
        }
        catch(Exception e) // catch generic exceptions thrown by rangeCheck
        {
            System.out.println("Unknown Destination");
            System.out.println("Please try to input again: ");
            s = inputDestination(stops);
        }
        return s;
    }

    // stopCheck is a helper method for inputDestination
    // It checks if the given Destination is among the existing Destinations in the HashMap
    // throws generic exception if it is not
    private void stopCheck(HashMap<String, Integer> stops, String s) throws Exception
    {
        if(!stops.containsKey(s))
        {
            throw new Exception();
        }
    }

    // inputLong takes two parameters to indicate the upper and lower limits allowed for the given input
    private long inputLong(long min, long max)
    {
        scan = new Scanner(System.in);

        long l = -1;
        try
        {
            l = scan.nextLong();
            rangeCheck(min, max, l);
        }
        catch(InputMismatchException e) // catch InputMismatchException if input is an incorrect type
        {
            System.out.println("InputMismatchException");
            System.out.println("Please try to input again: ");
            l = inputLong(min, max);
        }
        catch(NoSuchElementException e) // catch NoSuchElementException if input is exhausted
        {
            System.out.println("NoSuchElementException");
            System.out.println("Please try to input again: ");
            l = inputLong(min, max);
        }
        catch(IllegalStateException e) // catch IllegalStateException if scanner is closed
        {
            System.out.println("IllegalStateException");
            System.out.println("Please try to input again: ");
            l = inputLong(min, max);
        }
        catch(Exception e) // catch generic exceptions thrown by rangeCheck
        {
            System.out.println("Input is out of range.");
            System.out.println("Please try to input again: ");
            l = inputLong(min, max);
        }
        return l;
    }

    // rangeCheck is a helper method for inputLong()
    // It checks if the given number is within the allowed range and throws a generic exception if it is not
    private void rangeCheck(long min, long max, long l) throws Exception
    {
        if(l < min || l > max)
        {
            throw new Exception();
        }
    }

    // setUpObjects sends the data stored in the instance variables to the defined objects
    private void setUpObjects()
    {
        user.setName(name);
        user.setEmail(email);
        boardingPassDetails.setDestination(destination);
        user.setPhoneNumber(phoneNumber);
        user.setGender(gender);
        user.setAge(age);
        boardingPassDetails.setDepartureTime(date);
        boardingPass.setBoardingPassDetails(boardingPassDetails);
        //user.setBoardingPass(boardingPass);
        userService.addUser(user);
    }

    // Getters and Setters
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

    public BoardingPass getBoardingPass() {
        return boardingPass;
    }

    public void setBoardingPass(BoardingPass boardingPass) {
        this.boardingPass = boardingPass;
    }

    public BoardingPassDetails getBoardingPassDetails() {
        return boardingPassDetails;
    }

    public void setBoardingPassDetails(BoardingPassDetails boardingPassDetails) {
        this.boardingPassDetails = boardingPassDetails;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    // toString method
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
                ", boardingPass=" + boardingPass +
                ", boardingPassDetails=" + boardingPassDetails +
                ", user=" + user +
                ", date=" + date +
                '}';
    }
}
