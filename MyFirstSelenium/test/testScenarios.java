package MyFirstSelenium.test;
import MyFirstSelenium.test.action.action;

public class testScenarios extends action {

  public void gmailAutomate() {

    //Valid Email Address
    navigate2URL("http://mail.google.com");
    waitASecond(3);
    login();
    validCompose();
    closeDriver();

    //Invalid Email Address
    navigate2URL("http://mail.google.com");
    waitASecond(3);
    login();
    invalidEmailAddress();


  }



}
