/*
  assumptions:
  basic chat server to support a small number of users
  user has contact list, can see who is online vs offline
  can send messages to friends
  don't worry about group chat, voice chat now
  conact lists are mutual -> I can only talk to you if you can talk to me 
*/
public class Server
{
    enum StatusType {online, offline, away}

    public class Status 
    {
        StatusType status_type;
        String status_message;
    }

    public class User 
    {
        String userName;
        String displayName;
        User [] contact_list;
        AddRequest [] requests;
        boolean updateStatus(StatusType stype, String message)
        {

        }

        boolean addUserWithUserName(String name)
        {

        }

        boolean approveRequest(String name)
        {

        }

        boolean denyRequest(String name)
        {

        }

        boolean removeContact(String username)
        {

        }

        boolean sednMessage(String username, String message)
        {

        }
        // I think constructor is also needed here
    }

    public class AddRequest
    {
        User from_user;
        User to_user;
    }

    User getUserByUserName(String username);

}