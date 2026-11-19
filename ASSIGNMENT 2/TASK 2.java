import java.util.*;

public class PlaylistManager {
    public static void main(String[] args) {
        System.out.println("=== Task 2: Music Playlist Editor & Up Next Queue Benchmark ===");

        List<String> mainPlaylist = new ArrayList<>();
        mainPlaylist.add("Song 1: Blinding Lights");
        mainPlaylist.add("Song 2: Levitating");
        mainPlaylist.add("Song 3: Starboy");
        mainPlaylist.add("Song 4: Save Your Tears");

        System.out.println("\n[Main Playlist - ArrayList]");
        System.out.println("Total Songs: " + mainPlaylist.size());
        System.out.println("Accessing 3rd song directly (Index 2): " + mainPlaylist.get(2));

        Deque<String> upNextQueue = new ArrayDeque<>();
        upNextQueue.addLast("Track A: As It Was");
        upNextQueue.addLast("Track B: Anti-Hero");
        upNextQueue.addFirst("Priority Track: Flowers");

        System.out.println("\n[Up Next Queue - ArrayDeque]");
        System.out.println("Current Queue: " + upNextQueue);
        
        String nextSong = upNextQueue.pollFirst();
        System.out.println("Now Playing from Up Next: " + nextSong);
        System.out.println("Remaining Up Next Queue: " + upNextQueue);
    }
}
