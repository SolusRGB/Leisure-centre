import javax.swing.*;
import java.util.Date;

/**
     * <h1>Leisure Centre</h1>
     * <h3>CS5003 –Data Structures and Specialist Programming
     * Individual Coursework 2
     * 2023-03-14</h3>
     *
     * This is a banking application that allows users to create accounts, deposit and withdraw money.
     * While using relevant classes from the Java Collections Framework.
     * The system is to manage bank accounts for an unlimited number of accounts, given an account number display
     * the details of the account and last six transactions SORTED for each account and delete closed accounts.
     *
     * @author  Brandon Eddy id - 20017685
     * @version 1.0
     * @since   2021-02-01
     */



public class Main {
    /**
     * This is the main method which makes use of the GUI class.
     * @param args Unused.
     * @Return Nothing.
     */

    public static void main(String[] args) {
        // title goes in parameter
        JFrame frame = new JFrame("Reservation System");
        GUI gui = new GUI();
        Member newMember = new Member("manager", "manager", "n/a", "n/a"
                , "n/a", "n/a");
        Account account = new Account(new Date(), newMember, Membership.NEW_MEMBER);
        frame.setSize(900, 550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
        gui.welcomeScreen(frame, account);
    }

}
