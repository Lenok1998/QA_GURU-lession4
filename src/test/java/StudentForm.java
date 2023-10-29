import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
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
    void StudentForm() {

        open("/automation-practice-form"); //открываем форму
        executeJavaScript("$('#fixedban').remove()"); //удаляем баннер
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Elena");// заполняем форму данными
        $("#lastName").setValue("Malysheva");
        $("#userEmail").setValue("malyseva630@gmail.com");
        $("[for='gender-radio-2']").click();
        $("#userNumber").setValue("9873058652");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").click();
        $(byValue("1998")).click();
        $(".react-datepicker__month-select").selectOption("July");
        $("[aria-label='Choose Monday, July 13th, 1998']").click();
        $("#subjectsInput").val("Economics").pressEnter();
        $("#subjectsInput").val("English").pressEnter();
        $("#subjectsInput").val("Biology").pressEnter();
        $("#subjectsInput").val("Math").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("[for='hobbies-checkbox-2']").click();
        $("[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFile(new File("src/test/pictures/my.png"));
        $("#currentAddress").setValue("Lunnaya 43b str.");
        $("#react-select-3-input").val("Rajasthan").pressEnter();
        $("#react-select-4-input").val("Jaiselmer").pressEnter();
        $("#submit").pressEnter();

        $(".table-responsive").shouldHave(//результат
                text("Malysheva Elena"),
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

