import org.example.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonTest {


    //<0, >0,0,200

    Person person = new Person("Jose", 10, "TA");
    ;

    @BeforeEach
    public void init() {
        //  person= new Person("Jose",10,"TA");
    }

    @AfterEach
    public void tearDown() {

    }

    @Test
    public void check_setAge_less_than_zero_constructor() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Person("jose",-10,"ta"));
    }

    @Test
    public void check_setAge_less_than_zero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> person.setAge(-10));
    }

    @Test
    public void check_setAge_greater_than_zero() {
        Assertions.assertDoesNotThrow(() -> person.setAge(20));
        Assertions.assertEquals(20, person.getAge());
    }

    @Test
    public void check_setAge_equals_zero() {
        Assertions.assertDoesNotThrow(() -> person.setAge(0));
        Assertions.assertEquals(0, person.getAge());
    }

    //correcto

    @Test
    public void check_clone_create_correctly() {
        Assertions.assertEquals(person,person.clone());
        Assertions.assertEquals(person,Person.clone(person));
    }
}
