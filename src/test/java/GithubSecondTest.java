import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
public class GithubSecondTest {
    @BeforeAll //выполняется перед тестом
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; //размер окна браузера
        Configuration.pageLoadStrategy = "eager";  // шаблон selenide
    }
    @Test // метка теста
    void githubSecond() {
        open("https://github.com");
        $(".d-lg-flex.list-style-none").
                $(byText("Solutions")).
                hover();
        $("[href='/enterprise']").click();
        webdriver().shouldHave(url("https://github.com/enterprise"));
    }
    }



