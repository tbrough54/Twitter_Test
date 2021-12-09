import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String, AppUsers> usersHashMap = new HashMap<>();

        addNewUser(usersHashMap, "Tom");
        addNewUser(usersHashMap, "Dave");
        addNewUser(usersHashMap, "Cosmin");

        createpost(usersHashMap, "Tom", "very nice weather today");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createpost(usersHashMap, "Tom", "going to play football");


        showPosts(usersHashMap, "Tom");

    }

    public static void addNewUser(HashMap<String, AppUsers> hashMap, String uName){
        hashMap.put(uName, new AppUsers(uName));
    }

    public static void createpost(HashMap<String, AppUsers> hashMap, String key, String message){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        AppUsers user = hashMap.get(key);
        user.posts.put(timestamp, message);
    }

    public static void showPosts(HashMap<String , AppUsers> usersHashMap, String user){
        for(Map.Entry<Timestamp, String> entry : usersHashMap.get(user).posts.entrySet()){
            Timestamp key = entry.getKey();
            String posts = entry.getValue();
            System.out.println(key + " User-" + user + " posted: " + posts);
        }
    }

}
