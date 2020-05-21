package ash.patz.learning.regex;

import org.apache.commons.lang3.StringUtils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTrials {

    public static final Pattern RESUME_AUTH = Pattern.compile("^/as/([\\w-]+)/resume/as/authorization\\.ping$");

    public static void main(String[] args) throws MalformedURLException {
//        URL aURL = new URL("http://example.com:80/docs/books/tutorial/index.html?name=networking#DOWNLOADING");

        URL aURL = new URL("https://qa.idp.ellielabs.com/as/vbLRs/resume/as/authorization.ping");
//        URL aURL = new URL("https://www.google.com?code=IAxu4Bo17pfkgD86rwzcGqB0El0pYy5lHikIJFcd");
//        URL aURL = new URL("https://www.google.com?code=IAxu4Bo17pfkgD86rwzcGqB0El0pYy5lHikIJFcd&melody=chocolaty");

        System.out.println("protocol = " + aURL.getProtocol());
        System.out.println("authority = " + aURL.getAuthority());
        System.out.println("host = " + aURL.getHost());
        System.out.println("port = " + aURL.getPort());
        System.out.println("path = " + aURL.getPath());
        System.out.println("query = " + aURL.getQuery());
        System.out.println("filename = " + aURL.getFile());
        System.out.println("ref = " + aURL.getRef());


        String CODE_REGEX = "code=(?<code>.*?)(?:(&|$))";
        final Pattern CODE_PATTERN = Pattern.compile(CODE_REGEX);
        final Matcher matcher = CODE_PATTERN.matcher(StringUtils.defaultIfBlank(aURL.getQuery(), StringUtils.EMPTY));

        if (matcher.find()) {
            final String group = matcher.group("code");
            System.out.println(group);
        }

        if(RESUME_AUTH.matcher(aURL.getPath()).matches()) {
            System.out.println(" This is a resume auth call");
        }

    }
}
