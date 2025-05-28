package com.delicioussandwich.repository;

import com.delicioussandwich.logic.Receipt;
import com.delicioussandwich.model.order.Order;

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
    private static final String RECEIPT_FOLDER = "receipts";

    public static void saveReceiptToFile(Order order){
        try{
            Files.createDirectories(Path.of(RECEIPT_FOLDER));
            String receiptDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String receiptFileName = RECEIPT_FOLDER + "/" + receiptDateTime + ".txt";

            String receiptInfo = Receipt.generateReceipt(order);
            FileWriter fileWriter = new FileWriter(receiptFileName);
            fileWriter.write(receiptInfo);
            fileWriter.close();

            System.out.println("Receipt saved to: " + receiptFileName);
        }
        catch (IOException e){
            System.out.println("File saving error");
        }
    }
}
