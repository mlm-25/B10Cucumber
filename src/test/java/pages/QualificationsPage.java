package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class QualificationsPage extends CommonMethods {

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[3]/div[1]/div[3]/div[2]/form[1]/p[1]/input[1]")
    public WebElement addWorkExperienceAD;

    @FindBy (xpath = "//input[@id = 'addWorkExperience']")
    public WebElement addWorkExperienceX;

    @FindBy(id = "addWorkExperience")
    public WebElement addWorkExperienceID;

    @FindBy(xpath = "(//input[@value= 'Add'])[1]")
    public WebElement addWorkExperienceVX;

    @FindBy(css = "input#addWorkExperience")
    public WebElement addWorkExperienceCSS;

    @FindBy (css = "input#experience_employer")
    public WebElement companyWorkExperience;

    @FindBy (css = "input#experience_jobtitle")
    public WebElement jobTitleWorkExperience;

    @FindBy (xpath = "//textarea[@id = 'experience_comments']")
    public WebElement commentWorkExperience;

    @FindBy (className = "ui-datepicker-trigger")
    public WebElement fromCalender;

    @FindBy (xpath = "//select[@class = 'ui-datepicker-month']")
    public WebElement fromMonth;

    @FindBy (xpath = "//table[@class = 'ui-datepicker-calendar']/tbody/tr/td")
    public List<WebElement> fromDays;

    @FindBy (xpath = "(//img[@class = 'ui-datepicker-trigger'])[2]")
    public WebElement toCalendar;

    @FindBy(xpath = "//select[@class = 'ui-datepicker-month']")
    public WebElement toMonths;

    @FindBy (xpath = "//table[@class = 'ui-datepicker-calendar']/tbody/tr/td")
    public List<WebElement> toDays;

    @FindBy(xpath = "//input[@id = 'btnWorkExpSave']")
    public WebElement saveBtnWorkExperience;

    @FindBy(xpath = "//input[@id='addSkill']")
    public WebElement skillsAdd;

    @FindBy (xpath = "//input[@id='addEducation']")
    public WebElement educationAdd;

    @FindBy(xpath = "//input[@id='addLanguage']")
    public WebElement languagesAdd;

    @FindBy (id = "addLicense")
    public WebElement licenseAdd;

    @FindBy(id = "btnAddAttachment")
    public WebElement attachmentsAdd;

    public QualificationsPage(){
        PageFactory.initElements(driver, this);
    }


}
