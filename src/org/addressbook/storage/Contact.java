package org.addressbook.storage;

import java.io.Serializable;

/**
 * This class describes a Contact (for instance an entry in an
 * address book). The class implements Serializable (so that
 * Contact instances can be saved) and Comparable (so that
 * Contact instances in a list can be sorted).
 * <p>
 * Contact instances are immutable, which means that you cannot change
 * the state of an instance of Contact. Every call to methods for
 * changing an attribute of a Contact, such as changeName(), will
 * result in a new Contact with a state representing the old Contact
 * but with a new value for (in this case) name.
 */

public final class Contact implements Serializable, Comparable<Contact> {

  /*
   * Contacts are immutable, so the instance variables could
   * be declared final. But for simplicity, we skip this in
   * this version.
   */

    private String name;
    private String email;
    private String phone;

    /**
     * Constructs a new Contact, using the arguments for the state.
     *
     * @param name  The name of this Contact (a name is a simple String with both
     *              first name and last name)
     * @param email The email address of this Contact
     * @param phone The phone number of this Contact
     */
    public Contact(String name, String email, String phone) {


        if (name == null) throw new NullPointerException("The name can't be null!");
        if (name.equals("")) throw new IllegalArgumentException("The name has no content!");
        this.name = name;

        if (email == null) email = ("");
        this.email = email;

        if (phone == null) phone = ("");
        this.phone = phone;

        this.name = name;
        this.email = email;
        this.phone = phone;

/*
     * Constructor second version:
     * Now, just saving the parameters is not enough.
     * Start the constructor with an if-statement
     * to see if name is null. If so, throw a NullPointerException.
     * Next, write an if-statement checking if the name equals "".
     * If so, throw an IllegalArgumentException.
     * Next, save name in the instance variable.
     * Next, check if email is null, if so save "" in the
     * instance variable.
     * Next, check if phone is null, if so save "" in the
     * instance variable.
     * Done! Run the test again to see if also the constructor
     * with null tests pass!
     */

    /*
     * Constructor, first version:
     * Save the parameters in the variables! Run the
     * Test to see if it worked./*
*/


    }


    /**
     * Returns the name of this contact, as a reference to a String
     *
     * @return the name of this contact
     */
    public String name() {

        return name;

    }

    /**
     * Returns the email of this contact, as a reference to a String
     *
     * @return the email of this contact
     */
    public String email() {


        return email;
    }

    /**
     * Returns the phone number of this contact, as a reference to a String
     *
     * @return the phone number of this contact
     */
    public String phone() {


        return phone;
    }

    /**
     * Changes the name of this Contac by returning a new Contact reflecting this change
     */
    public Contact changeName(String newName) {
        return new Contact(newName, email, phone);
    }

    /**
     * Changes the email of this Contac by returning a new Contact reflecting this change
     */
    public Contact changeEmail(String newEmail) {
        return new Contact(name, newEmail, phone);
    }

    /**
     * Changes the phone number of this Contac by returning a new Contact reflecting this change
     */
    public Contact changePhone(String newPhone) {
        return new Contact(name, email, newPhone);
    }

    /**
     * Returns a String representation of this Contact on the form "Name Email Phone"
     *
     * @return A reference to a String representing this Contact
     */
    @Override
    public String toString() {
        return name + " " + email + " " + phone;
    }

    /**
     * Compares this Contact with another Contact lexicograhpically, using only the name for comparison.
     * See java.lang.String for an explanation on how Strings are compared.
     */
    @Override
    public int compareTo(Contact other) {
        if (other == null) throw new NullPointerException("");
        return name.compareTo(other.name);

        // TODO: Implement a correct version of compareTo().
        // You should only care about the name, so use the compareTo in java.lang.String
        // on the name variables only.

    }
   /*Task 1.3 Finish the compareTo() method
    In order for a list of contacts to be sortable, we have
    decided that Contact should implement the Comparable<Contact> interface.
    This is a small interface which only declares one method, public int compareTo(Contact other) .
    The only part of a contact that should be considered when comparing two Contacts is the name
            (which is a simple String reference). Now, the good news is that Strings are Comparable,
    so we only have to do two things in the method body for compareTo:
    Check if the parameter other is null, in which case we throw a NullPointerException
  return the result of using compareTo between this object’s name and other’s name
    Run the tests for Contact again and verify that you have passed the tests for compareTo().
            */

    /**
     * Compares this Contact to the Specified object. The result is true if and only if the argument is not null
     * and is a Contact object that represents the same name as this Contact.
     *
     * @return true if the given object represents a Contact with exactly the same name as this object, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) return false;
        else if (!(other instanceof Contact)) return false;

        Contact a = (Contact) other;
        return a.name.equals(this.name);



        /*
        Create a local reference variable of type reference to Contact and assign it the
        other parameter cast to a reference to Contact
        Return the result of the local variable’s name equals this object’s name
        Run the tests again and verify that the equals test also passes.*/
            /* TODO:
     * Implement a proper version of equals() where
     * you only care about whether the name is equal to
     * the name of the other object (everything else may differ).
     *
     * These are the steps:
     * 1. if other is null or not an instance of Contact,
     *    return false.
     * 2. Cast other to a Contact reference and
     *    use the version of equals in java.lang.String on the
     *    name variables of both objects.
     */

    }

    /**
     * Returns a hashcode for this Contact, using only the name of this contact.
     *
     * @return a hashcode for this Contact.
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
