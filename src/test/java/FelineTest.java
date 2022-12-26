import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

public class FelineTest {

    @Test
    public void eatMeatReturnListOfFood() throws Exception {
        Feline feline = new Feline();
        List<String> foodOfFeline = feline.eatMeat();
        List<String> expectedFoodOfFeline = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFoodOfFeline, foodOfFeline);
    }

    @Test
    public void getFamilyReturnStringOfFamily() {
        Feline feline = new Feline();
        String familyOfFeline = feline.getFamily();
        String expectedFamily = "Кошачьи";
        Assert.assertEquals(expectedFamily, familyOfFeline);
    }

    @Test
    public void getKittensWithoutArgumentsReturnIntOne() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens();
        int expectedKittens = 1;
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void getKittensWithArgumentsReturnThatArgument() {
        Feline feline = new Feline();
        int actualKittens = feline.getKittens(5);
        int expectedKittens = 5;
        Assert.assertEquals(expectedKittens, actualKittens);
    }
}
