package com.infigo.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.net.URISyntaxException;

public interface Browser {

    String pageloadwaittimer = "30000";

    String baseProdUrl = "https://app.iqabinet.com/";
    String baseDevUrl = "https://iqabinet-web.herokuapp.com/";
    //String baseDevUrl = "https://iqabinet-web-static-content.herokuapp.com//";

    public static String baseUrl = baseDevUrl;
    String resetpasswordusername="txt-username";
    String resetpasswordemail="txt-email";
    String resetpasswordfirstname="txt-firstname";
    String resetpasswordlastname="txt-lastname";
    
    String secretkey_dev="attachments/testidta_dev.iqab";
    String secretkey_alpha="attachments/testidta_dev.iqab";
    String validatebutton="btn-signup";
    String securityanswertext="txt-answer-1";
    String answersecurityquestionbutton="btn-signup";
    String newpasswordfield="txt-username";
    String confrimnewpassword="txt-email";
    String savebutton="btn-signup";
    
    String attachmment1 = "attachments/dropbox_no_folder.jpg";
    String attachmment2 = "attachments/create_new_institutions.jpg";
    String attachpdf ="attachments/ADP_iPayStatements_5577_Statements_2004-01-31_2.pdf";
    String seachdoc="attachments/chasecard.pdf";
    //attachment for deleting card having multiple user
    String attachment3="attachments/Aetna_EOB_2004-08-04.pdf";
    String attachment4="attachments/Aetna_EOB_2001-08-04.pdf";
    String attachment5="attachments/Aetna_EOB_2003-08-04.pdf";
    //attachments for move and linking
    String moveattachment1="attachments/Move1.png";
    String linkattachment1="attachments/Link1.png";
    
    
    String moveattachment2="attachments/Move2.png";
    String linkattachment2="attachments/Link2.png";
    
    String shareddocument="attachments/sharedcardfortiemline1.pdf";
    String shareddocument2="attachments/shared2.pdf";
    //Home Page fields by Id
    String signinbutton = "button-signup";
    String loginbutton = "button-signin";
    String loginbutton_2 = "button-login";
    String singupbutton="btn-register";
    String requestinvitebutton = "REQUEST INVITE";
    String watchdemobutton = "WATCH DEMO";
    String usernametxtfield = "txt-username";
    String homelink = "Home";
    String productlink = "Product";
    String companylink = "Company";
    String signuplink = "Sign up";
    //by css selector
    String iqabinetlogo = "img[alt=\"iQabinet\"]";
    //by id
    String loginemail = "email";
    String loginpassword = "password";
    String loginpopup = ".modal-body";
    //Personal Document fields
    //by id
    String personaldocumentbutton = "Personal Documents";
    String addbutton = "Add";
    String cancelcard="Cancel";
    String Account = "Accounts";
    String medicalrecords = "Medical Records";
    String summarybutton = "All";
    String actionlistbox="user-action-menu-link";
    String actionshare="Share";//by link text
    // Spring Wheel
    String spinningshweel = ".ng-scope>img";
    String deleteimage = ".delete>img";
    String cardid="card-icon";//by id
    String termandcondition=".tou";//by cssSelector
    //-Sahring ids
    String sharingpermission="checkbox-share-permission-0";
    String sharedcardcancelbutton="share-card-button-cancel";
    //---------------------------------------------Sharing cards
    String belongstoinputfield="ul.select2-choices";
    String sharingpopup1header="dialog-header-text";
    String sharingpopup1body="dialog-body-text";
    String sharingpopup2header="#share-card-header-text > span.ng-scope";
    String sharingpopup2body="#share-card-body-text-2 > b";
    String sharingpopup3body="#share-card-body-text-1 > b"; 
    String sharingpopup3email="personEmail";
    String sharingpopup2inoutfield="selectedPersons";
    String sharebutton="share-card-button-share";
    String sharecancel="share-card-button-cancel";
    String shareemailvalidationmsg="email-validation-msg";
    String sharepermissionvalidationmsg="permission-validation-msg";
    String cardsharingowner="card-share-user-0";
    String cardshareuser1="card-share-user-1";
    String cardshareuser2="card-share-user-2";
    String cardshareuser3="card-share-user-3";
    String sharingcontinuebody="(//p[@id='dialog-body-text'])[2]";
    String sharingcontinuebutton="(//button[@id='dialog-button-ok'])[2]";
    String sharingpermissionview="label-share-permission-0";
    String sharingpermissionmanage="label-share-permission-1";
    String sharingmanagepermissioncheckbox="checkbox-share-permission-1";
    String sharingviewpermissioncheckbox="checkbox-share-permission-0";
    String sharingremovesharedcarduser1="#remove-card-share-user-1 > img";
    String sharingpopupcancelbutton="dialog-button-close";
    String Shareingdocchecbox="#additional-2-12-left > div.additional-wrapper2 > div.additional2-check.pers > div.form > div.ng-scope > label";
    String shareremoveicon="remove-card-share-user-1";
    //--------------------------------------------------Summary page fields----------------------------------------
    String summarycategoryname = ".//*[@id='000']/form/span/a";
    String summaryownerlabel = "position-b-field-name ng-binding";//by class name
    String searchnotfound="div.accountsinside > span.ng-scope";
    String summaryyearlabel = "accmidrightp position-c-field-name ng-binding";//by class name
    String summaryupdatedlabel = "accmidrightp position-c-field-name ng-binding";//by class name
    String summaryarrowicon = "financial-sltog-1-0-left";//by id
    String summaryarrowicon2="sltog";//by class name
    String summarysettingicon = "bottomcheckdiv-1-0-left";//id
    String summarydocumentname = ".//*[@id='additional-0-0-left']/div[1]/div[1]/span[2]";

