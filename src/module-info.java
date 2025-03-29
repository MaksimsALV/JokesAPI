module JokesAPI {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;
    requires javafx.base;

    exports application;
    opens application to javafx.fxml, javafx.base;
}