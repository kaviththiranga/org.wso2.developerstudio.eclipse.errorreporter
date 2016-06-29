/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.developerstudio.eclipse.errorreporter.ui.dialog;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class UserInputDialog extends TitleAreaDialog {

	private Text name;
	private String NameStr;
	
	private Text email;
	private String EmailStr;
	
	private Text gmailPassword;
	private String gmailPasswordStr;
	
	private Text jiraUsername;
	private String jiraUsernameStr;

	private Text jiraPassword;




	public UserInputDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	public void create() {
		super.create();
		setTitle("Report Developer Studio Errors");
		setMessage(
				"Thank you for enabling Developer studio automated error reporting tool. Please eneter your contact details.",
				IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout = new GridLayout(2, false);
		container.setLayout(layout);

		createName(container);
		createEmail(container);
		createPassword(container);
		createJiraUsername(container);
		createJiraPassword(container);
		
		Composite container2 = new Composite(area, SWT.NONE);
		container2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		GridLayout layout2 = new GridLayout(1, false);
		container2.setLayout(layout2);
		
		createSendingOptions(container2);
		createAnoOptions(container2);

		return area;
	}
	

	private void createName(Composite container) {
		Label lbtFirstName = new Label(container, SWT.NONE);
		lbtFirstName.setText("Name");

		GridData dataFirstName = new GridData();
		dataFirstName.grabExcessHorizontalSpace = true;
		dataFirstName.horizontalAlignment = GridData.FILL;

		name = new Text(container, SWT.BORDER);
		name.setLayoutData(dataFirstName);
	}

	private void createEmail(Composite container) {
		Label lbtLastName = new Label(container, SWT.NONE);
		lbtLastName.setText("Gmail");

		GridData dataLastName = new GridData();
		dataLastName.grabExcessHorizontalSpace = true;
		dataLastName.horizontalAlignment = GridData.FILL;
		email = new Text(container, SWT.BORDER);
		email.setLayoutData(dataLastName);
	}

	
	private void createPassword(Composite container) {
		Label lbtPassword = new Label(container, SWT.NONE);
		lbtPassword.setText("Gmail password");

		GridData dataPassword = new GridData();
		dataPassword.grabExcessHorizontalSpace = true;
		dataPassword.horizontalAlignment = GridData.FILL;
		gmailPassword = new Text(container, SWT.BORDER);
		gmailPassword.setLayoutData(dataPassword);
	}
	
	private void createJiraUsername(Composite container) {
		Label lbtPassword = new Label(container, SWT.NONE);
		lbtPassword.setText("Jira Username");

		GridData dataJiraUsername = new GridData();
		dataJiraUsername.grabExcessHorizontalSpace = true;
		dataJiraUsername.horizontalAlignment = GridData.FILL;
		jiraUsername = new Text(container, SWT.BORDER);
		jiraUsername.setLayoutData(dataJiraUsername);
	}
	
	private void createJiraPassword(Composite container) {
		Label lbtPassword = new Label(container, SWT.NONE);
		lbtPassword.setText("Jira Password");

		GridData dataJiraPassword = new GridData();
		dataJiraPassword.grabExcessHorizontalSpace = true;
		dataJiraPassword.horizontalAlignment = GridData.FILL;
		jiraPassword = new Text(container, SWT.BORDER);
		jiraPassword.setLayoutData(dataJiraPassword);
	

	}
	
	private void createSendingOptions(Composite container) {

		
		Label lbtPassword = new Label(container, SWT.NONE);
		lbtPassword.setText("Select Sending options");



	    Button[] radios = new Button[3];

	    radios[0] = new Button(container, SWT.RADIO);
	    radios[0].setSelection(true);
	    radios[0].setText("Create an issue in Jira");


	    radios[1] = new Button(container, SWT.RADIO);
	    radios[1].setText("Create an issue in Jira and send an email");


	    
	}
	
	
	private void createAnoOptions(Composite container) {

		
		Label lbtPassword = new Label(container, SWT.NONE);
		lbtPassword.setText("Select Anonymizing options");
	    
	    Button[] radios2 = new Button[3];

	    radios2[0] = new Button(container, SWT.CHECK);
	    radios2[0].setText("Anonymize package, class and method names");
	    
	    radios2[1] = new Button(container, SWT.CHECK);
	    radios2[1].setText("Anonymize error log");

	    
	}
	@Override
	protected boolean isResizable() {
		return true;
	}

	// save content of the Text fields because they get disposed
	// as soon as the Dialog closes
	private void saveInput() {
		NameStr = name.getText();
		EmailStr = email.getText();
		gmailPasswordStr=gmailPassword.getText();

	}

	@Override
	protected void okPressed() {
		saveInput();
		super.okPressed();
	}

	public String getName() {
		return NameStr;
	}

	public String getEmail() {
		return EmailStr;
	}
}