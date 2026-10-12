package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Helper.Utils;
import Pages.HomePageDecathlon;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageDecathlonStepDef {
	
	@Given("utilisateur est sur la page d'accueil")
	public void utilisateur_est_sur_la_page_d_accueil() throws Exception {
		 Config.driver = new ChromeDriver();
			Config.maximizeWindow();
			//String url= "https://www.decathlon.tn/";
			Config.driver.get(Utils.getProperty("homeDecathlon"));
	}
	@When("utilisateur clique sur meu {string} puis sur le sous-menu {string}")
	public void utilisateur_clique_sur_meu_puis_sur_le_sous_menu(String menuTitle, String submenuTitle) {
		HomePageDecathlon page = new HomePageDecathlon();
		   page.clickOnMenu(menuTitle,submenuTitle);
	}
	@Then("utilisateur est sur la page de {string}")
	public void utilisateur_est_sur_la_page_de(String submenuTitle) {
		HomePageDecathlon page = new HomePageDecathlon();
		   page.verif(submenuTitle);
	}



}
