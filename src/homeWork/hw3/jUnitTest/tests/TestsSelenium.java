package homeWork.hw3.jUnitTest.tests;

import org.junit.Assert;
import org.junit.Test;

public class TestsSelenium extends LogInAndRegFixture {

    // all input correct
    @Test
    public void test0() {

        log.info(String.format("\ntest0 (positive)\n"));
        homePage.closeBlurb();
        log.info("close blurb.");
//        homePage.clickLogo();
//        log.info("click logo.");
        homePage.switchToRegistrationPage();
        log.info("switch to registration page.");
        registrationPage.clickAndInputLoginField(EMAIL);
        log.info("input " + EMAIL + " in login field.");
        registrationPage.clickAndInputPassFieldAll(PASS);
        log.info("input " + PASS + " in password field.");
        registrationPage.clickButtonLogIn();
        log.info("click login button.");
        homePage.clickLogOut();
        log.info("click log Out.");


    }

    // input incorrect email and correct password
    @Test
    public void test1() {

//        homePage.clickLogo();
        homePage.clickLogIn();
        log.info(String.format("\ntest1 (negative)\n"));
//        homePage.switchToRegistrationPage();
//        log.info("switch to registration page.");
        String failedEMAIL = EMAIL + ".";
        registrationPage.clickAndInputLoginFieldAndClickTAB(failedEMAIL);
        log.info("input " + failedEMAIL + " in login field and click TAB.");
        registrationPage.clickAndInputPassFieldOne(PASS);
        log.info("input " + PASS + " in password field.");
        registrationPage.clickButtonLogIn();
        log.info("click login button");

        if (registrationPage.isErrorMessageNotEmptyFields()) {
            log.info("not logged in.");
        } else {
            Assert.assertFalse("ERROR is not present", registrationPage.isErrorMessageNotEmptyFields());
        }

    }

    // input correct email and incorrect password
    @Test
    public void test2() {

        if (registrationPage.isHelpBoxPresent()) {
            registrationPage.closeHelpBox();

            log.info(String.format("\ntest2 (negative)\n"));

            registrationPage.clickAndInputLoginFieldAndClickTAB(EMAIL);
            log.info("input " + EMAIL + " in login field and click TAB.");
            String failedPASS = PASS.substring(0, 3);
            registrationPage.clickAndInputPassFieldOne(failedPASS);
            log.info("input " + failedPASS + " in password field.");
            registrationPage.clickButtonLogIn();

            if (registrationPage.isErrorMessageNotEmptyFields()) {
                log.info("not logged in.");
            } else {
                Assert.assertFalse("ERROR is not present", registrationPage.isErrorMessageNotEmptyFields());
            }

        } else {

            log.info(String.format("\ntest2 (negative)\n"));

            registrationPage.clickAndInputLoginFieldAndClickTAB(EMAIL);
            log.info("input " + EMAIL + " in login field and click TAB.");
            String failedPASS = PASS.substring(0, 3);
            registrationPage.clickAndInputPassFieldOne(failedPASS);
            log.info("input " + failedPASS + " in password field.");
            registrationPage.clickButtonLogIn();

            if (registrationPage.isErrorMessageNotEmptyFields()) {
                log.info("not logged in.");
            } else {
                Assert.assertFalse("ERROR is not present", registrationPage.isErrorMessageNotEmptyFields());
            }
        }

    }

    // input empty email and password
    @Test
    public void test3() {

        if (registrationPage.isHelpBoxPresent()) {
            registrationPage.closeHelpBox();
        }

        log.info(String.format("\ntest3 (negative)\n"));

        registrationPage.clickAndInputLoginFieldAndClickTAB("");
        log.info("input empty in login field and click TAB.");
        registrationPage.clickAndInputPassFieldOne("");
        log.info("input empty in password field.");
        registrationPage.clickButtonLogIn();

        if (registrationPage.isErrorMessageEmptyFields()) {
            log.info("not logged in.");
        } else {
            Assert.assertFalse("ERROR is not present", registrationPage.isErrorMessageEmptyFields());
        }

    }

    // input empty email and correct password
    @Test
    public void test4() {

        if (registrationPage.isHelpBoxPresent()) {
            registrationPage.closeHelpBox();
        }

        log.info(String.format("\ntest4 (negative)\n"));

        registrationPage.clickAndInputLoginFieldAndClickTAB("");
        log.info("input empty in login field and click TAB.");
        registrationPage.clickAndInputPassFieldOne(PASS);
        log.info("input " + PASS + " in password field.");

        if (registrationPage.isErrorMessageOneFiledEmpty()) {
            log.info("not logged in.");
        } else {
            Assert.assertFalse("ERROR is not present", registrationPage.isErrorMessageOneFiledEmpty());
        }

    }

    // input correct email and empty password
    @Test
    public void test5() {

        if (registrationPage.isHelpBoxPresent()) {
            registrationPage.closeHelpBox();
        }

        log.info(String.format("\ntest5 (negative)\n"));

        registrationPage.clickAndInputLoginFieldAndClickTAB(EMAIL);
        log.info("input " + EMAIL + " in login field.");
        registrationPage.clickAndInputPassFieldOne("");
        log.info("input empty in password field.");

        if (registrationPage.isErrorMessageOneFiledEmpty()) {
            log.info("not logged in.");
        } else {
            Assert.assertFalse("ERROR is not present", registrationPage.isErrorMessageOneFiledEmpty());
        }

    }

}