    String summaryyear2label = ".//*[@id='additional-0-0-left']/div[1]/div[2]/span[1]";
    String summarynotestextarea = "notes";//class
    String summarycardchecbox=".ng-pristine.ng-valid>label";//cssselectpt
    String Summarycarddcoumentchecbox="p.ng-scope > label";

    String summaryattachbutton = ".//*[@id='additional-0-0-left']/div[2]/div[2]/div/div/input";
    String summaryscanbutton = ".//*[@id='additional-0-0-left']/div[2]/div[2]/div/a[1]/img";
    String summarypicturebutton = ".//*[@id='additional-0-0-left']/div[2]/div[2]/div/a[2]/img";

    String summarydeletecardpopup = ".modal-body";
    String summarydeletecardpopupcancel = ".btn.ng-binding";
    String summarydeletecardpopupdeletecard = ".btn.ng-binding.btn-primary";
    String firsrcardcheckbox="/html/body/section/section/div[2]/div/div/div[2]/div/div[2]/div/div/div/div/form/label";
    String homedocument="span.ng-binding";//by cssSelector

    //-----------------------------------edit card page-----------------------------------------
    String editcardattachbutton = ".ng-scope>input";
    String editcardscanbutton = ".scan>img";
    String editcardpicturebutton = ".addcontrols>a>img";
    String editnotesinput = "//textarea";
    String editupdatebutton = "Update";
    String editdeletebutton="button-delete-card";//by id

    //by css selector
    String selecttypetocreate = "#select-type > span.ng-scope";
    String canceldocument = "button-cancel-create-card";
    //by xpath
    String createbutton = ".//*[@id='pd-controls2']/ul/li[2]/a";
    String lowercreatebutton = "button-create-card";//by id
    //labels by xpath
    //page button by CSS name-----------
    String attach = "input[type=\"file\"]";
    String scan = "a.scan > img";
    String picture = "//a[2]/img";
    //String additonal="additional";
    String back = "Back";
    String create = "Create";
    String finishlater="button-finish-later-card";
    String popuptext = "html/body/span[1]/div/span/div[2]/p";
    String addfield = "Add Field";
    String backbuttonyes = "dialog-button-ok";
    String backbuttonno = "dialog-button-close";
    String updatecard="button-save-card";
    String removefinishlater="#remove-reminder-0 > img";
    //----------------------------------
    String seachtextfield = "search";
    String searchsubmitbutton = "submit";
    
    //-------------Attach same POP UP
    String keepbothbutton="attach-dialog-button-keep-both";
    String overwritebutton="attach-dialog-button-override";
    String donotuploadbutton="attach-dialog-button-cancel";
    //----------------------------------
    //----------------------------------------User Setting-------------------------------------------------
    String username = "userDescriptionID";//by id
 
