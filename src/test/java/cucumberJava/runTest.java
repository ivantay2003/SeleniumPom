package cucumberJava;


import org.junit.runner.RunWith; 

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(plugin ={"pretty" , "html:Folder_Name"},
				tags={"@Scenario1"}
		) 

public class runTest {
	

}