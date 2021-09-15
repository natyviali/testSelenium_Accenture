Feature: Validate Email Message
    This feature validates if email successful message is showing up

Background:
    Given Enter URL

Scenario: Vehicle Insurance Application
    When Enter Vehicle Data as "<Make>" "<Model>" "<Cylinder>" "<Engine>" "<DateOfManufacture>" "<NumberOfSeats>" "<RightHandDrive>" "<NumberOfSeatsMotorcycle>" "<Fuel>" "<Payload+Weight>" "<Price>" "<Mileage>"
        And Click Next From "Enter Insurant Data" Tab
    When Enter Insurant Data as "<FirstName>" "<LastName>" "<DateOfBirth>" "<Gender>" "<Country>" "<ZipCode>" "<Occupation>" "<Hobbies>"
        And Click Next From "Enter Product Data" Tab
    When Enter Product Data as "<InsuranceSum>" "<MeritRating>" "<DamageInsurance>" "<Optionals>" "<CourtesyCar>"
        And Click Next From "Select Price Option" Tab
    When Select Price Option as "<PriceOption>"
        And Click Next From "Send Quote" Tab
    When Enter Send Quote Data as "test@automation.com" "Test" "Nv12345"
        And Click Send
    Then Verify Email Successful Message To Be "Sending e-mail success!"
 
 Examples:
 | Make | Model   | Cylinder | Engine | DateOfManufacture | NumberOfSeats | RightHandDrive | NumberOfSeatsMotorcycle | Fuel   | Payload+Weight | Price | Mileage | FirstName | LastName | DateOfBirth | Gender | Country | ZipCode  | Occupation | Hobbies | InsuranceSum | MeritRating | DamageInsurance | Optionals       | CourtesyCar | PriceOption |
 | BMW  | Scooter | 1        | 2000   | 03/18/2001        | 5             | No             | 2                       | Petrol | 1000           | 50000 | 10000   | Test      | Test     | 08/08/1962  | Female | Brazil  | 86600000 | Employee   | Other   | 3.000.000,00 | Super Bonus | Full            | Euro Protection | No          | Gold        |
