package com.techelevator.filereader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/*
    This class should contain any and all details of access to the log file
 */
public class LogFileWriter {
    File file = new File("Log.txt");

    private void writeLog(String auditMessage) {
        try (
                // append argument for filewriter allows it to persist and only makes it if not there
            FileWriter filewriter = new FileWriter(file,true);
            PrintWriter printWriter = new PrintWriter(filewriter);){
            LocalDateTime now = LocalDateTime.now();
            //date format wanted in same pattern
            String writer = now.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"));
           printWriter.println(writer + " " + auditMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moneyAdded(int amountToAdd, float currentAccountBalance) {
        writeLog("ADD MONEY" + "$" + amountToAdd + currentAccountBalance);


    }
    public void givingChange(float amountToReturn, float currentAccountBalance) {
        writeLog("GIVE CHANGE" + "$" + String.format("%.2f", amountToReturn)+"   " + String.format("%.2f",currentAccountBalance));
    }
    public void itemBought(String itemName, float priceCombined, int quantityAdded, String productCode, float currentAccountBalance) {
        writeLog("" + quantityAdded + itemName + productCode +String.format("%.2f",priceCombined)+"   " +String.format("%.2f", currentAccountBalance));
    }
    }