    String loginactivity="link-user-activity";//by id
    //by xpath
    String logout = "link-logout";//xpath
    String logoutid="link-logout";//id
    String settings="link-settings";
    String passcodekeyoption="link-passcode-key-option";
    String userprefrence="link-user-preferences";
    String helpbutton="button-help";
    
    String manillaimport="link-manilla-connection";
    //------------------Manage Institution-------------------------------------------------------
    String manageinstitutions="link-manage-institute";
    String mi_continuebutton_1="btn-institution-connect";
    String instutionlogintitle="title-institution-login";
    String institution_username="institute-username";
    String institution_password="institute-password";
    String instition_connect="btn-institution-connect";
    String institution_continue="btn-import-continue";
    //---------------------------------PasscodeKey option--------------------------------------------
    String passcode_continuebutton="button-create-card";
    String userprivatekey="type-checkbox-1";
    String iqabibnetmanageedkey="type-checkbox-2";
    
    //----------------------------------------------------------------------------------------
    String documentretrival="link-document-retrieval";
    String updateprofile = "link-update-profile";//By id
    String changepasswordpin = "link-change-password";//by id
    String dropboxconnection = "link-dropbox-connection";//by id
    String dropboxconnectionexist="dropboxConnectionExist";
    String managedailymailschedule = "link-daily-mail-config";//by id
    String hour = "//input[@type='text']";
    String minutes = "(//input[@type='text'])[2]";
    String ampm = "//button[@type='button']";
    String schedulemailbuton = "Schedule";
    String emailshceduleconfirmationmessage = "div.request-progress-indicator.ng-binding";

    String errortextmessage = "//div[5]/span[3]"; 
    //Login Activity screen
    String loginactivitypagetitle="h4.pg-title > span.ng-scope";//by cssselector
    String firstrowbrowsername="td.browser.ng-binding";//by cssselector
    String firstrowloginstatus="td.added.ng-binding";// by cssselector
    String firstrowadded="//td[3]";//by xpath
    String firsttowlastaccessed="td.accessed.ng-binding";//by cssselector
    String firsttownumberoflogin="td.n-logins.ng-binding";//by cssselctor
    String firstrowlocation="td.location.ng-binding";//by cssselector

    //Update Profile
    String signupcheckbox="html/body/section/section[2]/form/div[2]/div/div[1]/label";
    String signuperrortext=".errortext.ng-binding";
    String usernameinput = "txt-username";
    String emailinput = "txt-email";
    String firstnameinput = "txt-firstname";
    String lastnameinput = "txt-lastname";
    String birthdayinput = "txt-birthday";
    String countryofbirthinput = "txt-country";
    String cityofbirthinput = "txt-city";
    String securityquestion1input = "txt-question-1";
    String securityanswer1input = "txt-answer-1";
    String updatebutton = "btn-signup";
    String refreshbuttonicon="#refresh-button-2c917cbe482b8fba01482c9ae74c0032 > img";
    String dropboxicon="#dropbox-icon-2c917cbe482b8fba01482c9ae74c0032 > img";
    String spinningrefreshbutton="span.refresh-icon > img";

    String dropboxsharedlinktoFileThisfolder_input = ".passport-number.ng-pristine.ng-valid";//by cssselector
    String dropboxsharedlinktoFileThisfolder_url = "https://www.dropbox.com/sh/tvbviee2w0wdu4t/qLa-5G8_cx";
    String dropboxboxspinningwheel = ".//*[@id='pd-controls']/ul/li[2]/img";
    String dropboxspinningwheel2 = ".//*[@id='pd-controls']/ul/li/img";
    String dropboximportsuccesfullimportmessageOKbutton = "//button[2]";
    String sharedlinkurl = "html/body/section/section/div[2]/div[1]/div/div[1]/form/div[5]/a";
    String status = "html/body/section/section/div[2]/div[1]/div/div[1]/form/div[3]";

