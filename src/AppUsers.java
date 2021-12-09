import java.sql.Timestamp;
import java.util.*;

public class AppUsers {

    String username;
    Set<String> following;
    Set<String> followers;
    SortedMap<Timestamp, String> posts;

    AppUsers(String name){
        username = name;
        following = new HashSet<>();
        followers = new HashSet<>();
        posts = new TreeMap<>();
    }

}
