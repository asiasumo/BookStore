//package pl.jwoj.sales;
//
//import org.junit.Test;
//
//import static org.junit.Assert.assertThat;
//
//public class SalesTest {
//
//
//	private final Long PRODUCT_ID = 1000L;
//	@Test
//	public void iTAllowsAddingProductToBasket(){
//
//		thereIsClientIdentifiedWith("client_1");
//		SalesFacade salesFacade = thereIsSalesFacade() ;
//		salesFacade.addToBasket(PRODUCT_ID);
//		Basket basket = salesFacade.getBasket();
//
//		assertThat(basket.productsCount()).isEqualTo(1));
//
//
//	}
//
//	private void thereIsClientIdentifiedWith(String client_1) {
//	}
//
//	@Test
//	public void iTAllowsAddingProductToBasket(){
//
//		thereIsClientIdentifiedWith("client_1");
//		SalesFacade salesFacade = thereIsSalesFacade() ;
//		salesFacade.addToBasket(PRODUCT_ID);
//		Basket basketOwnedBy1 = salesFacade.getBasket();
//
//
//		thereIsClientIdentifiedWith("client_2");
//		SalesFacade salesFacade = thereIsSalesFacade() ;
//		salesFacade.addToBasket(PRODUCT_ID);
//		Basket basketOwnedBy1 = salesFacade.getBasket();
//
//		assertThat()
//
//
//	}
//
//	private SalesFacade thereIsSalesFacade() {
//	}
//}
