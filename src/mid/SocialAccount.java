package mid;

public abstract class SocialAccount {
    private String acoountID;
    private String username;
    protected boolean isLive;
    
    public SocialAccount(String accountID, String username){
        this.acoountID = accountID;
        this.username = username;
    }

    public abstract String toString();

    public String getAcoountID() {
        return acoountID;
    }

    public void setAcoountID(String acoountID) {
        this.acoountID = acoountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
}
