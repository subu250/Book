package edu.matc.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void nameIsNotEmpty() {
        Book book = new Book( null, "Adv-Java", 4 );

        Set<ConstraintViolation<Book>> constraintViolations =
                validator.validate(book);

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "Please enter name",
                constraintViolations.iterator().next().getMessage());

    }
    @Test
    public void titleNameTooShort() {
        Book book = new Book( "Subu", "Ad", 4);

        Set<ConstraintViolation<Book>> constraintViolations =
                validator.validate( book );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "size must be between 3 and 15",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void bookCountLow() {
        Book book = new Book( "Subu", "Adv-Java", 1 );

        Set<ConstraintViolation<Book>> constraintViolations =
                validator.validate( book );

        assertEquals( 1, constraintViolations.size() );
        assertEquals(
                "must be greater than or equal to 3",
                constraintViolations.iterator().next().getMessage()
        );
    }

    @Test
    public void bookValidation() {
        Book book = new Book( "Subu", "Adv-Java", 2 );

        Set<ConstraintViolation<Book>> constraintViolations =
                validator.validate( book );

        assertEquals( 1, constraintViolations.size() );
    }
}