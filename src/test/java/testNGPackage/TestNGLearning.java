package testNGPackage;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGLearning {
	
			@BeforeTest(description = "I am welcoming everyone..")
			public void greetings_Of_the_Day()
			{
				System.out.println("Hello...!!\nGreetings of the Day !!");
			}


				@Test//(dependsOnMethods = "greetings_Of_the_Day")
				public void myPersonalInfo()
				{
					System.out.println("First of all I would like to introduce about myself..");
					System.out.println("I am : 'Avinash Tukaram Ambavale'");
					System.out.println("I am from Pune and currently lives in Katraj.");
				}
				
				@Test
				public void pause()
				{
					System.out.println("This was about myself...! So let me take you through my work experience..");
				}
				
				@Test(description = "This is my WorkExperince..")
				public void workExp()
				{
					System.out.println("So starting with overall workexperience...\nI have total 7 years of experience."
							+ "\n.however my technical domain experience is 5years.\n.Basically I had join Wipro as my first company and there i had joined as dupport engineer."
							+ "\n& TechMahindra is my second company and here I have completed 5 years so far and working as Sr.Test Engineer.");
				}
				
				@Test
				public void rolesAndResponsibilities()
				{
					System.out.println("Currently I'm working as Sr Test Engineer. along with that I am working as Test lead as well"
							+"\nSO as test lead my responsibilities are..\n1.Prepare the TestPlan.\n2.Allocate the task to the Team"
							+ "\n3.Arrange the Calls with business.\n4.Get the Test results reviewed from business. and get those approved as well."
							+ "\n5.Upload the TestResults on the shared path.");
				}
				
				@Test(enabled = false)
				public void myProject()
				
				{
					System.out.println("So far which ever project I have worked upon was Telecom domain project."
							+ "\nAnd my current project is also Telecom project\nBelow is the list of project...!!!"
							+ "\n1.CIU WFT\n2.British Telecom (E2E)\n3.Collection Desktop (BT)");
				}
}