package id.ten.forumservices.utils;

public class EmailUtil {

    public static String generateVerificationEmail(String verificationCode) {
        String email = "<!doctype html>\n" + "<html>\n"
                + "  <head>\n"
                + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "  </head>\n"
                + "  <body style=\"font-family: sans-serif;\">\n"
                + "    <div style=\"display: block; margin: auto; max-width: 600px;\" class=\"main\">\n"
                + "      <h1 style=\"font-size: 18px; font-weight: bold; margin-top: 20px\">Congrats for sending test email with Mailtrap!</h1>\n"
                + "      <p>If you are viewing this email in your inbox – the integration works.</p>\n"
                + "      <img alt=\"Inspect with Tabs\" src=\"https://assets-examples.mailtrap.io/integration-examples/welcome.png\" style=\"width: 100%;\">\n"
                + "      <p>Now send your email using our SMTP server and integration of your choice!</p>\n"
                + "      <p>Good luck! Hope it works.</p>\n"
                + "    </div>\n"
                + "    <!-- Example of invalid for email html/css, will be detected by Mailtrap: -->\n"
                + "    <style>\n"
                + "      .main { background-color: white; }\n"
                + "      a:hover { border-left-width: 1em; min-height: 2em; }\n"
                + "    </style>\n"
                + "  </body>\n"
                + "</html>";
        return email;
    }
}
