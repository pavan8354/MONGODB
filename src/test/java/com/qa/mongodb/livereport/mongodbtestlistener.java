package com.qa.mongodb.livereport;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.logging.Logger;

import com.mongodb.client.MongoCollection;

public class mongodbtestlistener implements ITestListener {
	
	MongoCollection<Document> webCollection;
	MongoClient mongoClient;

	public void onTestStart(ITestResult result) {
		
		
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		String classname = result.getMethod().getRealClass().getName();
		
		Document d1 = new Document();
		d1.append("methodName", methodname);
		d1.append("className", classname);
		d1.append("status", "PASS");
		
		List<Document> linksDocList = new ArrayList<Document>();
		linksDocList.add(d1);
		
		webCollection.insertMany(linksDocList);
			
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		String methodname = result.getMethod().getMethodName();
		String classname = result.getMethod().getRealClass().getName();
		
		Document d1 = new Document();
		d1.append("methodName", methodname);
		d1.append("className", classname);
		d1.append("status", "FAIL");
		
		List<Document> linksDocList = new ArrayList<Document>();
		linksDocList.add(d1);
		
		webCollection.insertMany(linksDocList);
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");

		mongoClient = MongoClients.create("mongodb://localhost:27017");

		MongoDatabase database = mongoClient.getDatabase("automationdb");
		// create collection:
		webCollection = database.getCollection("Live");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		mongoClient.close();
		

}
}
