package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;

import java.io.IOException;
import java.io.Writer;

public class MemberExporterImpl implements MemberExporter {

    @Override
    public void writeMember(Member member, Writer writer) throws IOException {
        writer.write(member.toCSVString());
    }

    @Override
    public void exportMembers(Map<String, List<Member>> stateMemberMap) throws IOException {
        for (Map.Entry<String, List<Member>> entry : stateMemberMap.entrySet()) {
            String state = entry.getKey();
            List<Member> members = entry.getValue();

            String outputFile = state + "_outputFile.csv";
            try (FileWriter fileWriter = new FileWriter(outputFile);
                 BufferedWriter writer = new BufferedWriter(fileWriter)) {

                writer.write("id,first name,last name,address,city,zip\n");

                for (Member member : members) {
                    writer.write(member.toCSVString());
                    writer.newLine(); /
                }
            }
        }
    }
}

