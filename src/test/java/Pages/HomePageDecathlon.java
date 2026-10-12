package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class HomePageDecathlon {

	@FindBy(xpath="/html/body/os-header/header/section/nav/ul/li/button")
	List<WebElement> menus;
	
	@FindBy(xpath="/html/body/os-header/header/section/nav/ul/li[4]/div/div[2]/nav/ul/li[2]/ul/li/a\r\n")
	List<WebElement> subMenus;
	
	@FindBy(xpath="/html/body/main/div[1]/div/h1/span")
	WebElement verif;
	
	@FindBy(id="didomi-notice-agree-button")
	WebElement accepterfermer;
	
	public HomePageDecathlon() {
		PageFactory.initElements(Config.driver, this);
	}
	
	public void clickOnMenu(String menuTitle, String submenuTiltle) {
		Config.attente(10);
		accepterfermer.click();
		try {
			for (WebElement menu:menus) {
				if (menu.getText().contains(menuTitle)) {
					menu.click();
					for (WebElement submenu:subMenus) {
						if (submenu.getText().contains(submenuTiltle)) {
							submenu.click();
						}
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void verif (String submenuT) {
		Assert.assertEquals(verif.getText(), submenuT);
	}
}
