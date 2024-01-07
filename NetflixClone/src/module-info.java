module Browser {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.web;
	requires javafx.base;
	requires json.simple;
	
	opens application to javafx.graphics, javafx.fxml;
}
