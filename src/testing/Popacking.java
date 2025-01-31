package testing;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import jxl.Sheet;
import jxl.Workbook;

public class Popacking {

	public static void main(String[] args) throws Exception {

		Thread.sleep(500);
		Robot r = new Robot();

		File f = new File("C:\\Users\\ganchait1\\Desktop\\Automation1.xls");
		Workbook rwb = Workbook.getWorkbook(f);
		Sheet rsh = rwb.getSheet(0);
		int nour = rsh.getRows();
		System.out.println(rsh);

		for (int i = 1; i < nour; i++) {
			String iots = rsh.getCell(0, i).getContents();
			StringSelection selection = new StringSelection(iots);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
			Thread.sleep(1000);
			r.mouseMove(502, 225);
			r.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
			r.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(800);

		}

	}
}
