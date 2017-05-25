package com.libapp.qbtype;

/**
 * Created by prashant.patel on 5/24/2017.
 */

public class QBUsers {

    private QBUsers() {
    }

    public static Performer<QBUser> signIn(QBUser user) {
        return new QuerySignIn(user);
    }
}
