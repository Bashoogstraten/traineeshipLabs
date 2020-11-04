package org.example.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstracteGebruiker {

    @Id
    @GeneratedValue
    protected long id;

    public long getId() {

        return id;
    }

}

