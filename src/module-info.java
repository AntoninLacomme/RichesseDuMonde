module richessesdumonde.client {
	requires java.base;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.controls;
	requires java.desktop;
	requires javafx.base;
	requires java.xml;
	exports client;
	exports client.controllers;
	opens client.controllers;
}