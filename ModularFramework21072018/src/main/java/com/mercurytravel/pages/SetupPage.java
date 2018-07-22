package com.mercurytravel.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.contracts.MouseOperation;
import commonLibs.implementation.AlertControl;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControls;
import commonLibs.implementation.MouseControls;

public class SetupPage {

	public ElementControls elementControl;

	public MouseOperation mouseOperation;

	public DropdownControl dropdownControl;

	public AlertControl alertControl;

	public SetupPage(WebDriver driver) {

		elementControl = new ElementControls();
		mouseOperation = new MouseControls(driver);

		dropdownControl = new DropdownControl();

		alertControl = new AlertControl(driver);
	}

}
