package org.pages;

import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Report {
public static void main(String[] args) {
	Result rc = JUnitCore.runClasses(Mainpage.class);
	System.out.println("RunCount "+rc.getRunCount());
	System.out.println();
	System.out.println("FailureCount "+rc.getFailureCount());
	System.out.println();
	System.out.println("IgnoreCount "+rc.getIgnoreCount());
	System.out.println();
	System.out.println("RunTime "+rc.getRunTime());
	System.out.println();
	System.out.println("Was successfull "+rc.wasSuccessful());
	System.out.println();
	
	List<Failure> failures = rc.getFailures();
	for (int i = 0; i < failures.size(); i++) {
		System.out.println(failures.get(i));
		System.out.println(failures.get(i).getMessage());
		System.out.println(failures.get(i).getException());
		System.out.println(failures.get(i).getTestHeader());
		
	}
	}
}

