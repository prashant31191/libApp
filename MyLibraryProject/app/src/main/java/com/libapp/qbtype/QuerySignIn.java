package com.libapp.qbtype;

/**
 * Created by prashant.patel on 5/24/2017.
 */

public class QuerySignIn {
    private QBUser user;

    private QuerySignIn() {
        this.getParser().initParser(QBUserWrap.class, StringifyArrayList.class, new QBStringifyArrayListDeserializer());
    }


    public QuerySignIn(QBUser user) {
        this();
        this.user = user;
        this.setOriginalObject(user);
    }
}
