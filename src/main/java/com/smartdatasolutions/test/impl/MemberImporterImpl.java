package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MemberImporterImpl implements MemberImporter {

    @Override
    public List<Member> importMembers(File inputFile) throws Exception {

        /*
         * Implement the missing logic
         */
        List<Member> list = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
//            String line = br.readLine();
            String line = "";

            while ((line = br.readLine()) != null) {
//                line = br.readLine();
                String st[] = line.split("\\s+");
                Member member = new Member();
                member.setId(st[0]);
                member.setLastName(st[1]);
                member.setFirstName(st[2]);
                String address = st[3] + " " + st[4] + " " + st[5];
                member.setAddress(address);
                String text = st[6] + " " + st[7] + " " +st[8];

                if (st.length >= 10) {
                    text = text + " " + st[9];
                }
                if (st.length == 11) {
                    text = text + " " + st[10];
                }

                String zipCode = text.substring(text.length()-5);
                String state = text.substring(text.length()-8, text.length()-6);
                String city = text.substring(0,text.length()-9);

                member.setCity(city);
                member.setState(state);
                member.setZip(zipCode);
                list.add(member);
            }
        }
        return list;
    }


}
