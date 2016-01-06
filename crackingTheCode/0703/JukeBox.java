public class JukeBox
{
    public class CD
    {
        // CD information, name (contend is within the CD)
    }

    public class Song
    {
        private String songName;
    }

    public class User
    {
        private String userName;
        private long ID;
        
        public User(String name, long id)
        {
            userName = name;
            ID = id;
        }

        public String getName()
        {
            return userName;
        }

        public void setName(String name)
        {
            userName = name;
        }

        public long getID()
        {
            return ID;
        }


        public User getUser()
        {
            return this;
        }
        public static User addUser(String name, long id)
        {
            // 
        }

    }

    public class TrackSelector
    {
        private Song currentSong;

        public TrackSelector(Song s)
        {
            currentSong = s;
        }

        public void setTrack(Song s)
        {
            currentSong = s;
        }

        public Song getCurrentSong()
        {
            return currentSong;
        }
    }

    public class PlayList
    {
        private Song track;
        private Queue<Song> queue;
        public PlayList(Song song, Queue<Song> queue)
        {
            track = song;
            this.queue = queue;
        }

        public Song getNextTrack()
        {
            return queue.peek();
            // return queue.dequeue();
        }

        public void queueUpTrack(Song song)
        {
            queue.enqueue(song);
        }
    }

    public class CDplayer
    {
        private PlayList playlist;
        private CD cd;
        public CDplayer(PlayList playlist, CD cd)
        {
            this.palylist = playlist;
            this.cd = cd;
        }

        public CDplayer(PlayList p)
        {
            playlist = p;
        }

        public CDplayer(CD c)
        {
            cd.c;
        }

        public PlayList getPlaylist()
        {
            return playlist;
        }

        public void setPlayList(PlayList p)
        {
            playlist = p;
        }

        public CD getCD()
        {
            return cd;
        }


        public void setCD(CD c)
        {
            cd = c;
        }

        public void playTrack(Song song)
        {
            // paly the song, and perhaps pop the queue corresponding to the palylist
        }

    }

    private CDplayer cdPalyer;
    private User user;
    private Set<CD> cdCollection;
    private TrackSelector tracksel;

    public JukeBox(CDpalyer player, User user, Set<CD> set, TrackSelector ts)
    {
        cdPalyer = player;
        this.user = user;
        cdCollection = set;
        tracksel = ts;
    }

    public Song getCurrentTrack()
    {
        return tracksel.getCurrentSong();
    }

    public void processOneUser(User user)
    {
        this.user = user;
        // actually I don't know
        
    }

}