package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriver {

	// To read from a file
	private InputStream fileReader;

	// To write into a file
	private OutputStream fileWriter;

	// Creating a workbook
	private Workbook excelWorkbook;

	// Default Name for a file
	private String excelFilename;

	// filename - Complete path including filename
	public void createExcelWorkbook(String filename) throws Exception {

		// Removing white spaces from the end
		filename = filename.trim();

		// Putting a empty check
		if (filename.isEmpty()) {
			throw new Exception("Invalid file name..");
		}

		File file = new File(filename);

		if (file.exists()) {
			throw new Exception("File already exists");
		}

		if (filename.endsWith("xlsx")) {

			excelWorkbook = new XSSFWorkbook();

		} else if (filename.endsWith("xls")) {
			excelWorkbook = new HSSFWorkbook();
		} else {
			throw new Exception("Invalid File Extension...");
		}

		// Creating a output stream with mentioned filename to be written in
		// workbook
		fileWriter = new FileOutputStream(filename);

		// Writing to a workbook
		excelWorkbook.write(fileWriter);

		// Closing output stream
		fileWriter.close();

		// Closing created file
		excelWorkbook.close();

	}

	// ----------------------------------------------------------------------------

	public void openExcelWorkbook(String filename) throws Exception {
		filename = filename.trim();

		if (filename.isEmpty()) {
			throw new Exception("File Name not specified");
		}

		if (!(new File(filename)).exists()) {
			throw new Exception("File doesnot exist.. ");
		}

		// Reading data from an excel sheet
		fileReader = new FileInputStream(filename);

		// Assigning sheet name to a global variable
		excelFilename = filename;

		// Representing or converting raw data read from an excel into excel
		// workbook format
		excelWorkbook = WorkbookFactory.create(fileReader);
	}

	// ----------------------------------------------------------------------------

	public void save() throws Exception {
		fileWriter = new FileOutputStream(excelFilename);
		excelWorkbook.write(fileWriter);

		fileWriter.close();
	}

	// ----------------------------------------------------------------------------

	public void saveAs(String newFilename) throws Exception {
		newFilename = newFilename.trim();
		if (newFilename.isEmpty()) {
			throw new Exception("File name does not exists");
		}

		if ((new File(newFilename)).exists()) {
			throw new Exception("File already exists");
		}

		fileWriter = new FileOutputStream(newFilename);
		excelWorkbook.write(fileWriter);

		fileWriter.close();

	}
	// ----------------------------------------------------------------------------

	public void close() throws Exception {
		excelWorkbook.close();
		fileReader.close();
	}
	// ----------------------------------------------------------------------------

	public void createSheet(String sSheetName) throws Exception {

		sSheetName = sSheetName.trim();

		if (sSheetName.isEmpty()) {
			throw new Exception("Sheet name not specified..");
		}

		Sheet oSheet;

		oSheet = excelWorkbook.getSheet(sSheetName);

		if (oSheet != null) {
			throw new Exception("Sheet Already exist...");
		}

		excelWorkbook.createSheet(sSheetName);
	}
	// ----------------------------------------------------------------------------

	public int getRowCountoFSheet(String sSheetName) throws Exception {
		sSheetName = sSheetName.trim();

		if (sSheetName.isEmpty()) {
			throw new Exception("Sheet name not specified..");
		}

		Sheet oSheet;

		oSheet = excelWorkbook.getSheet(sSheetName);

		if (oSheet == null) {
			throw new Exception("Sheet doesnot exist...");
		}

		return oSheet.getLastRowNum();
	}
	// ----------------------------------------------------------------------------

	public int getCellCount(String sSheetName, int iRow) throws Exception {
		sSheetName = sSheetName.trim();

		if (sSheetName.isEmpty()) {
			throw new Exception("Sheet name not specified..");
		}

		Sheet oSheet;

		oSheet = excelWorkbook.getSheet(sSheetName);

		if (oSheet == null) {
			throw new Exception("Sheet doesnot exist...");
		}

		if (iRow < 1) {
			throw new Exception("Row Index start from 1");
		}

		Row oRow;

		oRow = oSheet.getRow(iRow - 1);
		if (oRow == null) {
			return 0;
		} else {
			return oRow.getLastCellNum();
		}

	}
	// ----------------------------------------------------------------------------

	public String getCellData(String sSheetName, int iRow, int iCell) throws Exception {

		sSheetName = sSheetName.trim();

		if (sSheetName.isEmpty()) {
			throw new Exception("Sheet name not specified..");
		}

		Sheet oSheet;

		oSheet = excelWorkbook.getSheet(sSheetName);

		if (oSheet == null) {
			throw new Exception("Sheet doesnot exist...");
		}

		if (iRow < 1 || iCell < 1) {
			throw new Exception("Row and cell Index start from 1");
		}

		Row oRow;

		oRow = oSheet.getRow(iRow - 1);
		if (oRow == null) {
			return "";
		}

		Cell oCell;

		oCell = oRow.getCell(iCell - 1);

		if (oCell == null) {
			return "";
		} else {
			if (oCell.getCellTypeEnum() == CellType.NUMERIC) {
				return String.valueOf(oCell.getNumericCellValue());
			} else {
				return oCell.getStringCellValue();
			}
		}

	}

	// ----------------------------------------------------------------------------

	public void setCellData(String sSheetName, int iRow, int iCell, String sValue) throws Exception {

		sSheetName = sSheetName.trim();

		if (sSheetName.isEmpty()) {
			throw new Exception("Sheet name not specified..");
		}

		Sheet oSheet;

		oSheet = excelWorkbook.getSheet(sSheetName);

		if (oSheet == null) {
			throw new Exception("Sheet doesnot exist...");
		}

		if (iRow < 1 || iCell < 1) {
			throw new Exception("Row and cell Index start from 1");
		}

		Row oRow;

		oRow = oSheet.getRow(iRow - 1);
		if (oRow == null) {
			oSheet.createRow(iRow - 1);
			oRow = oSheet.getRow(iRow - 1);
		}

		Cell oCell;

		oCell = oRow.getCell(iCell - 1);

		if (oCell == null) {
			oRow.createCell(iCell - 1);
			oCell = oRow.getCell(iCell - 1);
		}
		oCell.setCellValue(sValue);

	}

}
