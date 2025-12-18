package structural;

import java.util.HashMap;
import java.util.Map;

interface VideoDownloader {
    void display(String videoUrl);
}

// ============ Real Video Downloader =============
class RealVideoDownloader implements VideoDownloader{

    @Override
    public void display(String videoUrl) {
        System.out.println("Downloading video from: " + videoUrl);
    }

}

// ======= cache proxy implementation =======
class CachedVideoDownloader implements VideoDownloader {
    private RealVideoDownloader realDownloader;
    private Map<String, String> cache;

    public CachedVideoDownloader() {
        this.realDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }
    @Override
    public void display(String videoUrl) {
        if (cache.containsKey(videoUrl)) {
            System.out.println("Fetching video from cache: " + videoUrl);
        } else {
            realDownloader.display(videoUrl);
            cache.put(videoUrl, videoUrl);
        }
    }       
}



public class ProxyPattern {
    public static void main(String[] args) {
        VideoDownloader videoDownloader = new CachedVideoDownloader();

        // First time download
        videoDownloader.display("http://example.com/video1");
        videoDownloader.display("http://example.com/video2");

        // Fetching from cache
        videoDownloader.display("http://example.com/video1");
        videoDownloader.display("http://example.com/video2");
    }
}
