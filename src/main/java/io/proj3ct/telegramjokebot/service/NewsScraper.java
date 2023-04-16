package io.proj3ct.telegramjokebot.service;

import com.google.gson.Gson;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class NewsScraper {

    private static final String URL = "https://www.securitylab.ru/news/";
    private static final String USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (HTML, like Gecko) Chrome/90.0.4430.212 Safari/537.36";
    private static final String FILE_PATH = "news_dict.json";

    public static void main(String[] args) {
        // get_first_news();
        System.out.println(check_news_update());
    }

    private static void get_first_news() {
        try {
            Map<String, Map<String, String>> newsDict = new HashMap<>();
            Document doc = Jsoup.connect(URL).userAgent(USER_AGENT).get();
            Elements articleCards = doc.select("a.article-card");
            for (Element article : articleCards) {
                String articleTitle = article.select("h2.article-card-title").text().trim();
                String articleDesc = article.select("p").text().trim();
                String articleUrl = "https://www.securitylab.ru" + article.attr("href");

                String articleDateTime = article.select("time").attr("datetime");
                LocalDateTime dateFromIso = LocalDateTime.parse(articleDateTime);
                String dateTime = dateFromIso.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                long articleDateTimeStamp = java.sql.Timestamp.valueOf(dateTime).getTime();

                String articleId = articleUrl.substring(articleUrl.lastIndexOf("/") + 1, articleUrl.length() - 4);

                newsDict.put(articleId, new HashMap<>());
                newsDict.get(articleId).put("article_date_timestamp", String.valueOf(articleDateTimeStamp));
                newsDict.get(articleId).put("article_title", articleTitle);
                newsDict.get(articleId).put("article_url", articleUrl);
                newsDict.get(articleId).put("article_desc", articleDesc);
            }

            try (FileWriter file = new FileWriter(FILE_PATH)) {
                file.write(new Gson().toJson(newsDict));
            } catch (IOException e) {
                Logger.getLogger(NewsScraper.class.getName()).log(Level.SEVERE, null, e);
            }
        } catch (IOException e) {
            Logger.getLogger(NewsScraper.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private static Map<String, Map<String, String>> check_news_update() {
        Map<String, Map<String, String>> freshNews = new HashMap<>();
        try {
            Map<String, Map<String, String>> newsDict;
            Document doc = Jsoup.connect(URL).userAgent(USER_AGENT).get();
            Elements articleCards = doc.select("a.article-card");
            newsDict = new Gson().fromJson(new FileReader(FILE_PATH), Map.class);
            for (Element article : articleCards) {
                String articleUrl = "https://www.securitylab.ru" + article.attr("href");
                String articleId = articleUrl.substring(articleUrl.lastIndexOf("/") + 1, articleUrl.length() - 4);

                if (newsDict.containsKey(articleId)) {
                } else {
                    String articleTitle = article.select("h2.article-card-title").text().trim();
                    String articleDesc = article.select("p").text().trim();

                    String articleDateTime = article.select("time").attr("datetime");
                    LocalDateTime dateFromIso = LocalDateTime.parse(articleDateTime);
                    String dateTime = dateFromIso.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                    long articleDateTimeStamp = java.sql.Timestamp.valueOf(dateTime).getTime();

                    Map<String, String> newsData = new HashMap<>();
                    newsData.put("article_date_timestamp", String.valueOf(articleDateTimeStamp));
                    newsData.put("article_title", articleTitle);
                    newsData.put("article_url", articleUrl);
                    newsData.put("article_desc", articleDesc);

                    freshNews.put(articleId, newsData);
                }
            }

            // Обновите файл словаря новостей свежими новостными данными.
            if (!freshNews.isEmpty()) {
                newsDict.putAll(freshNews);
                try (FileWriter file = new FileWriter(FILE_PATH)) {
                    file.write(new Gson().toJson(newsDict));
                } catch (IOException e) {
                    Logger.getLogger(NewsScraper.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        } catch (IOException e) {
            Logger.getLogger(NewsScraper.class.getName()).log(Level.SEVERE, null, e);
        }
        return freshNews;
    }


}
