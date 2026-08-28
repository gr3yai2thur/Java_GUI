package mid;

public class StreamAccount extends SocialAccount implements LiveControllable{
    private int viewer;
    private int donation;

    StreamAccount(String accountID, String username, int viewer, int donation){
        super(accountID, username);
        this.viewer = viewer;
        this.donation = donation;
    }

    @Override
    public String toString() {
        String details = "";
        if(!isLive){
        details += "Account ID: " + getAcoountID() + " | " +
                   "Username: " + getUsername() + " | " +
                   "isLive: Offline";
        }
        else{
            details +=  "Account ID: " + getAcoountID() + " | " +
                        "Username: " + getUsername() + " | " +
                        "isLive: Live" + " | " +
                        "Viewer: " + viewer + " | " +
                        "Donation: " + donation + "";
        }
        return details;
    }

    @Override
    public boolean isLive() {
        return isLive;
    }

    @Override
    public void toggleLive() {
        if(!isLive){
            isLive = true;
        }
        else{
            isLive = false;
        }
    }
    
}
