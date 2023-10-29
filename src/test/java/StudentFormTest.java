import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byValue;
import static com.codeborne.selenide.Selenide.*;

public class StudentFormTest {
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
        $("#react-select-4-input").val("Jaipur").pressEnter();
        $("#submit").pressEnter();

        //результат
        $(".table-responsive").shouldHave(text("Elena Malysheva"));
        $(".table-responsive").shouldHave(text("malyseva630@gmail.com"));
        $(".table-responsive").shouldHave(text("Female"));
        $(".table-responsive").shouldHave(text("9873058652"));
        $(".table-responsive").shouldHave(text("Economics,English,Biology,Math"));
        $(".table-responsive").shouldHave(text("Sports,Reading, Music"));
        $(".table-responsive").shouldHave(text("my.png"));
        $(".table-responsive").shouldHave(text("Lunnaya 43b str."));
        $(".table-responsive").shouldHave(text("Rajasthan Jaipur"));

        //проверка значений
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Elena Malysheva"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("Elena Malysheva"));
        $(".table-responsive").$(byText("Student Gender")).parent().shouldHave(text("Female"));
        $(".table-responsive").$(byText("Student Number")).parent().shouldHave(text("9873058652"));
        $(".table-responsive").$(byText("Student Subject")).parent().shouldHave(text("Economics,English,Biology,Math"));
        $(".table-responsive").$(byText("Student Hobbies")).parent().shouldHave(text("Sports,Reading, Music"));
        $(".table-responsive").$(byText("Student Picture")).parent().shouldHave(text("my.png"));
        $(".table-responsive").$(byText("Student Address")).parent().shouldHave(text("Lunnaya 43b str."));
        $(".table-responsive").$(byText("Student State")).parent().shouldHave(text("Rajasthan Jaipur"));

    }






        }

