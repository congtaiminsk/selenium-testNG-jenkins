package tests;

import common.ActionType;
import common.CommandType;
import common.ColumnSeq;
import common.VerifyType;
import helpers.LocatorHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;
import util.JExcelHelper;

import java.util.*;

public class SampleTest extends BasePage {

	@DataProvider(name="testcasePath")
	public Object[][] getValidLoginAccounts(){
		return new Object[][] {
				{"C:\\demo\\employee.xls"}
		};
	}

	@Test(dataProvider="testcasePath")
	public void tc_0001(String testcasePath) throws Exception {
		loadTestcaseAndExecute(testcasePath);
	}

	private void loadTestcaseAndExecute(String testcasePath) throws Exception {
		Map<Integer, List<String>> mapData = JExcelHelper.readJExcel(testcasePath);
		for (Map.Entry<Integer, List<String>> entry : mapData.entrySet()) {
			String cmdKw = entry.getValue().get(ColumnSeq.CMD_KW.getValue());
			String cmdType = entry.getValue().get(ColumnSeq.CMD_TYPE.getValue());
			String locatorValue = entry.getValue().get(ColumnSeq.LOCATOR_VALUE.getValue());
			By locatorType = LocatorHelpers.judgeLocatorBy(entry.getValue().get(ColumnSeq.LOCATOR_TYPE.getValue()), locatorValue);
			String argValue = entry.getValue().get(ColumnSeq.ARG_VALUE.getValue());
			wait = new WebDriverWait(driver, 10);
			handleActionType(entry, cmdKw, cmdType, locatorValue, locatorType, argValue);
			handleVerifyClause(cmdKw, cmdType);

		}
	}

	private void handleVerifyClause(String cmdKw, String cmdType) throws Exception {
		if (CommandType.VERIFY.getValue().equals(cmdType) && !cmdKw.equals("")) {
			VerifyType verifyType = VerifyType.get(cmdKw);
			switch (verifyType) {
				case VERIFY_TITLE:
					Assert.assertEquals(driver.getTitle(), "JavaScript Tutorial");
					break;
				default:
					// code block
					break;
			}
		}
	}

	private static void handleActionType(Map.Entry<Integer, List<String>> entry, String cmdKw, String cmdType, String locatorValue, By locatorType, String argValue) throws Exception {
		if (CommandType.ACTION.getValue().equals(cmdType) && !cmdKw.equals("")) {
			ActionType actionType = ActionType.get(cmdKw);
			switch (actionType) {
				case OPEN:
					driver.get(entry.getValue().get(ColumnSeq.ARG_VALUE.getValue()));
					break;
				case INPUT:
					wait.until(ExpectedConditions.presenceOfElementLocated(locatorType));
					driver.findElement(locatorType).clear();
					driver.findElement(locatorType).sendKeys(argValue);
				case CLICK:
					wait.until(ExpectedConditions.presenceOfElementLocated(locatorType));
					driver.findElement(By.xpath(locatorValue)).click();
				default:
					// code block
					break;
			}
		}
	}
}

