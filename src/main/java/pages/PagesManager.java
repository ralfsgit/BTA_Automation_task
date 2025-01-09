package pages;


public class PagesManager extends BasePage {

    public HomePage homePage;
    public TravelInsurancePage travelInsurancePage;
    public PersonalizedOfferPage personalizedOfferPage;
    public TravelersPage travelersPage;


    public PagesManager() {

        this.homePage = new HomePage();
        this.travelInsurancePage = new TravelInsurancePage();
        this.personalizedOfferPage = new PersonalizedOfferPage();
        this.travelersPage = new TravelersPage();
    }
}