    //file this connection button, recognised by link text
    String dropboxconnection_clearbutton = "btn-dropbox-clear";
    String dropboxconnection_connectbutton = "btn-dropbox-connect";
    //File this connection confirmation page
    String dropboxconnectionpagename = "html/body/section/section/div[2]/div[1]/div/h1/span";
    String dropboxconnectpagemessage = "html/body/section/section/div[2]/div[1]/div/div/form/div[1]/p";
    String dropboxconnectioncontnuebutton = "a.create > span.ng-scope";
    String dropboxdocumentlistarea = ".//*[@id='accountssidebar']";

    String dropboxupdatespinningwheel = ".//*[@id='pd-controls']/ul/li[2]/img";
    String dropboxupdatebutton = "dropbox-update";
    String dropboxconnectbutton = "btn-dropbox-connect";
    String dropboxremovebutton = "dropbox-remove";
    String dropboxremovebuttonid = "dropbox-remove";
    String dropboxeditconnection = "dropbox-edit-connection";
    String dropboxcontinuebutton="btn-dropbox-continue";
    //Change password Pin

    String currentpasswordinput = "txt-password";//by id
    String newpasswordinput = "txt-new-password";
    String confirmnewpasswordinput = "txt-confirm-password";
    String passwordcancelbutton = "btn-cancel-password";
    String passwordsavebutton = "btn-save-password";
    String oldpassworddoesnotmatcherror = "//form/div/div";
    String successfullpasswordresetmessage = "html/body/div[1]/div/section/div[1]";

    String currentpininput = "txt-pin";
    String newpininput = "txt-new-pin";
    String confirmpininput = "txt-confirm-pin";
    String pincancelbutton = "btn-cancel-pin";
    String pinsavebutton = "btn-save-pin";
    String oldpindoesnotmatcherror = "//div[2]/form/div/div";


    //Personal Document labels
    String homedocumentlabel = "group-name-00";
    String taxreturnlabel = "type-name-000";
    String propertylabel = "type-name-001";
    String realestatetaxlabel = "type-name-002";
    String homeimprovementandrepairlabel = "type-name-003";
    String homeapplicanceandequipmentlabel = "type-name-004";
    String homeserservicelabel = "type-name-005";
    String otherhomedocumentlabel = "type-name-006";
    String familydocumentlabel = "group-name-01";
    String birthcertificatelabel = "type-name-010";
    String marriagecertificatelabel = "type-name-011";
    String militaryrecordlabel = "type-name-012";
    String driverlicenxelable = "type-name-013";
    String passportlabel = "type-name-014";
    String immigrationandvisadocumentlabel = "type-name-015";
    String divorcerecordlabel = "type-name-016";
    String otherfamilydocumentlabel = "type-name-017";
    String personalpossesiondocumentlabel = "group-name-02";
    String vehicleslabel = "type-name-020";
    String computerandeclectronicslabel = "type-name-021";
    String jewelrylabel = "type-name-022";
    String furniturelabel = "type-name-023";
    String artlabel = "type-name-024";
    String collectiblelabel = "type-name-025";
    String otherpossesionlabel = "type-name-026";
    String estateplanningdocumentlabel = "group-name-10";
    String willlable = "type-name-100";
    String healthpowerofattorneylabel = "type-name-101";
    String advancedirectivelabel = "type-name-102";
    String trustdocumentlabel = "type-name-103";
    String otherestatedocumentlabel = "type-name-104";
    String educationlabel = "group-name-11";
    String universityandcollegelabel = "type-name-110";
    String highschoollabel = "type-name-111";
    String elemenryschoollabel = "type-name-112";
    String nurseryandpreschoollalbel = "type-name-113";
    String daycarelabel = "type-name-114";
    String othereducationdocument = "type-name-115";
    String otherdocuemntslabel = "group-name-12";
    String otherdocumentlabel = "type-name-120";
    
    //Personal Document categories name
    


    //checkbox by xpath
    String checkboxlabel=".chbb.ng-scope>label";
    
