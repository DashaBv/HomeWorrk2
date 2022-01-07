package dasha.ru;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationFormTests {
    @BeforeAll
    static void setUp(){
        Configuration.baseUrl="https://demoqa.com";
        Configuration.browserSize="1920x1080";
    }
    @DisplayName("Homework")
    @Test
     void RegistrationFormTest() {

        //Открыть страницу
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        //Заполнить поле "First Name"
        $("#firstName").setValue("Dasha");
        //Заполнить поле "Last Name"
        $("#lastName").setValue("Belikova");
        //Заполнить поле "Email"
        $("#userEmail").setValue("dasha.belikova@mail.ru");
       //Заполнить поле "Gender" gender-radio-2
       //$("#gender-radio-2").parent().click();
        $("#genterWrapper").$(byText("Female")).click();
        //Заполнить поле "Mobile"
        $("#userNumber").setValue("9889818690");
        //Заполнить поле Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("February");
        $(".react-datepicker__year-select").selectOption("1994");
        //$(".react-datepicker__day--004:not(.react-datepicker__day--selected)").click();
        $$(".react-datepicker__day--004")
                .filter(not(cssClass("react-datepicker__day--selected")))
                .first() // or.get(0)
                .click();
        //Заполнить поле Subject
        //subjectsInput
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        //Заполнить поле Current Address
        $("#currentAddress").setValue("Sesame");

        $("#submit").click();




    }
}
