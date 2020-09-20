import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


public class Parser {

    private static Document getPage() throws IOException {
        String url = "https://football.kulichki.net/";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static void main(String[] args) throws IOException {
        Document page = getPage();
        //Element tableResult = getPage().select("div[class=col2 inl vtop]").first();
        Element tableResult = getPage().select("table[style=\"border-collapse: separate;\"]").first();
        Elements rows = tableResult.select("td[bgcolor=\"#F2F2F2\"]");
        for (Element res : rows) {
            String result = res.select("a").text();
            System.out.println(result);
        }
    }
}