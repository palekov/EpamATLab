package com.epam.multy.module.module1;

import com.epam.multy.module.module2.Abonent;

public class Caller {
    public static void main(String[] args) {
        Abonent abonent = new Abonent();
        abonent.writeDown(args[0]);
    }
}
