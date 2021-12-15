package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class EmployeePersonalDetailsPage extends CommonMethods {

    @FindBy(xpath = "//h1[text() = 'Personal Details']")
    public WebElement employee;

    @FindBy(id = "btnSave")
    public WebElement editAndSaveBtn;

    @FindBy(id = "personal_txtLicenNo")
    public WebElement driversLicenseNumber;

    @FindBy(css = "input#personal_txtLicExpDate")
    public WebElement driversLicenseEx;

    @FindBy(xpath = "(//img[@class = 'ui-datepicker-trigger'])[1]")
    public WebElement driversLicenseNumberExpiration;

    @FindBy(xpath = "//select[@class = 'ui-datepicker-month']/option")
    public WebElement licenseMonth;

    @FindBy(xpath = "//select[@class = 'ui-datepicker-year']/option")
    public WebElement licenseYear;

    @FindBy(xpath = "//table[@class = 'ui-datepicker-calendar']/tbody")
    public WebElement licenseDay;

    @FindBy(id = "personal_txtNICNo")
    public WebElement ssn;

    @FindBy(id = "personal_txtSINNo")
    public WebElement sin;

    @FindBy(css = "input#personal_optGender_1")
    public WebElement male;

    @FindBy(css = "input#personal_optGender_2")
    public WebElement female;

    /*@FindBy(xpath = "//ul[@class = 'radio_list']/li")
    public WebElement gender;*/

    @FindBy(xpath = "//select[@id = 'personal_cmbMarital']/option")
    public WebElement maritalStatus;

    @FindBy(xpath = "//select[@id = 'personal_cmbNation']/option")
    public WebElement nations;

    /*@FindBy(xpath = "//img[@class = 'ui-datepicker-trigger'])[1]")
    public WebElement birthDateCalender;

    @FindBy(xpath = "//select[@class = 'ui-datepicker-month']")
    public WebElement birthDateMonth;

    @FindBy(xpath = "//select[@class = 'ui-datepicker-year']")
    public WebElement BirthDateYear;

    @FindBy(xpath = "//table[@class = 'ui-datepicker-calendar']/tbody")
    public WebElement BirthDateDay;*/

    @FindBy(css = "input#personal_DOB")
    public WebElement doB;

    @FindBy(id = "personal_txtEmpNickName")
    public WebElement nickName;

    @FindBy(id = "personal_txtMilitarySer")
    public WebElement military;

    @FindBy(id = "personal_chkSmokeFlag")
    public WebElement smokerCheckbox;

    @FindBy(xpath = "(//a[text() = 'Qualifications'])[2]")
    public WebElement qualificationsTab;

    @FindBy(xpath = "(//a[text() = 'Job'])[2]")
    public WebElement jobTab;



    public EmployeePersonalDetailsPage(){
        PageFactory.initElements(driver, this);
    }

}
