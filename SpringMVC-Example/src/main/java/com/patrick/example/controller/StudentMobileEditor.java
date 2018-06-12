package com.patrick.example.controller;

import java.beans.PropertyEditorSupport;

public class StudentMobileEditor  extends PropertyEditorSupport  {

	@Override
	public void setAsText(String studentMobile) {
		
		studentMobile = studentMobile.replaceAll("-+|\\s+", "");
		System.out.println("mobile:" +studentMobile);
		setValue(studentMobile);
		
	}
}
