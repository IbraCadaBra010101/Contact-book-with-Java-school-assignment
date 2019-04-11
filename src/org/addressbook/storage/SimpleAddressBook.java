package org.addressbook.storage;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is an implemenation of {@link SimpleMutableList}
 * and typed for {@link Contact} elements.
 * <p>
 * For storage of the address book, it will use a file with
 * serialized {@link Contact} objects. The file will be created
 * (or assumed to exist) in <code>$HOME/.address_book</code>
 * (where $HOME is the user's home directory).
 * <p>
 * If there are any exceptions thrown during file I/O, these will
 * be logged to <code>$HOME/.address_book.log</code> for reference.
 */
public class SimpleAddressBook implements SimpleMutableList<Contact> {

    private static final String LOG_FILE = System.getProperty("user.home") + System.getProperty("file.separator") + ".address_book.log";


    private static final String ADDRESS_FILE = System.getProperty("user.home") + System.getProperty("file.separator") + ".address_book";

    private List<Contact> entries;

    public SimpleAddressBook() {
        entries = new ArrayList<>();
    }

    public int numberOfEntries() {
        return entries.size();
    }

    /**
     * Creates a new SimpleAddressBook with an empty list of {@link Contact} elements.
     * /*Add a statement which adds the parameter c to the internal list called entries
     * Explanation: The SimpleAddressBook class maintains an internal List<Contact> in an
     * instance variable called entries.
     * <p>
     * This means that the add(Contact c) method simply
     * stores the parameter c in this internal list, using the method add(E) from the
     * java.util.List interface. Check the online API docs to verify that the java.util.List
     * interface has an add() method if you don’t believe us! In fact, check the online API docs,
     * anyway, since it is good practice.
     * Run the tests again and verify that the first test now passes:
     */

    public void listEntries() {
        List<Contact> copy = new ArrayList<>(entries);
        Collections.sort(copy);
        for (Contact c : copy) {
            System.out.println(c);
        }
    }

    public void addEntry(Contact c) {
        this.entries.add(c);

        System.out.println("You must implement addEntry(Contact c)");
        System.out.println("In class org.addressbook.storage.SimpleAddressBook");


    }

    public boolean contains(Contact c) {
        return entries.contains(c);
    }


    /*
     * Log exception in the application logfile.
     *
     * This method exists so that we can log exceptions
     * for the developers to investigate. This allows us
     * to hide the Java specific texts of the exceptions
     * from the user and show the users some meaningful
     * text instead.
     */
    private void logException(Exception e) {
        try {
            e.printStackTrace(new PrintWriter(new FileWriter(LOG_FILE), true));
        } catch (Exception logErr) {
            System.err.print("Could not log exception: ");
            System.err.println(e.getMessage());
            logErr.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void load() {
        try {
            if (!new File(ADDRESS_FILE).exists()) {
                System.out.println("INFO: There is no address book file.");
                return;
            }
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ADDRESS_FILE));
            Contact c;
            entries = (List<Contact>) in.readObject();
            in.close();
        } catch (Exception e) {
            // Write a user friendly error message,
            // log the exception, and,
            // rethrow the exception as a RuntimeException
            // to be handle by the Main class.
            System.err.println("Could not load address book");
            logException(e);
            throw new RuntimeException("Your address book is corrupted.");
        }
    }

    public void save() {
        try {
            System.out.println("Saving in " + ADDRESS_FILE + "...");
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ADDRESS_FILE));
            out.writeObject(entries);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
