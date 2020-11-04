package org.example.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.example.util.GebruikerStatus.ACTIEF;
import static org.junit.jupiter.api.Assertions.*;

class GebruikerTest {

    @Test
    void getId() {

        //if
        Gebruiker e = new Gebruiker("pietje123", "wachtwoord", ACTIEF);

        //when
        e.getId();

        //then
        assertEquals(1, e.getId());

    }
}