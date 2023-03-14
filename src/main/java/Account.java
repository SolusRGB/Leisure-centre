import java.util.*;

public class Account {

    private Membership membershipLevel;

    /**
     * uid = unique identifier for the account
     * Starting at 1 and incrementing by 1 for each new account
     */
    private static int uid = 1;

    /**
     * The unique account number
     */

    private int accountNum;
    /**
     * Using Java's built-in date class to get the current date
     */

    private Date dateCreated;

    /**
     * HashMap to link the accounts to the clients
     */
    HashMap<Integer, Account> accountInfo = new HashMap<>();

    private Member memberInfo;

    private Membership membershipChoice;



    /**
     * Constructor for the account class
     */
    public Account(Date dateCreated, Member memberInfo, Membership membershipChoice) {
        this.accountNum = this.accountNum + uid ++;
        this.memberInfo = memberInfo;
        this.dateCreated = dateCreated;
        this.membershipChoice = membershipChoice;
    }

    /**
     * @Param HashMap<Integer, Account> accountNum
     loops through the HashMap and prints out all the accounts in the HashMap
     */
    public void getAllAccInfo(HashMap<Integer, Account> accountNum) {
        for (HashMap.Entry<Integer, Account> entry : accountInfo.entrySet()) {
            /*
             returns the key of the HashMap and then prints out the account info to the console.
             */
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    /**
     * Checks if the clientInfo is null, if so lets the user know that the information is not available.
     * If it is not null, it prints out the client information.
     * <p>
     * If you try to print information from a List you will only see the memory addressed of each node, rather than the
     * data contained inside the node.
     * <p>
     * Java will call the default method toString() on the object, which will return the memory address of the object.
     * Unless you make your own and override it.
     */
    public String toString() {
        if (memberInfo == null) {
            return "Account information not available.";
        }
        return "Account number: " + accountNum + "\n"
                + "Account holder: " + memberInfo.firstName().toUpperCase() + " " + memberInfo.lastName().toUpperCase()
                + "\n" + "Account address: " + memberInfo.address()
                + "\n" + "Post code: " + memberInfo.postcode()
                + "\n" + "Phone Number: " + memberInfo.phoneNumber()
                + "\n" + "Email: " + memberInfo.email()
                + "\n" + "Membership choice: " + this.membershipChoice
                + "\n" + "Account created on: " + dateCreated + "\n";
    }

    /*
    Getters and setters
     */
    /**
     * Gets the account number
     */
    public int getAccountNum() {
        return this.accountNum;
    }

    public Member getMemberInfo() {
        return memberInfo;
    }

    /**
     * @param level
     * Sets the membership level of the account
     */
    public void setMembershipLevel(Membership level) {
        this.membershipLevel = level;
    }

    public void setMemberInfo(Member memberInfo) {
        this.memberInfo = memberInfo;
    }

    public Membership getMembershipChoice() {
        return membershipChoice;
    }

    public void setMembershipChoice(Membership membershipChoice) {
        this.membershipChoice = membershipChoice;
    }

    public Membership getMembershipLevel() {
        return membershipLevel;
    }
}