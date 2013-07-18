package org.cmobile.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cognizant.cmobile.api.model.FormResponse;
import com.cognizant.cmobile.api.service.BillingService;

@Controller
public class BillingController {

	@Autowired
	BillingService billingService;

	@RequestMapping(value = "/billingHistoryData")
	public @ResponseBody
	FormResponse billingHistoryData() throws Exception {
		FormResponse formResponse = new FormResponse();
		formResponse.setStatus("Pass");
		formResponse.setResult(billingService.getBillingHistory());
		return formResponse;
	}

	@RequestMapping(value = "/minuteDataUsageData")
	public @ResponseBody
	FormResponse minuteDataUsageData() throws Exception {
		FormResponse formResponse = new FormResponse();
		formResponse.setStatus("Pass");
		formResponse.setResult(billingService.getBillingHistory());
		return formResponse;
	}

	@RequestMapping(value = "/monthlyItemisedBill/{month}/{year}")
	public @ResponseBody
	void monthlyItemisedBill(@PathVariable long year,
			@PathVariable String month, HttpServletResponse response) {
		InputStream is = null;
		OutputStream os = null;
		String errorMsg = new String("");
		try {
			os = response.getOutputStream();
			is = billingService.getItemisedMonthlyBill(month, year);
			if (null != is) {
				response.setContentType("application/pdf");
				response.setHeader("Content-Disposition",
						"filename=\"mobileBill_" + year + "_" + month
								+ ".pdf\";");

				byte[] b = new byte[1024];
				int len = 0;
				while ((len = is.read(b)) != -1) {
					os.write(b, 0, len);
				}
			} else {
				response.setContentType("text/html; charset=ISO-8859-1");
				os.write("<h2><font color=\"red\">No Bill Exists</font></h2>"
						.getBytes());
			}
		} catch (FileNotFoundException fnfe) {
			errorMsg = "No Bill Exists";
		} catch (IOException ioe) {
			errorMsg = "No Bill Exists";
		} finally {
			try {
				response.setContentType("text/html; charset=ISO-8859-1");
				os.write(("<h2><font color=\"red\">" + errorMsg + "</font></h2>")
						.getBytes());
				if (null != is) {
					is.close();
				}
				if (null != os) {
					os.close();
				}
			} catch (IOException ie) {

			}
		}
	}
}
