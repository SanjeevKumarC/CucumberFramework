package stepDefinations;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Resources.base;

public class listeneres implements ITestListener {
	base bs=new base();
		
    public void onFinish(ITestContext result) {					
        // TODO Auto-generated method stub				
        		
    }		
	
    public void onStart(ITestContext result) {					
        // TODO Auto-generated method stub				
    }
 	
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		
	
    public void onTestFailure(ITestResult result) {					
     		try {
				bs.getScreenShot(result.getName());
			} catch (IOException e) {
				e.printStackTrace();
			}
        		
    }		
	
    public void onTestSkipped(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		
		
    public void onTestStart(ITestResult result) {					
        // TODO Auto-generated method stub				
        		
    }		
		
    public void onTestSuccess(ITestResult result) {					
    	// TODO Auto-generated method stub
        		
    }		
	
}




