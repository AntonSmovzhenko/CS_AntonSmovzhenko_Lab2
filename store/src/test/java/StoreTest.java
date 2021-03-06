import org.example.Article;
import org.example.Group;
import org.example.Store;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StoreTest {



    @Test
    public void shouldAddAGroup() throws Exception {
        Store store = new Store();
        Group group = new Group("Vegetables");
        store.addGroup(group);
        Assertions.assertTrue(store.getGroups().contains(group));
    }

    @Test
    public void shouldCreateEmptyStore() {
        Store store = new Store();
        int expectedSize = 0;
        Assertions.assertEquals(expectedSize, store.getGroups().size());
    }

    @Test
    public void shouldGetAmountOfArticle() throws Exception {
        Store store = new Store();
        Group group = new Group("Vegetables");
        store.addGroup(group);
        Article article = new Article("Onion", 11, 100);
        store.addArticleToGroup(article, group.getName());
        int expectedAmount = article.getAmount();
        Assertions.assertEquals(expectedAmount, store.getAmountOfArticle(article.getName()));
    }

    @Test
    public void shouldAddArticle() throws Exception {
        Store store = new Store();
        Group group = new Group("Vegetables");
        store.addGroup(group);
        Article article = new Article("Onion", 12, 66);
        store.addArticleToGroup(article, group.getName());
        Assertions.assertTrue(store.getAllArticles().contains(article));
    }


    @Test
    public void shouldIncrementAmountOfArticle() throws Exception {
        Store store = new Store();
        Group group = new Group("Vegetables");
        store.addGroup(group);
        Article article = new Article("Onion", 47, 1000);
        store.addArticleToGroup(article, group.getName());
        int increment = 50;
        int expectedAmount = article.getAmount() + increment;
        store.incrementArticle(article.getName(), increment);
        Assertions.assertEquals(expectedAmount, store.getAmountOfArticle(article.getName()));
    }



    @Test
    public void shouldSetPriceOfArticle() throws Exception {
        Store store = new Store();
        Group group = new Group("Vegetables");
        store.addGroup(group);
        Article article = new Article("Onion", 4, 1);
        store.addArticleToGroup(article, group.getName());
        int price = 50;
        store.setPriceForArticle(article.getName(), price);
        Assertions.assertEquals(price, store.findArticle(article.getName()).getPrice());
    }
}
