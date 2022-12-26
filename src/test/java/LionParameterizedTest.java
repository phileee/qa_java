import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    private final String sex;
    private final Feline feline;

    public LionParameterizedTest(Feline feline, String sex) {
        this.feline = feline;
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getDataForForm() {

        // создаем мок как переменную внутри метода для использовании в параметризации
        Feline felineMock = Mockito.mock(Feline.class);

        return new Object[][] {
                {felineMock, "Самец"},
                {felineMock, "Самка"},
                {null, "Самка"},
                {felineMock, "Неизвестный пол"}
        };
    }

    @Test
    public void constructorLionValidInit() {
        try {
            // если класс льва создается с валидными аргументами, то класс создается и не может быть null
            Lion lion = new Lion(feline, sex);
            Assert.assertNotNull(lion);
        } catch (Exception exception) {
            // если аргументы невалидны, то выбрасывается исключение, проверяем сообщения исключения
            String exceptionActualMessage = exception.getMessage();
            String exceptionExpectedMessageFeline = "Используйте допустимые значения семейства животного";
            String exceptionExpectedMessageSex = "Используйте допустимые значения пола животного - самец или самка";
            Assert.assertTrue(exceptionActualMessage.equals(exceptionExpectedMessageFeline) || exceptionActualMessage.equals(exceptionExpectedMessageSex));
        }
    }
}
