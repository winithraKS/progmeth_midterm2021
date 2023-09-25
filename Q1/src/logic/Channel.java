package logic;

import java.util.ArrayList;

public class Channel {
    String name;
    ArrayList<Message> messageList;

    //constructor
    public Channel(String name) {
        setName(name);
        this.messageList = new ArrayList<Message>();
    }

    //getter&setter
    public String getName() {
        return name;
    }

    public ArrayList<Message> getMessageList() {
        return messageList;
    }

    public void setName(String name) {
        if (!name.isBlank()) this.name = name;
        else this.name = "off-topic";
    }

    //methods
    public void addMessage(Message message){
        this.messageList.add(message);
    }

    public int getMessageCount(){
        return this.messageList.size();
    }
}
