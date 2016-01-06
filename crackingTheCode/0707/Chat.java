public class Chat
{
    public class User
    {
        private long ID;
        private String userName;
        private String password;

        private ArrayList<User> friends;

        public User(long id, String name, String pass)
        {
            ID = id;
            userName = name;
            password = pass;

            users.add(this);
            passwords.add(pass);
        }

        public void addFriend(User u)
        {
            friends.add(u);
        }

        public void chatwith(User u)
        {
            // start their connection and chat...
        }

        public void setPassword(String pass)
        {
            password = pass;
        }

        public long getID()
        {
            return ID;
        }
        public boolean isFriend(User u)
        {
            for (User user : friends)
            {
                if (user.getID() == u.getID())
                    return true;
            }

            return false;
        }
    }

    private static ArrayList<User> users;
    private static ArrayList<String> passwords;

    


    // store the global user and password;
}