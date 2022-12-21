package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.io.Writer;
import java.util.*;

public class Main extends MemberFileConverter {

    @Override
    protected MemberExporter getMemberExporter() {
        // TODO
        return new MemberExporterImpl();
    }

    @Override
    protected MemberImporter getMemberImporter() {
        // TODO
        return new MemberImporterImpl();
    }

    @Override
    protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {
        // TODO
        Map<String, Member> map = new HashMap<>();
        for (Member m : membersFromFile) {
            if (!map.containsKey(m.getId())) {
                map.put(m.getId(), m);
            }
        }
        List<Member> list = new ArrayList<>();
        for (Map.Entry<String, Member> e : map.entrySet()) {
            if (e.getValue() != null) {
                list.add(e.getValue());
            }
        }

        return list;
    }

    @Override
    protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
        // TODO
        Map<String, List<Member>> listMap = new HashMap<>();
        for (int i = 0; i < validMembers.size(); i++) {
            Member member1 = validMembers.get(i);
            List<Member> memberList = new ArrayList<>();
            for (int j = 1; j < validMembers.size(); j++) {
                Member member2 = validMembers.get(j);
                if (member1.getState().equals(member2.getState())) {
                    memberList.add(member2);
                }
            }
            listMap.put(member1.getState(), memberList);
        }

        return listMap;
    }

    public static void main(String[] args) throws Exception {
        //TODO
        Main main = new Main();
        File file = new File("Members.txt");
        File directory = new File("./output");
        if (!directory.exists()) {
            directory.mkdir();
        }
        String outputPath = "./output";
        String outputFileName = "outputFile.csv";
        main.convert(file, outputPath, outputFileName);
    }

}
