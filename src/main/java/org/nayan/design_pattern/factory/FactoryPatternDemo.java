package org.nayan.design_pattern.factory;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        Notification notification1 = NotificationFactory.getNotification("email");
        notification1.notifyUser();

        Notification notification2 = NotificationFactory.getNotification("sms");
        notification2.notifyUser();

        Notification notification3 = NotificationFactory.getNotification("push");
        notification3.notifyUser();
    }

  /*  Factory Pattern = Encapsulate object creation logic in one place
    so clients only ask for the object without knowing how it is created.*/
}

/*🧠 Explanation (Step-by-Step)
1️⃣ Common Interface

All notification types implement the same interface.
This helps factory return them interchangeably.

2️⃣ Concrete Implementations

Email/SMS/Push all provide different implementations of the same method.

3️⃣ Factory Class

Contains the object creation logic.
Client does NOT know which class is being created internally.

4️⃣ Client Code

Client simply asks:

NotificationFactory.getNotification("email");


The factory decides:

what to create

how to create

when to create*/