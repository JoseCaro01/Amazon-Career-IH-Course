import org.example.Person;
import org.example.PersonList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class PersonListTest {


    // correcto, no la encuentra,nombre formato incorrecto("" " " "few  efw dweq"),
    PersonList personList ;
    Person person;
    Person person1;

    @BeforeEach
    public void init() {
        ArrayList<Person> arrayList = new ArrayList<>();
        person=new Person("Jose Alfonso",10,"TA");
        person1=new Person("Adrian Alman",18,"TA");
        arrayList.add(person);
        arrayList.add(person1);
        personList = new PersonList(arrayList);
    }

    @Test
    public void check_findByName_find_person() {
        Person jose= new Person("Jose Alfonso",10,"TA");
        Assertions.assertEquals(jose,personList.findByName("Jose Alfonso"));
    }

    @Test
    public void check_findByName_not_find_person() {
       // Person jose= new Person("Jose Alfonso",10,"TA");
        Assertions.assertThrows(RuntimeException.class,() -> personList.findByName("Jose Caro"));
    }
    @Test
    public void check_findByName_name_wrong_format() {
        Assertions.assertThrows(IllegalArgumentException.class,() -> personList.findByName("Jose "));
        Assertions.assertThrows(IllegalArgumentException.class,() -> personList.findByName("Jose"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> personList.findByName("Jose djeiw dejwo"));
        Assertions.assertThrows(IllegalArgumentException.class,() -> personList.findByName(""));
        Assertions.assertThrows(IllegalArgumentException.class,() -> personList.findByName("  "));
    }
}
