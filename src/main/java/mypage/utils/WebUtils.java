package mypage.utils;

import org.springframework.util.StringUtils;

public class WebUtils {

	public static String replaceNonAlphaNumericCharacters(String value) {
		return !StringUtils.isEmpty(value) ? value.replaceAll("[^A-Za-z0-9 ]", "") : "";
	}

	public static String convertToArticleUrl(String value) {
		return replaceNonAlphaNumericCharacters(value).replaceAll("\\s+", " ").trim().replaceAll(" ", "-").toLowerCase();
	}

	public static String getArticleId(String url) {
		String pre = "article-";
		String post = ".html";
		url = url.toLowerCase();
		pre = pre.toLowerCase();
		post = post.toLowerCase();

		int start = url.lastIndexOf(pre);
		if (start == -1) {
			return null;
		}
		start = start + pre.length();
		final String fromStart = url.substring(start);
		final int stop = fromStart.indexOf(post);
		if (stop == -1) {
			return null;
		}
		return fromStart.substring(0, stop);
	}

}
