
@Quote
Feature: Quote
 
		
	@Scenario1
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
		