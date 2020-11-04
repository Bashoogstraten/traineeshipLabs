package org.example.dao;

import org.example.domain.Employee;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeDaoTest {

    @Mock
    private EntityManager emMock/* = Mockito.mock(EntityManager.class)*/;

    @InjectMocks
    private EmployeeDao target/* = new EmployeeDao(emMock)*/;

    @Mock
    private EntityTransaction transactionMock;

    @Mock
    private Employee employeeMock;

    @Test
    void save() {
        //given
        when(emMock.getTransaction()).thenReturn(transactionMock);

        //when
        target.save(employeeMock);

        //then
        verify(transactionMock).begin();
        verify(emMock).persist(eq(employeeMock));
        verify(transactionMock).commit();


    }

    @Test
    void remove() {

        long idMock = 34565L;

        //given
        when(emMock.getTransaction()).thenReturn(transactionMock);
        when(emMock.find(eq(Employee.class), eq(idMock))).thenReturn(employeeMock);

        //when
        target.delete(idMock);

        //when
        verify(transactionMock).begin();
        verify(emMock).remove(eq(employeeMock));
        verify(transactionMock).commit();

    }
}