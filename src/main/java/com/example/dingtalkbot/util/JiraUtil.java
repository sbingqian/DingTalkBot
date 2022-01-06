package com.example.dingtalkbot.util;

import com.example.dingtalkbot.constant.JiraTransIdCons;
import net.rcarz.jiraclient.*;

public class JiraUtil {
    private static Issue issue;

    public static void main(String[] args) {

        BasicCredentials creds = new BasicCredentials("", "");
        JiraClient jira = new JiraClient("", creds);

        try {

//            Issue.SearchResult sr = jira.searchIssues("issuetype = 研发测试Task AND resolution = Unresolved AND assignee=shenbingqian order by updated DESC");
//            System.out.println("Total: " + sr.total);
//            for (Issue i : sr.issues)
//                System.out.println("Result: " + i);





            /* Retrieve issue TEST-123 from JIRA. We'll get an exception if this fails. */
            Issue issue = jira.getIssue("NKHD-855");
//            /* Print the issue key. */
//            System.out.println("status: " + issue.getField("status"));

            // customfield_14007 "2022-01-05"
            // customfield_11746 "2022-01-05"
            // customfield_11606 "2022-01-05"

            issue.transition().execute(JiraTransIdCons.DEV_TASK_EXECUTE);




        } catch (JiraException ex) {
            System.err.println(ex.getMessage());
            if (ex.getCause() != null)
                System.err.println(ex.getCause().getMessage());
        }


    }
}
