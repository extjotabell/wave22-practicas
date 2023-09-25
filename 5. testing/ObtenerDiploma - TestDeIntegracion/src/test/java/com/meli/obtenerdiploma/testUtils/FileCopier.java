package com.meli.obtenerdiploma.testUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopier  {
    // create coptData() method that copy data of file1 into file2
    public static void copyFiles(File inputFile, File outpulFile) throws Exception
    {
        // create instances of FileInputStream and FileOutputStream classes for file1 and file2
        FileInputStream inputStream = new FileInputStream(inputFile);
        FileOutputStream outputStream = new FileOutputStream(outpulFile);
        // use try-catch-finally block to read and write bytes data into file
        try {
            // declare variable for indexing
            int i;
            // use while loop with read() method of FileInputStream class to read bytes data from file1
            while ((i = inputStream.read()) != -1) {

                // use write() method of FileOutputStream class to write the byte data into file2
                outputStream.write(i);
            }
        }
        // catch block to handle exceptions
        catch(Exception e) {
            System.out.println("Error Found: "+e.getMessage());
        }
        // use finally to close instance of the FileInputStream and FileOutputStream classes
        finally {
            if (inputStream != null) {
                // use close() method of FileInputStream class to close the stream
                inputStream.close();
            }
            // use close() method of FileOutputStream class to close the stream
            if (outputStream != null) {
                outputStream.close();
            }
        }
        System.out.println("File Copied");
    }

}