    String taxreturncheckbox = "type-checkbox-000";
    //String othertacdocumentchecbox = ".//*[@id='probl']/section[1]/div[1]/form/p[2]/label";
    String propertychecbox = "type-checkbox-001";
    String realestatetaxcheckbox = "type-checkbox-002";
    String homeimprovmentandrepaircheckbox = "type-checkbox-003";
    String homeapplicanceandequipmentcheckbox = "type-checkbox-004";
    String homeservicecheckbox = "type-checkbox-005";
    String otherhomedocumentchecbox = "type-checkbox-006";
    String birthcertificatecheckbox = "type-checkbox-010";
    String marriagecertificatechecbox = "type-checkbox-011";
    String militaryrecordcheckbox = "type-checkbox-012";
    String driverlicencechecbox = "type-checkbox-013";
    String passportcheckbox = "type-checkbox-014";
    String immigrationandvisadocumentschecbox = "type-checkbox-015";
    String divorcerecordcheckbox = "type-checkbox-016";
    String otherfamilydocumentcheckbox = "type-checkbox-017";
    String vehiclecheckbox = "type-checkbox-020";
    String computerandelectronicscheckbox = "type-checkbox-021";
    String jewelrycheckbox = "type-checkbox-022";
    String furniturecheckbox = "type-checkbox-023";
    String artcheckbox = "type-checkbox-024";
    String collectiblecheckbox = "type-checkbox-025";
    String otherposseioncheckbox = "type-checkbox-026";
    String willcheckbox = "type-checkbox-100";
    String healthcarepowerofattorneycheckbox = "type-checkbox-101";
    String advancedirectivecheckbox = "type-checkbox-102";
    String trustdocumentcheckbox = "type-checkbox-103";
    String otherestatedocumentcheckbox = "type-checkbox-104";
    String universityandcollegechecbox = "type-checkbox-110";
    String highschoolcheckbox = "type-checkbox-111";
    String elementryschoolcheckbox = "type-checkbox-112";
    String nurseryandpreschoolcheckbox = "type-checkbox-113";
    String daycarechecbox = "type-checkbox-114";
    String othereducationdocumentcheckbox = "type-checkbox-115";
    String otherdocumentcheckbox = "type-checkbox-120";

    //Tax return Page name, fieldname and fields
    String addnoteslabel="Add Field";//by linktext
    String noteslabel="p.personal-label > span > span.ng-scope";//by cssselector
    String taxreturndate="field-input-3";
    //Page Name
    String pagename = "card-title";

    //Page fields labels
    String belongsto="field-label-0";
    String fieldlabel1 = "field-label-1";
    String fieldlabel2 = "field-label-2";
    String fieldlabel3 = "field-label-3";
    String cardimages="field-label-attachments";
    String taxreturnattachment1="remove-uploaded-attachment-0";//by Id
    String taxreturnattachment2="remove-uploaded-attachment-1";//by id
    
   
    					
    
    //Text field
    String belongstoinput="s2id_autogen1";
    String editinstitution="editinstitution";
    String residenceinput="s2id_autogen2";
    String bithcirtificatestoragelocation="s2id_autogen3";
    String Marriagecirtificatestoragelocation="s2id_autogen4";
    String typeahedpeopleoshare="s2id_autogen7";
    String typeahed2="s2id_autogen5";
    String typeahed3="s2id_autogen6";
    
    
    String taxyearinput="field-input-2";
    String noteinput="field-input-notes";
    
    String fieldinput1="field-input-1";
    String fieldinput2="field-input-2";
    String fieldinput3="field-input-3";
    String fieldinput4="field-input-4";
    String fieldinput5="field-input-5";
    String fieldinput6="field-input-6";
    String fieldinput7="field-input-7";
    String fieldinput8="field-input-8";
    String fieldinput9="field-input-9";
    String fieldinput10="field-input-10";
    String fieldinput11="field-input-11";
    String fieldinput12="field-input-12";
    String fieldinput13="field-input-13";
    String fieldinput14="field-input-14";
    String fieldinput15="field-input-15";
    
    String taxreturnlocationinput = "/html/body/section/section/div[2]/div/div/div/div[3]/form/div[2]/span/div/div/div/ul/li/input";//by id
    String taxretuenlocationselect="/html/body/div[5]/ul/li/div";
    String taxreturnyearinput = "/html/body/section/section/div[2]/div/div/div/div[3]/form/div[3]/span/input";
    String taxreturnnoimageattach="div.additional-wrapper2 > span.ng-binding";//by cssselector
    String edittaxretunrcardlocationinput="/html/body/section/section/div[2]/div/div/div/div[3]/form/div[2]/span/div/div/div/ul/li/div";//by css selector
   

   
    //--------------------------------------Property Page label and button----------------------------
    String fieldlabel4="field-label-4";
    String fieldlabel5="field-label-5";
    String fieldlabel6="field-label-6";    
    String fieldlabel7="field-label-7";

