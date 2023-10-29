import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class StudentForm {
    @BeforeAll //выполняется перед тестом
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; //размер окна браузера
        Configuration.baseUrl = "https://demoqa.com"; //адрес ресурса
        Configuration.pageLoadStrategy = "eager";  // шаблон selenide
    }

    @Test // метка теста
    void studentForm() {

        open("/automation-practice-form"); //открываем форму
        executeJavaScript("$('#fixedban').remove()"); //удаляем баннер
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Elena");// заполняем форму данными
        $("#lastName").setValue("Malysheva");
        $("#userEmail").setValue("malyseva630@gmail.com");
        $("#genterWrapper").$(byText("Female")).click();
        $("#userNumber").setValue("9873058652");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byValue("1998")).click();
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--013:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").val("Economics").pressEnter();
        $("#subjectsInput").val("English").pressEnter();
        $("#subjectsInput").val("Biology").pressEnter();
        $("#subjectsInput").val("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        $("#uploadPicture").uploadFromClasspath("my.png");
        $("#currentAddress").setValue("Lunnaya 43b str.");
        $("#react-select-3-input").val("Rajasthan").pressEnter();
        $("#react-select-4-input").val("Jaiselmer").pressEnter();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(//результат
                text("Elena Malysheva"),
                text("malyseva630@gmail.com"),
                text("Female"),
                text("9873058652"),
                text("13 July,1998"),
                text("Economics, English, Biology, Math"),
                text("Sports, Reading, Music"),
                text("my.png"),
                text("Lunnaya 43b str."),
                text("Rajasthan Jaiselmer"));

    }






        }

