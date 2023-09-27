package com.cgi.li.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelFileUtility {
    private File file;
    private FileInputStream fileinputstream;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private FileOutputStream fileoutputstream;

    public ExcelFileUtility()
    {
        file=null;
        fileinputstream=null;
        workbook = null;
        fileoutputstream=null;
        sheet=null;

    }

    public  void open_Excelfile(String filepath) throws IOException {
        file= new File(filepath);
        fileinputstream = new FileInputStream(file);
         workbook = new XSSFWorkbook(fileinputstream);
    }

    //open Excel Sheet

    public  void open_excel_Sheet(String Sheetname)
    {

        sheet = workbook.getSheet(Sheetname);
    }

    //Read cell value
    public String getCellalue(int rowindex, int colindex)
    {
        DataFormatter df = new DataFormatter();
        String value = df.formatCellValue(sheet.getRow(rowindex).getCell(colindex));
        return (value);
    }

    //Write Data into Excel
    public void setCellValue(int rowindex,int colindex, String Value)
    {
        try {
            sheet.getRow(rowindex).createCell(colindex).setCellValue(Value);
            sheet.autoSizeColumn(colindex);
        }
        catch (NullPointerException ex)
        {
            sheet.createRow(rowindex).createCell(colindex).setCellValue(colindex);
            sheet.autoSizeColumn(colindex);
        }

    }

    //Close Excel
    public void Save_And_Close_Excel() throws IOException {
        workbook.write(fileoutputstream);
        workbook.close();
        fileoutputstream.close();
        fileinputstream.close();

    }



}
