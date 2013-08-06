package com.cognizant.cmobile.impl.service;

import java.beans.FeatureDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.cmobile.api.service.LoadDataService;
import com.cognizant.cmobile.impl.model.AccountDetails;
import com.cognizant.cmobile.impl.model.Billing;
import com.cognizant.cmobile.impl.model.Customer;
import com.cognizant.cmobile.impl.model.MyBill;
import com.cognizant.cmobile.impl.model.OtherNetworkConsumer;
import com.cognizant.cmobile.impl.model.Plan;
import com.cognizant.cmobile.impl.model.PlanFeature;
import com.cognizant.cmobile.impl.repository.AccountDetailsRepository;
import com.cognizant.cmobile.impl.repository.BillingRepository;
import com.cognizant.cmobile.impl.repository.CustomerRepository;
import com.cognizant.cmobile.impl.repository.MyBillRepository;
import com.cognizant.cmobile.impl.repository.OtherNetworkConsumerRepository;
import com.cognizant.cmobile.impl.repository.PlanRepository;

@Service
public class LoadDataServiceImpl implements LoadDataService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountDetailsRepository accountDetailsRepository;

	@Autowired
	BillingRepository billingRepository;

	@Autowired
	MyBillRepository myBillRepository;

	@Autowired
	OtherNetworkConsumerRepository otherNetworkConsumerRepository;

	@Autowired
	PlanRepository planRepository;

	public void loadData() throws ParseException {

		populateCustomer();
		populateAccountDetails();
		populateBilling();
		populateMyBill();
		populateOtherNEtworkConsumer();
		populatePlan();
	}

	private void populateCustomer() throws ParseException {
		customerRepository.deleteAll();
		JSONArray jsonArray = new JSONArray(
				"[{\"username\" : \"admin\", \"password\" : \"admin\", \"mobile\" : \"1111111111\"}, {\"username\" : \"guest\", \"password\" : \"guest\", \"mobile\" : \"2222222222\"}]");
		Customer customer;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
			customer = new Customer();
			customer.setUsername(jsonObject.getString("username"));
			customer.setPassword(jsonObject.getString("password"));
			customer.setMobile(Long.parseLong(jsonObject.getString("mobile")));
			customerRepository.save(customer);
		}
	}

	private void populateAccountDetails() throws ParseException {
		accountDetailsRepository.deleteAll();

		JSONArray jsonArray = new JSONArray(
				"[{\"mobile\" : \"1111111111\", \"accountNo\" : \"ASDER123TY45\", \"address\" : \"Pune\", \"email\" : \"dummy@dummy.com\", \"activationDate\" : \"25-Aug-2010\", \"billingDate\" : \"25th of every month\"}, {\"mobile\" : \"2222222222\", \"accountNo\" : \"JKIJS434YU56\", \"address\" : \"Pune\", \"email\" : \"dummy@dummy.com\", \"activationDate\" : \"20-Sep-2010\", \"billingDate\" : \"20th of every month\"}]");
		AccountDetails accountDetails;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
			accountDetails = new AccountDetails();
			accountDetails.setAccountNo(jsonObject.getString("accountNo"));
			accountDetails.setActivationDate(jsonObject
					.getString("activationDate"));
			accountDetails.setAddress(jsonObject.getString("address"));
			accountDetails.setBillingDate(jsonObject.getString("billingDate"));
			accountDetails.setEmail(jsonObject.getString("email"));
			accountDetails.setMobile(Long.parseLong(jsonObject
					.getString("mobile")));
			accountDetailsRepository.save(accountDetails);
		}
	}

	private void populateBilling() throws ParseException {
		billingRepository.deleteAll();

		JSONArray jsonArray = new JSONArray(
				"[{\"mobile\" : \"1111111111\", \"month\" : \"Jun\", \"monthSeq\" : 6, \"year\" : 2012, \"billAmount\" : 589.00, \"totalUsage\" : 1900.00, \"minutes\" : 225.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Jul\", \"monthSeq\" : 7, \"year\" : 2012, \"billAmount\" : 545.00, \"totalUsage\" : 2089.00, \"minutes\" : 250.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Aug\", \"monthSeq\" : 8, \"year\" : 2012, \"billAmount\" : 550.00, \"totalUsage\" : 1689.00, \"minutes\" : 550.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Sep\", \"monthSeq\" : 9, \"year\" : 2012, \"billAmount\" : 600.00, \"totalUsage\" : 1789.00, \"minutes\" : 550.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Oct\", \"monthSeq\" : 10, \"year\" : 2012, \"billAmount\" : 500.00, \"totalUsage\" : 1589.00, \"minutes\" : 450.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Nov\", \"monthSeq\" : 11, \"year\" : 2012, \"billAmount\" : 300.00, \"totalUsage\" : 1089.00, \"minutes\" : 350.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Dec\", \"monthSeq\" : 12, \"year\" : 2012, \"billAmount\" : 400.00, \"totalUsage\" : 1289.00, \"minutes\" : 400.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Jan\", \"monthSeq\" : 1, \"year\" : 2013, \"billAmount\" : 500.00, \"totalUsage\" : 1589.00, \"minutes\" : 450.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Feb\", \"monthSeq\" : 2, \"year\" : 2013, \"billAmount\" : 600.00, \"totalUsage\" : 1789.00, \"minutes\" : 550.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Mar\", \"monthSeq\" : 3, \"year\" : 2013, \"billAmount\" : 650.00, \"totalUsage\" : 1850.00, \"minutes\" : 600.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Apr\", \"monthSeq\" : 4, \"year\" : 2013, \"billAmount\" : 450.00, \"totalUsage\" : 1325.00, \"minutes\" : 400.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"May\", \"monthSeq\" : 5, \"year\" : 2013, \"billAmount\" : 600.00, \"totalUsage\" : 1789.00, \"minutes\" : 550.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Jun\", \"monthSeq\" : 6, \"year\" : 2013, \"billAmount\" : 555.00, \"totalUsage\" : 1600.00, \"minutes\" : 505.00},"
						+ "{\"mobile\" : \"1111111111\", \"month\" : \"Jul\", \"monthSeq\" : 7, \"year\" : 2013, \"billAmount\" : 489.00, \"totalUsage\" : 1289.00, \"minutes\" : 439.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Jun\", \"monthSeq\" : 6, \"year\" : 2012, \"billAmount\" : 489.00, \"totalUsage\" : 1200.00, \"minutes\" : 175.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Jul\", \"monthSeq\" : 7, \"year\" : 2012, \"billAmount\" : 445.00, \"totalUsage\" : 1589.00, \"minutes\" : 200.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Aug\", \"monthSeq\" : 8, \"year\" : 2012, \"billAmount\" : 450.00, \"totalUsage\" : 1189.00, \"minutes\" : 500.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Sep\", \"monthSeq\" : 9, \"year\" : 2012, \"billAmount\" : 500.00, \"totalUsage\" : 1289.00, \"minutes\" : 500.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Oct\", \"monthSeq\" : 10, \"year\" : 2012, \"billAmount\" : 400.00, \"totalUsage\" : 1089.00, \"minutes\" : 400.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Nov\", \"monthSeq\" : 11, \"year\" : 2012, \"billAmount\" : 200.00, \"totalUsage\" : 589.00, \"minutes\" : 300.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Dec\", \"monthSeq\" : 12, \"year\" : 2012, \"billAmount\" : 300.00, \"totalUsage\" : 789.00, \"minutes\" : 350.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Jan\", \"monthSeq\" : 1, \"year\" : 2013, \"billAmount\" : 400.00, \"totalUsage\" : 1089.00, \"minutes\" : 400.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Feb\", \"monthSeq\" : 2, \"year\" : 2013, \"billAmount\" : 500.00, \"totalUsage\" : 1289.00, \"minutes\" : 500.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Mar\", \"monthSeq\" : 3, \"year\" : 2013, \"billAmount\" : 550.00, \"totalUsage\" : 1350.00, \"minutes\" : 550.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Apr\", \"monthSeq\" : 4, \"year\" : 2013, \"billAmount\" : 350.00, \"totalUsage\" : 825.00, \"minutes\" : 350.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"May\", \"monthSeq\" : 5, \"year\" : 2013, \"billAmount\" : 500.00, \"totalUsage\" : 1289.00, \"minutes\" : 500.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Jun\", \"monthSeq\" : 6, \"year\" : 2013, \"billAmount\" : 455.00, \"totalUsage\" : 1100.00, \"minutes\" : 455.00},"
						+ "{\"mobile\" : \"2222222222\", \"month\" : \"Jul\", \"monthSeq\" : 7, \"year\" : 2013, \"billAmount\" : 389.00, \"totalUsage\" : 789.00, \"minutes\" : 409.00}]");
		Billing billing;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
			billing = new Billing();
			billing.setBillAmount(Double.parseDouble(jsonObject
					.getString("billAmount")));
			billing.setMinutes(Double.parseDouble(jsonObject
					.getString("minutes")));
			billing.setMobile(Long.parseLong(jsonObject.getString("mobile")));
			billing.setMonth(jsonObject.getString("month"));
			billing.setMonthSeq(Long.parseLong(jsonObject.getString("monthSeq")));
			billing.setTotalUsage(Long.parseLong(jsonObject
					.getString("totalUsage")));
			billing.setYear(Long.parseLong(jsonObject.getString("year")));
			billingRepository.save(billing);
		}
	}

	private void populateMyBill() throws ParseException {
		myBillRepository.deleteAll();
		JSONArray jsonArray = new JSONArray(
				"[{\"mobile\" : \"1111111111\", \"lastBill\" : 489, \"lastBillDate\" : \"25 Jun 2013\", \"lastBillDueDate\" : \"10 Jul 2013\", \"lastPaymentDate\" : \"9 Jul 2013\", \"lastPayment\" : \"400\", \"recentCharges\" : \"50\", \"nextBillDate\" : \"25 Jul 2013\", \"lastBillFlag\" : \"true\", \"lastPaymentFlag\" : \"true\", \"makePaymentFlag\" : \"true\", \"dataUsageFlag\" : \"true\", \"minutesUsed\" : \"970\", \"totalMinutes\" : \"2000\", \"dataUsed\" : \"678\", \"totalData\" : \"1000\"},"
						+ "{\"mobile\" : \"2222222222\", \"lastBill\" : 589, \"lastBillDate\" : \"25 Apr 2013\", \"lastBillDueDate\" : \"10 May 2013\", \"lastPaymentDate\" : \"8 May 2013\", \"lastPayment\" : \"500\", \"recentCharges\" : \"98\", \"nextBillDate\" : \"25 May 2013\", \"lastBillFlag\" : \"true\", \"lastPaymentFlag\" : \"true\", \"makePaymentFlag\" : \"true\", \"dataUsageFlag\" : \"true\", \"minutesUsed\" : \"450\", \"totalMinutes\" : \"2000\", \"dataUsed\" : \"234\", \"totalData\" : \"1000\"}]");
		MyBill myBill;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
			myBill = new MyBill();
			myBill.setDataUsageFlag(new Boolean(jsonObject
					.getString("dataUsageFlag")));
			myBill.setDataUsed(Long.parseLong(jsonObject.getString("dataUsed")));
			myBill.setLastBill(Double.parseDouble(jsonObject
					.getString("lastBill")));
			myBill.setLastBillDate(jsonObject.getString("lastBillDate"));
			myBill.setLastBillDueDate(jsonObject.getString("lastBillDueDate"));
			myBill.setLastBillFlag(new Boolean(jsonObject
					.getString("lastBillFlag")));
			myBill.setLastPayment(Double.parseDouble(jsonObject
					.getString("lastPayment")));
			myBill.setLastPaymentDate(jsonObject.getString("lastPaymentDate"));
			myBill.setLastPaymentFlag(new Boolean(jsonObject
					.getString("lastPaymentFlag")));
			myBill.setMakePaymentFlag(new Boolean(jsonObject
					.getString("makePaymentFlag")));
			myBill.setMinutesUsed(Long.parseLong(jsonObject
					.getString("minutesUsed")));
			myBill.setMobile(Long.parseLong(jsonObject.getString("mobile")));
			myBill.setNextBillDate(jsonObject.getString("nextBillDate"));
			myBill.setRecentCharges(Double.parseDouble(jsonObject
					.getString("recentCharges")));
			myBill.setTotalData(Long.parseLong(jsonObject
					.getString("totalData")));
			myBill.setTotalMinutes(Long.parseLong(jsonObject
					.getString("totalMinutes")));
			myBillRepository.save(myBill);
		}
	}

	private void populateOtherNEtworkConsumer() throws ParseException {
		otherNetworkConsumerRepository.deleteAll();
		JSONArray jsonArray = new JSONArray(
				"[{\"mobile\" : \"1111111111\", \"otherNetworkMobile\" : [\"Patrick (8908089090)\", \"John (6321788213)\", \"Miller (1238092130)\"]},"
						+ "{\"mobile\" : \"2222222222\", \"otherNetworkMobile\" : [\"Robert (9876554097)\", \"Synthya (9102930393)\", \"Veronica (2930123900)\"]}]");
		OtherNetworkConsumer otherNetworkConsumer;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
			otherNetworkConsumer = new OtherNetworkConsumer();
			otherNetworkConsumer.setMobile(Long.parseLong(jsonObject
					.getString("mobile")));
			JSONArray jsonArray2 = new JSONArray(
					jsonObject.getString("otherNetworkMobile"));
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < jsonArray2.length(); j++) {
				list.add(jsonArray2.getString(j));
			}
			otherNetworkConsumer.setOtherNetworkMobile(list);
			otherNetworkConsumerRepository.save(otherNetworkConsumer);

		}
	}

	private void populatePlan() throws ParseException {
		planRepository.deleteAll();
		JSONArray jsonArray = new JSONArray(
				"[{\"name\":\"CR399\",\"description\":\"Monthly Rental 399\",\"mobile\":\"1111111111\",\"features\":[{\"name\":\"Onnet call rate\",\"rate\":10.0,\"unit\":\"paise/minute\",\"visible\":true},{\"name\":\"Offnet call rate\",\"rate\":30.0,\"unit\":\"paise/minute\",\"visible\":true},{\"name\":\"Offnet SMS rate\",\"rate\":10.0,\"unit\":\"paise/SMS\",\"visible\":true},{\"name\":\"Onnet SMS rate\",\"rate\":1.0,\"unit\":\"paise/SMS\",\"visible\":true},{\"name\":\"Data rate\",\"rate\":20.0,\"unit\":\"paise/KB\",\"visible\":false}]},"
						+ "{\"name\":\"CR599\",\"description\":\"Monthly Rental 599\",\"mobile\":\"2222222222\",\"features\":[{\"name\":\"Onnet call rate\",\"rate\":5.0,\"unit\":\"paise/minute\",\"visible\":true},{\"name\":\"Offnet call rate\",\"rate\":25.0,\"unit\":\"paise/minute\",\"visible\":true},{\"name\":\"Offnet SMS rate\",\"rate\":5.0,\"unit\":\"paise/SMS\",\"visible\":true},{\"name\":\"Onnet SMS rate\",\"rate\":0.50,\"unit\":\"paise/SMS\",\"visible\":true},{\"name\":\"Data rate\",\"rate\":15.0,\"unit\":\"paise/KB\",\"visible\":false}]}]");
		Plan plan;
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject = new JSONObject(jsonArray.get(i).toString());
			plan = new Plan();
			plan.setDescription(jsonObject.getString("description"));
			plan.setMobile(Long.parseLong(jsonObject.getString("mobile")));
			plan.setName(jsonObject.getString("name"));
			JSONArray jsonArray2 = new JSONArray(
					jsonObject.getString("features"));
			List<PlanFeature> list = new ArrayList<PlanFeature>();
			for (int j = 0; j < jsonArray2.length(); j++) {
				JSONObject jsonObject2 = new JSONObject(jsonArray2.getString(j));
				PlanFeature planFeature = new PlanFeature();
				planFeature.setName(jsonObject2.getString("name"));
				planFeature.setRate(Double.parseDouble(jsonObject2.getString("rate")));
				planFeature.setUnit(jsonObject2.getString("unit"));
				planFeature.setVisible(new Boolean(jsonObject2.getString("visible")));
				list.add(planFeature);
			}
			plan.setFeatures(list);
			planRepository.save(plan);
		}
	}

}