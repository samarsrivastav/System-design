package structural;

// === interface for videoQuality ===
interface VideoQuality {
    String getQuality();
}

// === concrete implementations of VideoQuality ===
class SDQuality implements VideoQuality {
    @Override
    public String getQuality() {
        return "Standard Definition (480p)";
    }
}  
class HDQuality implements VideoQuality {
    @Override
    public String getQuality() {
        return "High Definition (720p)";
    }
}
class FullHDQuality implements VideoQuality {
    @Override
    public String getQuality() {
        return "Full High Definition (1080p)";
    }
}

// ==== abstraction for VideoPlayer ===
abstract class VideoPlayer {
    protected VideoQuality videoQuality;
    public VideoPlayer(VideoQuality videoQuality) {
        this.videoQuality = videoQuality;
    }
    public abstract void play(String videoUrl);
}

// ==== refined abstraction for OnlineVideoPlayer ===
class OnlineVideoPlayer extends VideoPlayer {
    public OnlineVideoPlayer(VideoQuality videoQuality) {
        super(videoQuality);
    }
    @Override
    public void play(String videoUrl) {
        System.out.println("Playing video from " + videoUrl + " in " + videoQuality.getQuality());
    }
}

public class BridgePattern {
    public static void main(String[] args) {
        VideoPlayer sdPlayer = new OnlineVideoPlayer(new SDQuality());
        sdPlayer.play("http://example.com/video1");

        VideoPlayer hdPlayer = new OnlineVideoPlayer(new HDQuality());
        hdPlayer.play("http://example.com/video2");

        VideoPlayer fullHdPlayer = new OnlineVideoPlayer(new FullHDQuality());
        fullHdPlayer.play("http://example.com/video3");

    }
}
