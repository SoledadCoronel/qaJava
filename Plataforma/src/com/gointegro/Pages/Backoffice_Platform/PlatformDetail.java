package com.gointegro.Pages.Backoffice_Platform;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gointegro.Helpers.ConfigElementsBO;
import com.gointegro.Pages.Base.PageBase;

public class PlatformDetail extends PageBase{
	
	/**
	 * Si son un asco pero lo necesito para el assert de la creacion y hasta que lo arreglen...
	 */
	
	@FindBy(xpath = "//div[@id='account']/div[2]/a")
	private WebElement account;
	
	@FindBy(xpath = "//div[@id='name']/div[2]")
	private WebElement platformname;
	
	@FindBy(xpath = "//div[@id=image-max-size]/div[2]")
	private WebElement imagemaxsize;
	
	@FindBy(xpath = "//div[@id='content']/div[6]/div[2]/a")
	private WebElement website;
	
	@FindBy(xpath = "//div[@id='content']/div[7]/div")
	private WebElement storage;
	
	@FindBy(xpath = "//div[@id='content']/div[8]/div")
	private WebElement industry;
	
	@FindBy(xpath = "//div[@id='content']/div[9]/div")
	private WebElement usersRange;
	
	@FindBy(xpath = "//div[@id='content']/div[10]/div")
	private WebElement mobileactivationcode;
	
	@FindBy(xpath = "//div[@id='content']/div[11]/div")
	private WebElement timezone;
	
	@FindBy(xpath = "//div[@id='content']/div[12]/div/span")
	private WebElement disableplatform;
	
	@FindBy(xpath = "//div[@id='content']/div[13]/div/span")
	private WebElement userVisibility;
	
	@FindBy(xpath = "//div[@id='content']/div[14]/div/span")
	private WebElement socialEnabled;
	
	@FindBy(xpath = "//div[@id='content']/div[15]/div")
	private WebElement googleanalytics;
	
	@FindBy(xpath = "//div[@id='content']/div[16]/div/span")
	private WebElement defaultrole;
	
	@FindBy(xpath = "//div[@id='content']/div[17]/div/span")
	private WebElement defaultlang;
	
	@FindBy(xpath = "//div[@id='content']/div[18]/div/span")
	private WebElement benefitsenabled;
	
	@FindBy(xpath = "//div[@id='content']/div[19]/div/span")
	private WebElement userstype;
	
	@FindBy(xpath = "//div[@id='login-type']/div[2]")
	private WebElement logintype;
	
	@FindBy(xpath = "//div[@id='user-field']/div[2]")
	private WebElement userfield;
	
	@FindBy(xpath = "//div[@id='recover-password']/div[2]/span")
	private WebElement recoverpassword;
	
	@FindBy(xpath = "//div[@id='content']/div[24]/div/span")
	private WebElement registration;
	
	@FindBy(xpath = "//div[@id='uses-htmlSignUp']/div[2]/p")
	private WebElement useshtmlSignUp;
	
	@FindBy(xpath = "//div[@id='uses-birthdate']/div[2]/span")
	private WebElement usesBirthdate;
	
	@FindBy(xpath = "//div[@id='uses-card']/div[2]/span")
	private WebElement usescard;
	
	@FindBy(xpath = "//div[@id='card-type']/div[2]")
	private WebElement cardtype;
	
	@FindBy(xpath = "//div[@id='uses-gender']/div[2]/span")
	private WebElement usesgender;
	
	@FindBy(xpath = "//div[@id='content']/div[30]/div")
	private WebElement verification;
	
	@FindBy(xpath = "//div[@id='content']/div[31]/div/span")
	private WebElement uniquefield;
	
	@FindBy(xpath = "//div[@id='content']/div[32]/div/span")
	private WebElement showusersmail;
	
	//TODO

	/**
	 * Constructor
	 * 
	 * @param driver
	 */
	public PlatformDetail(WebDriver driver) {
		super(driver);
		URL = ConfigElementsBO.getUrlBackoffice()+"/account/"+ConfigElementsBO.getAccountId()+"/platform/"+ConfigElementsBO.getPlatformId()
				+"/view";
	}

}
