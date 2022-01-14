package ui.tests.searchEngine;

import org.testng.annotations.Test;
import ui.pages.HomePage;
import ui.pages.SearchEnginePage;
import ui.pages.SearchResultPage;
import ui.tests.BaseTest;

public class SearchEngineTest extends BaseTest {

    @Test
    public void SearchEngine(){


        SearchResultPage searchResultPage = new HomePage(driver)
                .openHomePageWithRedirectToSearchEngine()
                .searchItem("Printed Dress");

        softAssert.assertTrue(searchResultPage.getProductsPreviewCards("Printed Dress"));
    }
}
