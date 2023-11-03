import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GithubTest {
    @BeforeAll //выполняется перед тестом
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; //размер окна браузера
        Configuration.baseUrl = "https://github.com"; //адрес ресурса
        Configuration.pageLoadStrategy = "eager";  // шаблон selenide
    }

    @Test //метка тест
    void githubSearch() {
        open("/selenide/selenide"); //открываем ресурс
        $("#wiki-tab").click(); //находим раздел Wiki, кликаем на него
        $("#wiki-pages-filter").setValue("Softassertions").pressEnter();//фильтруем по названию,жмём Enter
        $("[href='/selenide/selenide/wiki/SoftAssertions']").click();//находим гиперссылку, кликаем на неё

        // находим нужный фрагмент кода Junit5
        $("#user-content-3-using-junit5-extend-test-class+div").$("pre").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})\n" +
                "class Tests {\n" +
                "  @Test\n" +
                "  void test() {\n" +
                "    Configuration.assertionMode = SOFT;\n" +
                "    open(\"page.html\");\n" +
                "\n" +
                "    $(\"#first\").should(visible).click();\n" +
                "    $(\"#second\").should(visible).click();\n" +
                "  }\n" +
                "}"));


    }

}