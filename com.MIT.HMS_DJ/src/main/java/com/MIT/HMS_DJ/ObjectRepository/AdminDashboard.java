package com.MIT.HMS_DJ.ObjectRepository;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MIT.HMS_DJ.GenericUtility.FileUtility;

public class AdminDashboard {
	WebDriver driver;
	public FileUtility fileUtil=new FileUtility();
	
	public AdminDashboard(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	@FindBy(xpath = "//span[text()=' Doctors ']")
	private WebElement Doctors;
	
	@FindBy(xpath = "//span[text()=' Users ']")
	private WebElement  Users ;
	
	@FindBy(xpath = "//span[text()=' Patients ']")
	private WebElement Patients;
	
	@FindBy(xpath = "//span[text()=' Appointment History ']")
	private WebElement  AppointmentHistory ;
	
	@FindBy(xpath = "//span[text()=' Conatctus Queries ']")
	private WebElement  ConatctusQueries ;
	
	@FindBy(xpath = "//span[text()=' Doctor Session Logs ']")
	private WebElement  DoctorSessionLogs ;
	
	@FindBy(xpath = "//span[text()=' User Session Logs ']")
	private WebElement  UserSessionLogs ;
	
	@FindBy(xpath = "//span[text()=' Reports ']")
	private WebElement  Reports ;
	
	@FindBy(xpath = "//span[text()=' Pages ']")
	private WebElement  Pages ;
	
	@FindBy(xpath = "//span[text()=' Patient Search ']")
	private WebElement   PatientSearch  ;
	
	@FindBy(xpath = "//span[text()=' Add Doctor']")
	private WebElement   AddDoctor  ;
	 
	@FindBy(xpath = "//span[text()=' Doctor Specialization ']")
	private WebElement    DoctorSpecialization   ;
	
	@FindBy(xpath = "//span[text()=' Manage Doctors ']")
	private WebElement    ManageDoctors   ;
	
	@FindBy(xpath = "//span[text()=' Manage Patients ']")
	private WebElement    ManagePatients   ;
	
	@FindBy(xpath = "//span[text()=' Manage Users ']")
	private WebElement    ManageUsers   ;
	
	@FindBy(xpath = "//span[text()=' Unread Query ']")
	private WebElement UnreadQuery   ;
	
	@FindBy(xpath = "//span[text()=' Read Query ']")
	private WebElement ReadQuery   ;
	
	@FindBy(xpath = "//span[text()='B/w dates reports ']")
	private WebElement  Btwdatesreports   ;
	
	@FindBy(xpath = "//span[text()='About Us ']")
	private WebElement   AboutUs   ;
	
	@FindBy(xpath = "//span[text()='Cotnact Us ']")
	private WebElement   CotnactUs   ;

	@FindBy(xpath = "//span[@class='username']")
	private WebElement profileIcon;
	
	@FindBy(linkText = "Log Out")
	private WebElement logout;
	
		
	public void addDoctor()
	{
		Doctors.click();
		AddDoctor.click();
	}
	
	public void manageDoctors()
	{
		Doctors.click();
		ManageDoctors.click();
	}
	
	public void doctorSpecialization()
	{
		Doctors.click();
		DoctorSpecialization.click();
	}
	
	public void managePatients()
	{
		Patients.click();
		ManagePatients.click();
	}
	
	public void manageUsers()
	{
		Users.click();
		ManageUsers.click();
	}
	
	public void unreadQuery()
	{
		ConatctusQueries.click();
		UnreadQuery.click();
	}
	public void readQuery()
	{
		ConatctusQueries.click();
		ReadQuery.click();
	}
	
	public void reports()
	{
		Reports.click();
		Btwdatesreports.click();
	}
	
	public void AboutUs()
	{
		Pages.click();
		AboutUs.click();
	}
	
	public void ContactUs()
	{
		Pages.click();
		CotnactUs.click();
	}
	
	public void DoctorSessionLogs()
	{
		DoctorSessionLogs.click();		
	}
	
	public void UserSessionLogs()
	{
		UserSessionLogs.click();		
	}
	
	public void AppointmentHistory()
	{
		AppointmentHistory.click();		
	}
	
	public void PatientHistory()
	{
		PatientSearch.click();		
	}
	
	public void logout()
	{
		profileIcon.click();
		logout.click();
	}
	
	public WebElement getAddDoctor() {
		return AddDoctor;
	}

	public WebElement getDoctorSpecialization() {
		return DoctorSpecialization;
	}

	public WebElement getManageDoctors() {
		return ManageDoctors;
	}

	public WebElement getManagePatients() {
		return ManagePatients;
	}

	public WebElement getUnreadQuery() {
		return UnreadQuery;
	}

	public WebElement getReadQuery() {
		return ReadQuery;
	}

	public WebElement getBtwdatesreports() {
		return Btwdatesreports;
	}

	public WebElement getAboutUs() {
		return AboutUs;
	}

	public WebElement getCotnactUs() {
		return CotnactUs;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDoctors() {
		return Doctors;
	}

	public WebElement getUsers() {
		return Users;
	}

	public WebElement getPatients() {
		return Patients;
	}

	public WebElement getAppointmentHistory() {
		return AppointmentHistory;
	}

	public WebElement getConatctusQueries() {
		return ConatctusQueries;
	}

	public WebElement getDoctorSessionLogs() {
		return DoctorSessionLogs;
	}

	public WebElement getUserSessionLogs() {
		return UserSessionLogs;
	}

	public WebElement getReports() {
		return Reports;
	}

	public WebElement getPages() {
		return Pages;
	}

	public WebElement getPatientSearch() {
		return PatientSearch;
	}
	
	
	
}
