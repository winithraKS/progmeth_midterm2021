package logic;

import java.util.ArrayList;

public class Server {
    private String name;
    private User owner;
    private ArrayList<Channel> channelList;
    private ArrayList<User> memberList;

    public Server(String name, User owner, TemplateType template) {
        this.owner = owner;
        this.channelList = new ArrayList<Channel>();
        this.memberList = new ArrayList<User>();

        addUser(owner);

        setName(name);

        switch (template) {
            case BASIC -> {addChannel(owner, "general"); break;}
            case STUDY -> {addChannel(owner,"homework-help"); break;}
            case GAMING -> {addChannel(owner,"gaming"); break;}
        }
    }

    //getter&setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank()) {
            this.name = owner.getName() + " home";
        } else this.name = name;
    }

    public User getOwner() {
        return owner;
    }


    public ArrayList<Channel> getChannelList() {
        return channelList;
    }

    public ArrayList<User> getMemberList() {
        return memberList;
    }

    //methods
    public Channel addChannel(User user, String channelName) {
        if (user == getOwner()) {
            Channel c = new Channel(channelName);
            channelList.add(c);
            return c;
        }
        return null;
    }

    public User addUser(User user) {
        if (!memberList.contains(user)) {
            memberList.add(user);
            user.addJoinedServersList(this);
            return user;
        } else return null;
    }

    public boolean kickUser(User kicker, User kicked) throws Exception {
        if (!(kicker == getOwner())) throw new Exception();
        if (!memberList.contains(kicked) || kicked == this.owner) return false;
        kicked.getJoinedServersList().remove(this);
        memberList.remove(kicked);
        return true;
    }
}
