import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountTest {

    private final String name;
    private final Boolean status;
    private Account account;

    public AccountTest(String name, Boolean status) {
        this.name = name;
        this.status = status;
    }

    @Parameterized.Parameters
    public static Object[] getStatus() {
        return new Object[][]{
                {"Тимоти Шаламе", true},
                {" Тимоти Шаламе", false},
                {"Тимоти Шаламе ", false},
                {"Т а", true},
                {"ТимотиШаламе", false},
                {"ТимотиШаламе ", false},
                {" ТимотиШаламе", false},
                {"ТимотиШаламе ТимотиШ", false},
                {"ТимотиШаламе Тимоти", true},
                {"Тимо  тиШаламе", false},
                {" ", false},
                {null, false},
        };
    }

    public void setUp(String name) {
        account = new Account(name);
    }

    @Test
    public void testCheckNameCard() {
        setUp(name);
        assertEquals(status, account.checkNameToEmboss());
    }
}