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

package org.wso2.developerstudio.eclipse.errorreporter.ui.menu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.osgi.service.log.LogEntry;
import org.osgi.service.log.LogListener;
import org.wso2.developerstudio.eclipse.errorreporter.other.EmailSender;
import org.wso2.developerstudio.eclipse.errorreporter.other.ErrorInformation;
import org.wso2.developerstudio.eclipse.errorreporter.other.ErrorReporter;
import org.wso2.developerstudio.eclipse.errorreporter.other.InfoCollector;
import org.wso2.developerstudio.eclipse.errorreporter.other.RemoteJiraConnector;
import org.wso2.developerstudio.eclipse.errorreporter.other.ReportGenerator;
import org.wso2.developerstudio.eclipse.errorreporter.ui.dialog.ErrorNotificationDialog;


//this is a sample class

//only used for testing
//no relevance to dev studio error reporter plug-in


//import org.wso2.developerstudio.eclipse.errorreporter.other.RemoteJiraConnector;
//import org.eclipse.jface.dialogs.MessageDialog;
//import org.wso2.developerstudio.eclipse.errorreporter.Activator;
////import org.eclipse.ui.IWorkbenchWindow;
////import org.eclipse.ui.handlers.HandlerUtil;
//import org.wso2.developerstudio.eclipse.errorreporter.ui.dialog.ErrorNotifyDialog;
//import org.eclipse.swt.widgets.Shell;
//import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 *
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SampleHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public SampleHandler() {
	}


	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
	
		Shell shell = new Shell();
	
		try {
		      String s = null;
		      System.out.println(s.length());
		    } catch (NullPointerException e) {
		      // build the error message and include the current stack trace
		      MultiStatus status = createMultiStatus(e.getLocalizedMessage(), e);
		      ErrorReporter er=new ErrorReporter(status);
		      er.reportError();
		      // show error dialog
//		      InfoCollector ic=new InfoCollector(status);
//		      ErrorInformation ei=ic.getInformation();
//		      ReportGenerator r=new ReportGenerator(ei);
//		      r.storeReport(ei);
//		     // System.out.println(ei.getMessage()+" "+ei.getCode()+" "+ei.getComment()+" "+ei.getEclipseBuildId()+" "+ei.getExceptionS()+" "+ei.getEmail()+" "+ei.getOsgiArch());
//		      int i=ErrorNotificationDialog.openError(shell, "A problem was detected", "An unexpected error occured. Please press send to report the error to the development team", ic.getInformation(),status);

		    }
		return event;
	}
	
	
	private static MultiStatus createMultiStatus(String msg, Throwable t) {

	    List<Status> childStatuses = new ArrayList<>();
	    StackTraceElement[] stackTraces = Thread.currentThread().getStackTrace();

	     for (StackTraceElement stackTrace: stackTraces) {
	      Status status = new Status(IStatus.ERROR,
	          "org.wso2.developerstudio.eclipse", stackTrace.toString());
	      childStatuses.add(status);
	    }

	    MultiStatus ms = new MultiStatus("org.wso2.developerstudio.eclipse",
	        IStatus.ERROR, childStatuses.toArray(new Status[] {}),
	        t.toString(), t);
	    return ms;
	  }
}
