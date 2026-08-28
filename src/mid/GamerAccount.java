package mid;

public class GamerAccount extends SocialAccount implements LiveControllable{
    private int rankPoint;

    public GamerAccount(String accountID, String username, int rankPoint){
        super(accountID, username);
        this.rankPoint = rankPoint;
    }

    @Override
    public String toString() {
        String details = "";
        if(!isLive){
        details += "Account ID: " + getAcoountID() + " | " +
                   "Username: " + getUsername() + " | " +
                   "isLive: Offline\n";
        }
        else{
            details +=  "Account ID: " + getAcoountID() + " | " +
                        "Username: " + getUsername() + " | " +
                        "isLive: Live" + " | " +
                        "Rank Point: " + rankPoint + "\n";
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
