package testing;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import jxl.Sheet;
import jxl.Workbook;

public class excel {

	public static void main(String[] args) throws Exception, IOException {
		// ChromeDriver driver = new ChromeDriver();
		Robot r = new Robot();
		
		// driver.manage().window().maximize();
		// driver.get("https://www.the-qrcode-generator.com");

		File f = new File("C:\\Users\\ganchait1\\Desktop\\Automation1.xls");
		Workbook rwb = Workbook.getWorkbook(f);
		Sheet rsh = rwb.getSheet(0);
		int nour = rsh.getRows();
		System.out.println(rsh);

		for (int i = 1; i < nour; i++) {
			String iots = rsh.getCell(0, i).getContents();
			StringSelection selection = new StringSelection(iots);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(600);
			
		}

	}

}