# Scenarios

![alt text](https://github.com/ivantay2003/SeleniumPom/blob/master/screenshot/MapMap.png)


<br><br><br>
Pages in Mind Map. Tick means cover in high level in scenario.
URL for demo automation video (13 min duration)

<br>
Part 1 video : Page convert to POM

https://youtu.be/6jrwvvMJVsM

<br>
Part 2 video : Converting to BDD

https://youtu.be/Y-05jpO_fS8


## Automation Scenario (in youtube)
<br>
Scenario A1
<br>
Individual coverage on a multi trip , select quote 3 (premium). Fill in applicant details and make payment in credit card

-Individual Cover Type

- Multi Trip

- Select Region 1

- Select premium quote 3 (most expansive)

- Fill in Applicant Details (NRIC /DOB / name/ email / mobile) only - Preview Page

- Select Payment Mode DBS / POSB Credit Card - Fill in Credit Card Details

<br>
Scenario A2
<br>
Couple on a single trip (UK) , select quote 3 and fill in applicant / second traveller details.

- Couple Cover Type

- Single Trip / Destination is United Kingdom

- Select premium quote 3 (most expansive)

- Fill in Applicant Details (NRIC /DOB / name/ email / mobile) and fill in for Traveller 2 particular

- Preview Page


<br><br><br>


## BDD Cucumber
<br><br>


@Scenario1
```
	Scenario:Multiple Trip and Individual
		Given User want to buy travel insurance
		    When User want buy a "multiple" trip type
		    And User want select date "5" "6" for destination
		    And User want select "single" cover type
		    And User is "25" years old
		Then Go to quote page
		
		When User  select "third" quote
		Then Proceed to fill in Applicant's detail
		
		When User add NRIC "S8012411B"
		    And User add name "JAMES BROOKE"
		    And User add DOB "01/10/1990"
		    And User add nationality "United Kingdom"
		    And User add email "james_brooke1241231@gmail.com"
		    And User add mobile "6593334444"
		    Then Proceed to Preview Page
		    Then Proceed to Payment Method
		
		When User select "credit card" as payment method
		    And User add credit card number details "5264714241222222"
		    And User add name details "JAMES BROOKE"
		    And User add CVV details "123"
		    And User add credit expiry number details "20/20"
		Then Proceed to make payment
```		
   
<br><br>
<br><br><br>
Please contact me at 
<br>
*https://www.linkedin.com/in/ivantay/*
