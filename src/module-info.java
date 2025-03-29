module JokesAPI {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;

    opens application to javafx.fxml;
}