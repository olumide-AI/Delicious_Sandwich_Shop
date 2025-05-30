package com.delicioussandwich.repository;

import com.delicioussandwich.logic.Receipt;
import com.delicioussandwich.model.order.Order;
import com.delicioussandwich.ui.AnsiColor;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Responsible for persisting receipts to the file system.
 */
public class ReceiptFile {
    //Folder name where we will store all receipt files
    private static final String RECEIPT_FOLDER = "receipts";

    public static void saveReceiptToFile(Order order){
        try{
            //Ensures the receipt folder exits, good for people that might want to run code for the first time
            //on their PC, they don't have to have a folder local
            Files.createDirectories(Path.of(RECEIPT_FOLDER));

            //Generate a timestamp style receipt name
            String receiptDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));

            // build the overall file name for receipt
            String receiptFileName = RECEIPT_FOLDER + "/" + receiptDateTime + ".txt";

            //Generate the receipt text into file
            String receiptInfo = Receipt.generateReceipt(order);
            FileWriter fileWriter = new FileWriter(receiptFileName);
            fileWriter.write(receiptInfo);
            fileWriter.close();

            //Prompt to let user know that receipt has been saved
            System.out.println(AnsiColor.ANSI_GREEN +"Receipt saved to: " + receiptFileName +AnsiColor.ANSI_RESET);
        }
        //Catch any file writing exception
        catch (IOException e){
            System.out.println("File saving error");
        }
    }
}
