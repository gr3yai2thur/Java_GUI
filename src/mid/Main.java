package mid;


public class Main {
    public static void main(String[] args) {
        GamerAccount gamerAccount = new GamerAccount("42879225", "KuroSensei", 1000);
        StreamAccount streamAccount = new StreamAccount("42879225", "KuroSensei", 100000, 1000000);

        gamerAccount.toggleLive();
        streamAccount.toggleLive();
        System.out.println(gamerAccount.toString());
        System.out.println(streamAccount.toString());
    }
}