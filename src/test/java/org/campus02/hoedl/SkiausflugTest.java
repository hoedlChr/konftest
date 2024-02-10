package org.campus02.hoedl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SkiausflugTest {

    Skiausflug meinSkiAusflug;
    Person person1;
    Person person2;

    @BeforeEach
    void createSkiausflugandPersons(){
        person1 = new Person("Christoph", 20, true);
        person2 = new Person("Matthias", 22, false);
        meinSkiAusflug = new Skiausflug(2);
    }

    @Test
    void checkKonstruktor(){
        Assertions.assertEquals(2, meinSkiAusflug.getMaxTeilnehmerZahl());

        ArrayList<Person> myList = new ArrayList<Person>();
        Assertions.assertEquals(myList, meinSkiAusflug.getTeilnehmer());
    }

    @Test
    void checkTeilnehmer(){
        ArrayList<Person> myList = new ArrayList<Person>();
        myList.add(person1);
        myList.add(person2);

        meinSkiAusflug.anmelden(person1);
        meinSkiAusflug.anmelden(person2);

        Assertions.assertEquals(myList, meinSkiAusflug.getTeilnehmer());
    }
    @Test
    @DisplayName("Noch nicht alt genug")
    void checkAnmelden0(){
        Person person3 = new Person("Marvin", 12, true);

        Assertions.assertEquals("Das Mindesalter entspricht 16 Jahren", meinSkiAusflug.anmelden(person3));
     }
    @Test
    @DisplayName("Person die alte genug ist anmelden")
    void checkAnmelden1(){
        Assertions.assertEquals("Matthias wurde angemeldet", meinSkiAusflug.anmelden(person2));
    }

    @Test
    @DisplayName("Zuviele Personen anmelden probieren")
    void checkAnmelden2(){
        Assertions.assertEquals("Matthias wurde angemeldet", meinSkiAusflug.anmelden(person2));
        Assertions.assertEquals("Christoph wurde angemeldet", meinSkiAusflug.anmelden(person1));
        Assertions.assertEquals("Die maximale Teilnehmerzahl von 2 kann nicht überschritten werden", meinSkiAusflug.anmelden(person1));
    }


    @Test
    void checkAbmelden(){
        meinSkiAusflug.anmelden(person1);
        meinSkiAusflug.anmelden(person2);

        Assertions.assertEquals("Matthias wurde abgemeldet", meinSkiAusflug.abmelden(person2));

        ArrayList<Person> myList = new ArrayList<Person>();
        myList.add(person1);

        Assertions.assertEquals(myList, meinSkiAusflug.getTeilnehmer());
    }

    @Test
    void checkBezahlen(){
        Assertions.assertFalse(person2.isBezahlt());
        meinSkiAusflug.bezahlen(person2);
        Assertions.assertTrue(person2.isBezahlt());
    }

    @Test
    void alleBezahlt(){
        meinSkiAusflug.anmelden(person1);
        meinSkiAusflug.anmelden(person2);

        Assertions.assertFalse(meinSkiAusflug.alleBezahlt());
        meinSkiAusflug.bezahlen(person2);
        Assertions.assertTrue(meinSkiAusflug.alleBezahlt());
    }
}