    //Page input field
    String propertyname="field-input-2";
    String notesfiledinput="field-input-notes";
    //String propertyaddressinput = "/html/body/section/section/div[2]/div/div/div/div[3]/form/div[3]/span/input";

    //--------------------------------------------- Real Estate Tax Page label and button
    String realstatetaximage="/html/body/section/section/div[2]/div/div/div/div[3]/form/div[7]/p/span";
    //Page input field
    String realestatetaxcurrentpropertytaxrateinput = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[4]/span/input";

    //--------------------------------- Home Improvement and repair Page label and button
    String homeimprovementandrepairimage="/html/body/section/section/div[2]/div/div/div/div[3]/form/div[10]/p/span";
    

    //---------------------------------- Home Appliance and Equipment
    String fieldlabel8="field-label-8";
    String fieldlabel9="field-label-9";
    String fieldlabel10="field-label-10";
    
    									
    //Page input document
    String birthcertificatecountryinput = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[2]/span/div/span/select";
    										
     
    //Inputfields
    String driverlicensecountryinput = "/html/body/section/section/div[2]/div/div/div/div[3]/form/div[2]/span/div/span/select";
    String driverlicensestateinput = "/html/body/section/section/div[2]/div/div/div/div[3]/form/div[3]/span/div/span/select";
    String driverlicenseidinput = "/html/body/section/section/div[2]/div/div/div/div[3]/form/div[4]/span/input";

    
    
    //Vehicle
    String fieldlabel11="field-label-11";
    String fieldlabel12="field-label-12";
    String fieldlabel13="field-label-13";
  
      //----------------------------------------- ACCOUNTS-------------------------------------------------------------

    //Accounts Category Lables

    //Account category checkboxes
    String bankaccountcheckbox = "type-checkbox-000";
    //String savingaccountscheckbox = "type-checkbox-001";
    String investmentaccountcheckbox = "type-checkbox-001";
    String retirementaccountcheckbox = "type-checkbox-002";
    String creditcardaccountcheckbox = "type-checkbox-003";
    String mortgageaccountxhecbox = "type-checkbox-004";
    String autoloancheckbox = "type-checkbox-005";
    String generalloancheckbox = "type-checkbox-006";
    String otherfinancialaccount = "type-checkbox-007";
    String Homechecbox = "type-checkbox-010";
    String renterschecbox = "type-checkbox-011";
    String autochecbox = "type-checkbox-012";
    String medicalinsurancechecbox = "type-checkbox-013";
    String dentalinsuranceckbox = "type-checkbox-014";
    String visioninsurancecheckbox = "type-checkbox-015";
    String otherinsurnacecheckbox = "type-checkbox-016";
    String electricitycheckbox = "type-checkbox-020";
    String gaschecbox = "type-checkbox-021";
    String watercheckbox = "type-checkbox-022";
    String phonecheckbox = "type-checkbox-023";
    String internetcheckbox = "type-checkbox-024";
    String tvcablecheckbox = "type-checkbox-025";

    String otherhomeaccountcheckbox = "type-checkbox-026";
    String airlinechebox = "type-checkbox-100";
    String hotelcheckbox = "type-checkbox-101";
    String rentalcarchecbox = "type-checkbox-102";
    String othertravelchecbox = "type-checkbox-103";
    
    String employeerecordchecbox = "type-checkbox-110";
    String shoppingcheckbox = "type-checkbox-111";
    String otheraccountcheckbox = "type-checkbox-112";


    //Accounts - Bank Account
    String checkingaccountpagelabel = "html/body/section/section/div[2]/div[1]/div[1]/h1";
    String checkingaccountfield1label = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[2]/p/span";
    String checkingaccountfield2label = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[3]/p/span";
    String checkingaccountfield3label = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[4]/p/span";
    String checkingaccountfield4label = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[5]/p/span";
    String checkingaccountaddfieldlabel = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[6]/a";
    String checkingaccountnoteslabel = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[7]/p/span/span";
    String checkingaccountimageslabel = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[8]/p/span";
    
