package org.addressbook.main;

import org.addressbook.storage.*;
import org.addressbook.textutils.TextUtils;
import org.addressbook.ui.cli.menu.Menu;
import org.addressbook.ui.cli.menu.MenuAction;

public class SimpleApplication {
    private SimpleMutableList<Contact> list;
    private Menu menu = new Menu("Contact book");

    public SimpleApplication() {
        list = new SimpleAddressBook();
        list.load();
        System.out.println(list.numberOfEntries() + " items loaded from file.");
    }

    private void createMenu() {
        list.load();
        list.save();

        menu.addMenuItem("Add contacts", new MenuAction() {
            @Override
            public void onItemSelected() {
                String name = TextUtils.askFor("Enter the name of your new contact. ");
                String nr = TextUtils.askFor("Enter the phone number of your new contact.");
                String mail = TextUtils.askFor("Enter the email address of your new contact.");
                String address = TextUtils.askFor("Enter the address of your contact. ");


                System.out.println("Contact name is " + name);
                System.out.println("Contact phone number is " + nr);
                System.out.println("Contact email address is " + mail);
                System.out.println("Contact address is " + address);

                Contact a1 = new Contact(name, nr, mail);
                list.addEntry(a1);
                list.save();

            }
        });

        menu.addMenuItem("List contacts", new MenuAction()

        {
            public void onItemSelected() {
                list.listEntries();

                {
                    {

                    }

                }
            }
        });

    }


    public void start() {
        createMenu();
        menu.start();
    }
}

