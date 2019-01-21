package com.example.module2.composition;

import com.example.ThreadUtils;
import rx.Observable;
import rx.schedulers.Schedulers;

public class CompositionExample {

    public static void main(String[] args) {
        //  Create and sync on an object that we will use to make sure we don't
        // hit the System.exit(0) call before our threads have had a chance
        // to complete
        Object waitMonitor = new Object();
        synchronized (waitMonitor) {
            UserService userService = new UserService();

            // Write out a little snippet to make the json look nice, just as an example
            System.out.println("{ \"userList\": [ ");

            // Call the user service and fetch the list of users
            Observable.from(userService.fetchUserList())
                    // Go through the events asynchronously and eliminate administrators
                    .parallel(userObservable ->
                            userObservable.filter(user ->
                                    user.getSecurityStatus() != UserSecurityStatus.ADMINISTRATOR))
                    .toSortedList((u1, u2) -> u1.getSecurityStatus().compareTo(u2.getSecurityStatus()))
                    .subscribeOn(Schedulers.io())
                    .doOnCompleted(() -> {
                        synchronized (waitMonitor) {
                            waitMonitor.notify();
                        }
                    }).subscribe(userList -> userList.forEach(user -> System.out.println(user.toJSON())));
            ThreadUtils.wait(waitMonitor);
            System.out.println("]}");
        }
        System.exit(0);
    }

}
