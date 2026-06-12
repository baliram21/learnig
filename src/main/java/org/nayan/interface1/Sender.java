package org.nayan.interface1;

public class Sender implements EmailSender,SmsSender{
    @Override
    public void send(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Sender sender = new Sender();
        sender.send("start");

        EmailSender email = new Sender();
        email.send("email");

        SmsSender sms = new Sender();
        sms.send("sms");
    }
}
