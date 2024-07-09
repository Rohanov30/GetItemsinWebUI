package food_del;

import java.io.IOException;

import org.testng.annotations.Test;

public class login_taco extends BaseUI {

	@Test
	public void openTaco() throws InterruptedException{ try {
		{
			evokeBrowser();
			openURL("https://www.tacobell.com");
			ClickMenu();
			checkpageTitle();
			checkDisplay();
			getItems();
			closeBrowser();
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}

}
}


