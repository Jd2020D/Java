import java.util.HashMap;

public class Hashmatique{
    public static void main(String args[]){
        HashMap<String, String> trackList    = new HashMap<String, String>();
        trackList.put("A Poison Tree", "I was angry with my friend");
        trackList.put("Two In The Campagna", "We sat down on the grass, to stray");
        trackList.put("Daddy", "You do not do, you do not do");
        trackList.put("Happiness", "I'm near the window with coffee");
        System.out.println(trackList.get("Daddy"));
        for (String track : trackList.keySet()) {
            System.out.println(track+" : "+trackList.get(track));
        }
    }

}