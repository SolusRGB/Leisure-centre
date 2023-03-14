import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Objects;

public class GUI extends JFrame {

    /**
     * Image for the logo
     * Made private not to expose resources publicly.
     */
    private final String image = "src/main/resources/images/bear.png";

    /**
         create new screen methods for each screen, set all buttons on each screen to call the next screen method
         action listener for buttons for sign in for example and link to your sign in screen method/frame.

         - use set bounds to place items around your frame
         - on back buttons add the method for the frame you want to go back to.
         - on successful login, add JOptionPane to say login successful and then call the next screen method.
         */

    /**
     remakes the frame and sets the content pane to the home panel and then sets the frame to visible
     */
    public void remakeScreen(JFrame frame, JPanel panel) {
        panel.setLayout(null);
        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    /**
     * Main GUI. Initial screen user sees.
    */
    public void welcomeScreen(JFrame frame, Account account) {
        JPanel f = new JPanel();
        f.setBackground(Color.darkGray);
        f.setSize(800, 550);
        f.setVisible(true);

        JLabel imgLogo = new JLabel(new ImageIcon(image));
        imgLogo.setBounds(350, 150, 200, 200);
        f.add(imgLogo);

        //---------------------------------Creating Labels------------------------------------------
        JLabel l_welcome = new JLabel("Welcome to the Leisure Centre");
        l_welcome.setFont(new Font("Helvetica", Font.PLAIN, 34));
        l_welcome.setBounds(220,50,500, 40);
        l_welcome.setForeground(Color.white);
        f.add(l_welcome);


        //-------------------------------------Creating Buttons--------------------------------------
        JButton btn_enter = new JButton("Enter");
        btn_enter.setFont(new Font("Helvetica", Font.PLAIN, 18) );
        btn_enter.setForeground(Color.black);
        btn_enter.setBounds(398,400,110, 40);
        f.add(btn_enter);


        //---------------------------------------button functionality-------------------------------
        /*
        If enough time add sign in / sign out capabilities
         */
        btn_enter.addActionListener(e -> homeScreen(frame, account));


        remakeScreen(frame, f);
    }

    /**
     * Main screen after user enters banking application.
     */
    public void homeScreen(JFrame frame, Account account) {
        JPanel f = new JPanel();
        f.setBackground(Color.darkGray);
        f.setSize(800, 550);
        f.setVisible(true);

        JLabel imgLogo = new JLabel(new ImageIcon(image));
        imgLogo.setBounds(350, 30, 200, 200);
        f.add(imgLogo);


        //-------------------------------------Creating Buttons--------------------------------------

        JButton btn_createAcc = new JButton("Sign up");
        btn_createAcc.setFont( btn_createAcc.getFont().deriveFont(18f) );
        btn_createAcc.setForeground(Color.black);
        btn_createAcc.setBounds(180,240,210, 40);
        f.add(btn_createAcc);

        JButton btn_manageAcc = new JButton("Facilities");
        btn_manageAcc.setFont( btn_manageAcc.getFont().deriveFont(18f) );
        btn_manageAcc.setForeground(Color.black);
        btn_manageAcc.setBounds(510,240,210, 40);
        f.add(btn_manageAcc);

        JButton btn_back = new JButton("Back");
        btn_back.setFont( btn_back.getFont().deriveFont(18f) );
        btn_back.setForeground(Color.black);
        btn_back.setBounds(180,350,210, 40);
        f.add(btn_back);

        JButton btn_pitchReserve = new JButton("Pitch reservation");
        btn_pitchReserve.setFont( btn_pitchReserve.getFont().deriveFont(18f) );
        btn_pitchReserve.setForeground(Color.black);
        btn_pitchReserve.setBounds(510,350,210, 40);
        f.add(btn_pitchReserve);

        //---------------------------------------button functionality-------------------------------

            btn_back.addActionListener(e -> welcomeScreen(frame, account));
            btn_createAcc.addActionListener(e -> createAccScreen(frame, account));
            btn_pitchReserve.addActionListener(e -> pitchReservation(frame, account));

        remakeScreen(frame, f);
    }

    /**
     * Screen for creating a new account.
     */
    public void createAccScreen(JFrame frame, Account account) {
        JPanel f = new JPanel();
        f.setBackground(Color.darkGray);
        f.setSize(800, 550);
        f.setVisible(true);

        JLabel imgLogo = new JLabel(new ImageIcon(image));
        imgLogo.setBounds(350, 30, 200, 200);
        f.add(imgLogo);

        //---------------------------------Creating Labels------------------------------------------
        JLabel l_createAcc = new JLabel("Create Account");
        l_createAcc.setFont( l_createAcc.getFont().deriveFont(30f) );
        l_createAcc.setBounds(340,20,250, 40);
        l_createAcc.setForeground(Color.white);
        f.add(l_createAcc);

        //-----------------------------------Creating TextFields------------------------------------
        JTextField tf_firstName = new JTextField("First Name");
        tf_firstName.setBounds(180,240,210, 40);
        f.add(tf_firstName);

        JTextField tf_lastName = new JTextField("Last Name");
        tf_lastName.setBounds(510,240,210, 40);
        f.add(tf_lastName);

        JTextField tf_address = new JTextField("Address");
        tf_address.setBounds(180,280,210, 40);
        f.add(tf_address);

        JTextField tf_postCode = new JTextField("Post Code");
        tf_postCode.setBounds(180,320,210, 40);
        f.add(tf_postCode);

        JTextField tf_email = new JTextField("Email");
        tf_email.setBounds(510,280,210, 40);
        f.add(tf_email);

        JTextField tf_phoneNum = new JTextField("Phone Number");
        tf_phoneNum.setBounds(510,320,210, 40);
        f.add(tf_phoneNum);

        // Initialize the membership combo box with the enum values
        JComboBox<Membership> membershipComboBox = new JComboBox<>(Membership.values());
        membershipComboBox.setBounds(190,170,210, 40);
        // Add the membership combo box to the GUI
        f.add(membershipComboBox);


        //-------------------------------------Focus Listeners--------------------------------------
        // Adds a focus listener to the text field to allow the text to disappear for the user to type in.

        tf_firstName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tf_firstName.getText().equals("First Name")) {
                    tf_firstName.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tf_firstName.getText().isEmpty()) {
                    tf_firstName.setText("First Name");
                }
            }
        });

        tf_lastName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tf_lastName.getText().equals("Last Name")) {
                    tf_lastName.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tf_lastName.getText().isEmpty()) {
                    tf_lastName.setText("Last Name");
                }
            }
        });

        tf_address.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf_address.getText().equals("Address")) {
                    tf_address.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(tf_address.getText().isEmpty()) {
                    tf_address.setText("Address");
                }
            }
        });

        tf_postCode.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf_postCode.getText().equals("Post Code")) {
                    tf_postCode.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(tf_postCode.getText().isEmpty()) {
                    tf_postCode.setText("Post Code");
                }
            }
        });

        tf_email.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(tf_email.getText().equals("Email")) {
                    tf_email.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(tf_email.getText().isEmpty()) {
                    tf_email.setText("Email");
                }
            }
        });

        tf_phoneNum.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (tf_phoneNum.getText().equals("Phone Number")) {
                    tf_phoneNum.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (tf_phoneNum.getText().isEmpty()) {
                    tf_phoneNum.setText("Phone Number");
                }
            }
        });


        membershipComboBox.addActionListener(e -> {
            Membership selectedLevel = (Membership) membershipComboBox.getSelectedItem();
            account.setMembershipLevel(selectedLevel);
        });



        //-------------------------------------Creating Buttons--------------------------------------

        JButton btn_back = new JButton("Back");
        btn_back.setFont( btn_back.getFont().deriveFont(18f) );
        btn_back.setForeground(Color.black);
        btn_back.setBounds(180,380,210, 40);
        f.add(btn_back);

        JButton btn_confirmAcc = new JButton("Confirm account");
        btn_confirmAcc.setFont( btn_confirmAcc.getFont().deriveFont(18f) );
        btn_confirmAcc.setForeground(Color.black);
        btn_confirmAcc.setBounds(510,380,210, 40);
        f.add(btn_confirmAcc);


        //---------------------------------------button functionality-------------------------------

        btn_confirmAcc.addActionListener(e -> {

            try {
                 /*
                   Creates a new account with the information provided by the user.
                   We retrieve the information from the text fields and pass it to the Account class.
                  */

                String firstName = tf_firstName.getText();
                String lastName = tf_lastName.getText();
                String address = tf_address.getText();
                String postCode = tf_postCode.getText();
                String phoneNumber = tf_phoneNum.getText();
                String userEmail = tf_email.getText();
                Membership membershipChoice = (Membership) membershipComboBox.getSelectedItem();
                Membership membership = Membership.valueOf(String.valueOf(membershipChoice));


                if (firstName.equals("First Name") || lastName.equals("Last Name") || address.equals("Address")
                        || membershipChoice == null || postCode.equals("Post Code")
                        || phoneNumber.equals("Phone Number") || userEmail.equals("Email") ) {
                    JOptionPane.showMessageDialog(null, "Please fill out all fields");
                } else {
                    int dialogButton = JOptionPane.YES_NO_OPTION;
                    int dialogResult = JOptionPane.showConfirmDialog(null,
                            "Is this information correct?\n" +
                            "First Name: " + firstName + "\n" +
                            "Last Name: " + lastName + "\n" +
                            "Address: " + address + "\n" +
                            "Post Code: " + postCode + "\n" +
                            "Phone Number: " + phoneNumber + "\n" +
                            "Email: " + userEmail + "\n" +
                            "Membership Choice: " + membershipChoice,
                            "Confirm Account", dialogButton);
                    if (dialogResult == JOptionPane.YES_OPTION) {

                        Member newMember = new Member(firstName, lastName, address, postCode, phoneNumber, userEmail);
                        Account newAccount = new Account(new Date(), newMember, membership);
                        account.accountInfo.put(newAccount.getAccountNum(), newAccount);

                        JOptionPane.showMessageDialog(null, "Account created successfully."
                                + "\n\n" + account.accountInfo);

                        // console testing
                        System.out.println("*Account created successfully, displaying accounts created:*" + "\n");
                        account.getAllAccInfo(account.accountInfo);

                    } else {
                        JOptionPane.showMessageDialog(null, "Account creation cancelled");
                    }
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number");
            }
        });

        btn_back.addActionListener(e -> homeScreen(frame, account));

        remakeScreen(frame, f);
    }

    public void pitchReservation(JFrame frame, Account account) {
        JPanel f = new JPanel();
        f.setBackground(Color.darkGray);
        f.setSize(800, 550);
        f.setVisible(true);

        JLabel imgLogo = new JLabel(new ImageIcon(image));
        imgLogo.setBounds(350, 30, 200, 200);
        f.add(imgLogo);


        //-------------------------------------Creating Buttons--------------------------------------

        JButton btn_reqReservation = new JButton("Request Reservation");
        btn_reqReservation.setFont( btn_reqReservation.getFont().deriveFont(18f) );
        btn_reqReservation.setForeground(Color.black);
        btn_reqReservation.setBounds(180,240,210, 40);
        f.add(btn_reqReservation);

        JButton btn_makePayment = new JButton("Make Payment");
        btn_makePayment.setFont( btn_makePayment.getFont().deriveFont(18f) );
        btn_makePayment.setForeground(Color.black);
        btn_makePayment.setBounds(510,240,210, 40);
        f.add(btn_makePayment);

        JButton btn_back = new JButton("Back");
        btn_back.setFont( btn_back.getFont().deriveFont(18f) );
        btn_back.setForeground(Color.black);
        btn_back.setBounds(180,350,210, 40);
        f.add(btn_back);

        JButton btn_pitchCheck = new JButton("Check available pitches");
        btn_pitchCheck.setFont( btn_pitchCheck.getFont().deriveFont(14f) );
        btn_pitchCheck.setForeground(Color.black);
        btn_pitchCheck.setBounds(510,350,210, 40);
        f.add(btn_pitchCheck);

        //---------------------------------------button functionality-------------------------------

        btn_back.addActionListener(e -> welcomeScreen(frame, account));
        btn_reqReservation.addActionListener(e -> welcomeScreen(frame, account));
        btn_pitchCheck.addActionListener(e -> welcomeScreen(frame, account));
        btn_makePayment.addActionListener(e -> welcomeScreen(frame, account));

        remakeScreen(frame, f);
    }

    
}

