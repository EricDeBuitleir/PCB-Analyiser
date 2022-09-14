package sample;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class myLinkedListTest {
    @BeforeEach
void setUp() {
        validTest = new myLinkedList();

    }

    private myLinkedList validTest;

    @Test
    void addElement() {
validTest.addElement(1);
validTest.addElement(2);
validTest.addElement(3);
validTest.addElement(4);
assertEquals(4, validTest.size()); // If you add 4 elements, there should be 4 elements in the list


    }

    @Test
    void delete() {
        validTest.addElement(1);
        validTest.addElement(2);
        validTest.addElement(3);
        validTest.addElement(4);
        validTest.delete(0);
        assertEquals(3,validTest.size()); // If you add 4 and delete one, there should be 3 left
    }

    @Test
    void get() {
    }

    @Test
    void size() {
        validTest.addElement(1);
        validTest.addElement(2);
        assertEquals(2, validTest.size());

    }

    @Test
    void resetAll() {


    }
}