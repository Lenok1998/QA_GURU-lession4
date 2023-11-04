import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
public class DragAndDropTest {
    @BeforeAll //выполняется перед тестом
    static void beforeAll() {
        Configuration.browserSize = "1920x1080"; //размер окна браузера
        Configuration.baseUrl = "https://the-internet.herokuapp.com"; //адрес ресурса
        Configuration.pageLoadStrategy = "eager";  // шаблон selenide
    }
        @Test
        void secondTest () {
            open("/drag_and_drop");
            $("#column-a").shouldHave(text("A"));
            $("#column-b").shouldHave(text("B"));
            $("#column-a").dragAndDrop (DragAndDropOptions.to("#column-b"));
            $("#column-a").shouldHave(text("B"));
            $("#column-b").shouldHave(text("A"));
        }
    }