    String bankaccountcurrentbalance="field-input-4";
    //Checking Account Input
    String checkingaccountfield1input = ".//*[@id='s2id_2c905fde43186f61014318710cf50109']/ul";
    String checkingaccountintitutioninput = ".//*[@id='s2id_2c9103e24426ad83014426ade5230130']/ul";
    String checkingaccountfield2input = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[3]/span/input";
    String checkingaccountnumberinput = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[4]/span/input";

       //------------------------------Accounts - Employee Records
   String employeerecordimagesfield = "/html/body/section/section/div[2]/div/div/div/div[3]/form/div[9]/p/span";
    //Input
    String employeerecordcompanynameinput = "field-input-1";
    

    
    String otheraccountaddfieldinput = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[6]/p/edit-in-place/input";
    String otheraccountaddfieldlabelnew = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[6]/p/edit-in-place/span";
    String accountnumerinout = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[4]/span/input";
    //-----------------------------------------Medical Records--------------------------------------------------------------------
    //Medical Records category checkbox
    String medicalinformationcheckbox = "type-checkbox-000";
    String inoculationscheckbox = "type-checkbox-001";
    String othermedicalinformationcheckbox = "type-checkbox-002";
    String hsacheckbox = "type-checkbox-010";
    String fsacheckbox = "type-checkbox-011";
    String othersavingaccountcheckbox = "type-checkbox-012";
    String conditioncheckbox = "type-checkbox-020";

    // input fields
    String medicalrecordfield1input = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[2]/span/input";

    String medicalrecordaddfieldinput = "html/body/section/section/div[2]/div[1]/div[1]/div/div[3]/form/div[9]/p/edit-in-place/input";
    
    
    public enum Browsers {

        SAFARI {
            public WebDriver browser() {
                WebDriver driver = new SafariDriver();
                return driver;

            }
        },

        FIREFOX {
            public WebDriver browser() {
            	/*FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.private.browsing.autostart", true);
*/
            	/*ProfilesIni profile = new ProfilesIni();
            	FirefoxProfile ffprofile = profile.getProfile("default");
            	
            	WebDriver driver = new FirefoxDriver(ffprofile);*/
            	WebDriver driver = new FirefoxDriver();
                return driver;

            }
        },
        CHROME {
            public WebDriver browser() {
            	
            	java.net.URL resource = Browser.class.getResource("/chromedriver.exe");
            	
      		  	String path;
				try {
					path = new File(resource.toURI()).getAbsolutePath();
					System.setProperty("webdriver.chrome.driver", path);
				} catch (URISyntaxException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				
				ChromeOptions options = new ChromeOptions();
            	//options.addArguments("--no-sandbox");
            	DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            	capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				
      		   //-- TODO: get working in UNIX
                WebDriver driver = new ChromeDriver(capabilities);
                return driver;

            }
        },
        IE {
            public WebDriver browser() {
            	
            	java.net.URL resource = Browser.class.getResource("/IEDriverServer.exe");
            	
      		  	String path;
				try {
					path = new File(resource.toURI()).getAbsolutePath();
					System.setProperty("webdriver.ie.driver", path);
				} catch (URISyntaxException e) {
					e.printStackTrace();
				}
								
                WebDriver driver = new InternetExplorerDriver();
                return driver;

            }
        },
        PHANTOMJS {
            public WebDriver browser() {
                // prepare capabilities
                DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
                // not really needed: JS enabled by default
                desiredCapabilities.setJavascriptEnabled(true);
                desiredCapabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);

                String phantomjsRelativeLocation = "phantomjs/1.9.2/bin/phantomjs" + FileUtils.getOsVersionStringExtension();
                File phantomJS = FileUtils.prepateExecutableResourceFile(this.getClass(), phantomjsRelativeLocation);
                String phantomjsAbsoluteLocation = phantomJS.getPath();
                desiredCapabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, phantomjsAbsoluteLocation);
                // Launch driver (will take care and ownership of the phantomjs process)
                WebDriver driver = new PhantomJSDriver(desiredCapabilities);
                return driver;
            }
        };

        public abstract WebDriver browser();
    }
}
