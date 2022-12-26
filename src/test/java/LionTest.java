import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensReturnDefaultKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualKittens = lion.getKittens();
        int expectedKittens = 1;
        Assert.assertEquals(expectedKittens, actualKittens);
    }

    @Test
    public void doesHaveManeReturnTrueIfSexMale() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        boolean isManeOfLion = lion.doesHaveMane();
        Assert.assertTrue(isManeOfLion);
    }

    @Test
    public void doesHaveManeReturnFalseIfSexFemale() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        boolean isManeOfLion = lion.doesHaveMane();
        Assert.assertFalse(isManeOfLion);
    }

    @Test
    public void getFoodReturnListOfFoodForLion() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFoodForLion = lion.getFood();
        List<String> expectedFoodForLion = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFoodForLion, actualFoodForLion);
    }
}
